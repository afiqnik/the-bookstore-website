package com.YP.bookstore.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import com.YP.bookstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.YP.bookstore.model.Product;
import com.YP.bookstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController is the main controller for handling the home page requests.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    /**
     * Adds attributes to the model before handling requests. This method sets the
     * log attribute
     * based on the user's authentication status.
     *
     * @param principal the currently authenticated user
     * @param model     the model to add attributes to
     */
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

    /**
     * Handles GET requests to the root URL ("/"). This method retrieves lists of
     * new arrivals and
     * bestsellers, shuffles them, and limits them to 4 items each. These lists are
     * then added to
     * the model to be displayed on the home page.
     *
     * @param model     the model to add attributes to
     * @param principal the currently authenticated user
     * @return the name of the view to be rendered
     */
    @GetMapping("/")
    public String listProducts(Model model, Principal principal) {
        List<Product> newArrivals = productService.getNewArrivalsProducts();
        List<Product> bestSellers = productService.getBestsellerProducts();

        // Shuffle the lists to randomize the order of products
        Collections.shuffle(newArrivals);
        Collections.shuffle(bestSellers);

        // Limit the lists to 4 items each
        List<Product> randomNewArrivals = newArrivals.stream().limit(4).collect(Collectors.toList());
        List<Product> randomBestSellers = bestSellers.stream().limit(4).collect(Collectors.toList());

        // Add the limited lists to the model
        model.addAttribute("newArrivals", randomNewArrivals);
        model.addAttribute("bestSellers", randomBestSellers);

        logger.info("Listing 4 random products for new arrival & best sellers section");

        return "index"; // Return the name of the view to be rendered
    }
}
