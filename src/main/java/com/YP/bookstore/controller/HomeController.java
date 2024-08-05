package com.YP.bookstore.controller;


import java.security.Principal;
import java.util.List;

import com.YP.bookstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.YP.bookstore.model.Product;
import com.YP.bookstore.model.User;
import com.YP.bookstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
 @RequestMapping("/")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @ModelAttribute
    public void addAttribute(Principal principal,Model model){
        String login= "Login";
        String logout = "Logout";
        if(principal!=null){
            model.addAttribute("log", logout);
        }else{
            model.addAttribute("log", login);
        }
    }

    @GetMapping("/")
    public String listProducts(Model model,Principal principal) {
        List<Product> newArrivals = productService.getNewArrivalsProducts();
        List<Product> bestSellers = productService.getBestsellerProducts();
        model.addAttribute("newArrivals", newArrivals);
        model.addAttribute("bestSellers", bestSellers);
        logger.info("Listing all the products");

        return "index";
    }



}
