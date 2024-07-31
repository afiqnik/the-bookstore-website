package com.YP.bookstore.controller;

import com.YP.bookstore.entity.Product;
import com.YP.bookstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String listProducts(Model model) {
        List<Product> newArrivals = productService.getNewArrivalsProducts();
        List<Product> bestSellers = productService.getBestsellerProducts();
        model.addAttribute("newArrivals", newArrivals);
        model.addAttribute("bestSellers", bestSellers);

        return "index";
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }
}
