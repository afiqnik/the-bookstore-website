package com.YP.bookstore.controller;


import java.util.List;

import com.YP.bookstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.YP.bookstore.model.Product;
import com.YP.bookstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
 @RequestMapping("/")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;




    @GetMapping("/")
    public String listProducts(Model model) {
        List<Product> newArrivals = productService.getNewArrivalsProducts();
        List<Product> bestSellers = productService.getBestsellerProducts();
        model.addAttribute("newArrivals", newArrivals);
        model.addAttribute("bestSellers", bestSellers);

        logger.info("Listing all the products");


        return "index";
    }



}
