package com.YP.bookstore.controller;

import com.YP.bookstore.model.CartItem;
import com.YP.bookstore.model.Orders;
import com.YP.bookstore.model.Product;
import com.YP.bookstore.model.User;
import com.YP.bookstore.service.CartService;
import com.YP.bookstore.service.OrderService;
import com.YP.bookstore.service.ProductService;
import com.YP.bookstore.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    private User getUserDetails(Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);

        return user;
    }

    @ModelAttribute
    public void addAttribute(Principal principal, Model model) {
        String login = "Login";
        String logout = "Logout";
        if (principal != null) {
            model.addAttribute("log", logout);
        } else {
            model.addAttribute("log", login);
        }
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        try {
            List<Product> products = productService.getAllProducts();
            logger.info("Products retrieved: " + products.size());
            model.addAttribute("products", products);
            return "products";
        } catch (Exception e) {
            logger.error("Error retrieving products", e);
            model.addAttribute("errorMessage", "Error retrieving products");
            return "error";
        }
    }

    @GetMapping("/product/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        try {
            Product product = productService.getProductById(id);
            if (product == null) {
                model.addAttribute("errorMessage", "Product not found");
                return "error";
            }
            logger.info("Product retrieved: " + product.getTitle());
            model.addAttribute("product", product);
            return "product";
        } catch (Exception e) {
            logger.error("Error retrieving product details", e);
            model.addAttribute("errorMessage", "Error retrieving product details");
            return "error";
        }
    }

    @GetMapping("/new-arrivals")
    public String viewNewArrivalsProducts(Model model) {
        try {
            List<Product> products = productService.getNewArrivalsProducts();
            if (products == null || products.isEmpty()) {
                model.addAttribute("errorMessage", "No new arrivals products found");
                return "error";
            }
            logger.info("New arrivals products retrieved: " + products.size() + " products");
            model.addAttribute("products", products);
            return "newArrivals";
        } catch (Exception e) {
            logger.error("Error retrieving new arrivals products", e);
            model.addAttribute("errorMessage", "Error retrieving new arrivals products");
            return "error";
        }
    }

    @GetMapping("/best-sellers")
    public String viewBestsellerProducts(Model model) {
        try {
            List<Product> products = productService.getBestsellerProducts();
            if (products == null || products.isEmpty()) {
                model.addAttribute("errorMessage", "No bestseller products found");
                return "error";
            }
            logger.info("Bestseller products retrieved: " + products.size() + " products");
            model.addAttribute("products", products);
            return "bestSellers";
        } catch (Exception e) {
            logger.error("Error retrieving bestseller products", e);
            model.addAttribute("errorMessage", "Error retrieving bestseller products");
            return "error";
        }
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam(name = "title") String title, Model model) {
        List<Product> searchResults = productService.searchBooks(title, title);
        logger.info("Product retrieved: " + searchResults.size());
        model.addAttribute("searchResults", searchResults);
        model.addAttribute("searchtitle", title);
        return "/searchResults";
    }

    @GetMapping("/cart")
    public String viewCarts(Model model, Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Double total = 0.0;
        if (auth.isAuthenticated()) {
            User user = getUserDetails(principal);
            logger.info("Viewing cart after adding product");
            List<CartItem> emptyCart = new ArrayList<CartItem>();
            List<CartItem> cart = cartService.getCartbyUser(user.getId());
            for (CartItem carts : cart) {
                if (carts.getOrder() != null) {
                    continue;
                } else {
                    logger.info("adding to empty carts");
                    emptyCart.add(carts);
                }
            }
            model.addAttribute("cart", emptyCart);
            for (CartItem troli : emptyCart) {
                logger.info(
                        "Product :" + troli.getProduct().getId() + " retrieved with quantity: " + troli.getQuantity());
                total += troli.getPrice();
            }
            model.addAttribute("total", total);

            return "/User/cart";
        }
        return "redirect:/login";
    }

    @RequestMapping("/addToCart/{id}")
    public String addtoCart(@PathVariable Long id, Principal p) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth.isAuthenticated()) {
            Product product = productService.getProductById(id);
            User user = getUserDetails(p);

            logger.info("Adding product " + product.getId() + " to cart");

            cartService.addtoCart(id, user.getId(),null);
            return "redirect:/cart";
        }

        return "redirect:/login";
    }

    @RequestMapping("/updateQuantity/{id}/{action}")
    public String updateQuantity(@PathVariable Long id, @PathVariable String action) {

        logger.info("Updating quantity of cart item");
        cartService.updateQuantity(id, action);
        return "redirect:/cart";
    }

    @RequestMapping("/deleteCart/{id}")
    public String deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return "redirect:/cart";
    }

    @RequestMapping("/createOrder")
    public String userOrder(Model model, Principal principal) {
        logger.info("Creating order...");
        List<CartItem> emptyCart = new ArrayList<CartItem>();
        User user = getUserDetails(principal);
        List<CartItem> cart = cartService.getCartbyUser(user.getId());
        for (CartItem carts : cart) {
            if (carts.getOrder() != null) {
                logger.info("Viewing added empty carts");
                continue;
            } else {
                emptyCart.add(carts);
            }
        }
        Orders orders = orderService.createOrder(emptyCart, user);
        model.addAttribute("orders", orders);
        // model.addAttribute("user", orders.getUser());
        return "orderSummary";
    }

    @RequestMapping("/order")
    public String viewOrder(Model model, Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth.isAuthenticated()) {
            logger.info("Viewing order...");
            User user = getUserDetails(principal);
            List<Orders> orders = orderService.viewOrders(user);
            model.addAttribute("orders", orders);
            // model.addAttribute("user", orders);
            return "orderSummary";
        }
        return "redirect:/login";
    }
}
