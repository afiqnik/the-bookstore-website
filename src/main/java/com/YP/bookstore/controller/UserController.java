package com.YP.bookstore.controller;

import com.YP.bookstore.model.User;
import com.YP.bookstore.model.UserDto;
import com.YP.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

/**
 * Controller class to handle user-related actions such as registration, login,
 * and displaying the home page.
 */
@Controller
public class UserController {

    // Injecting the UserDetailsService to load user-specific data.
    @Autowired
    private UserDetailsService userDetailsService;

    // Injecting the UserService to handle user-related business logic.
    @Autowired
    private UserService userService;

    /**
     * Constructor for UserController.
     * 
     * @param userService the service to handle user operations
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Handler for the home page.
     * 
     * @param model     the model to pass attributes to the view
     * @param principal the currently authenticated user
     * @return the name of the view to be rendered
     */
    @GetMapping("/index")
    public String home(Model model, Principal principal) {
        // Load user details using the username from the authenticated principal.
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        // Add user details to the model to be used in the view.
        model.addAttribute("userdetail", userDetails);
        return "index"; // Return the name of the view for the home page.
    }

    /**
     * Handler for the login page.
     * 
     * @param model     the model to pass attributes to the view
     * @param userDto   the user data transfer object
     * @param principal the currently authenticated user (if any)
     * @return the name of the view to be rendered
     */
    @GetMapping("/login")
    public String login(Model model, UserDto userDto, Principal principal) {
        // Add a new UserDto object to the model.
        model.addAttribute("user", userDto);
        return "login"; // Return the name of the view for the login page.
    }

    /**
     * Handler for the registration page.
     * 
     * @param model   the model to pass attributes to the view
     * @param userDto the user data transfer object
     * @return the name of the view to be rendered
     */
    @GetMapping("/register")
    public String register(Model model, UserDto userDto) {
        // Add a new UserDto object to the model.
        model.addAttribute("user", userDto);
        return "register"; // Return the name of the view for the registration page.
    }

    /**
     * Handler for processing user registration.
     * 
     * @param userDto the user data transfer object containing registration
     *                information
     * @param model   the model to pass attributes to the view
     * @return a redirect string indicating the outcome of the registration
     */
    @PostMapping("/register")
    public String registerSava(@ModelAttribute("user") UserDto userDto, Model model) {
        // Check if the username already exists.
        User user = userService.findByUsername(userDto.getUsername());
        if (user != null) {
            // If the user exists, add an attribute to the model and return the registration
            // view.
            model.addAttribute("Userexist", user);
            return "register";
        }
        // If the user does not exist, save the new user and redirect to the
        // registration page with a success message.
        userService.save(userDto);
        return "redirect:/register?success";
    }
}
