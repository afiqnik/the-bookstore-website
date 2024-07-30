package com.YP.bookstore.controller;

// import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.YP.bookstore.model.User;
import com.YP.bookstore.service.UserService;


@Controller
@RequestMapping("/")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserService userService;

    @ModelAttribute
    public void getUserDeets(Model model){
        List<User> user = userService.getAllUsers();
        model.addAttribute("user", user);
    }
    @GetMapping("/")
    public String index(/*Model model*/){
        List <User> user = userService.getAllUsers();
        // model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/home")
    public String home(/*Model model*/){
        try{
            List<User> user = userService.getAllUsers();
            logger.info("Users retrieved: "+user.size() );
            // model.addAttribute("user", user);
        }
        catch(Exception e){
            return "home";
        }

        return "home";
    }

    @GetMapping("/login")
    public String login(){




        return "login";
    }
}
