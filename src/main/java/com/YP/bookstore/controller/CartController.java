package com.YP.bookstore.controller;

import com.YP.bookstore.model.CartItem;
import com.YP.bookstore.model.Product;
import com.YP.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")

public class CartController {

    Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;


    // @GetMapping
    // public String viewCarts(Model model) {
    //     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //     if (auth.isAuthenticated()) {
    //         // logic to show the cart
    //         logger.info("Viewing cart after adding product");
    //         List<CartItem> cart = cartService.getAllCarts();

    //         List<Product> products = new ArrayList<Product>();
    //         for (CartItem cartItem : cart) {
    //             products.add(cartItem.getProduct());
    //         }
    //         model.addAttribute("product", products);
    //         model.addAttribute("cart", cart);
    //         for (CartItem troli : cart) {
    //             logger.info("Product :" + troli.getProduct().getId() + " retrieved with quantity: " + troli.getQuantity());
    //         }
    //         return "User/cart";

    //     }
    //     return "redirect:/login";
    // }
}