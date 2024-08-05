package com.YP.bookstore.controller;


import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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
        Collections.shuffle(newArrivals); // Shuffle the list to randomize
        Collections.shuffle(bestSellers);
        List<Product> randomNewArrivals = newArrivals.stream().limit(4).toList(); // Limit to 4 items
        List<Product> randomBestSellers = bestSellers.stream().limit(4).toList();
        model.addAttribute("newArrivals", randomNewArrivals);
        model.addAttribute("bestSellers", randomBestSellers);

        logger.info("Listing 4 random products for new arrival & best sellers section");

        return "index";
    }



}
