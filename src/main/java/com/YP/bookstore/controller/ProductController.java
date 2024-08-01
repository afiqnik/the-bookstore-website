package com.YP.bookstore.controller;

import com.YP.bookstore.model.CartItem;
import com.YP.bookstore.model.Product;
import com.YP.bookstore.service.CartService;
import com.YP.bookstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/cart")
    public String viewCarts(Model model){
        logger.info("Viewing cart after adding product");
        List<CartItem> cart = cartService.getAllCarts();
        model.addAttribute("cart", cart);
        for(CartItem troli:cart){
            logger.info("Product :"+troli.getProduct().getId()+" retrieved with quantity: "+troli.getQuantity());
        }

        return "/cart";
    }

    @RequestMapping("/addToCart/{id}")
    public String addtoCart(@PathVariable Long id){
        Product product = productService.getProductById(id);

        logger.info("Adding product "+ product.getId()+" to cart");

        cartService.addtoCart(id,1L);
        return "redirect:/cart";
    }

    // @GetMapping("/addToCart/{productId}")
    // public String cartier(){
    //     // Product product = productService.getProductById(productid);

    //     logger.info("get method of addtocart");

    //     // cartService.addtoCart(productid,1L);
    //     return "redirect:/cart";
    // }
}
