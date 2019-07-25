package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping(value = "/register", method=RequestMethod.GET)
    public String processRegistration(@Valid
                                          @ModelAttribute("user") User user, BindingResult result, Model model){
        model.addAttribute("user", user);
        if (result.hasErrors()){
            return "registration";
        }
        else{
            userService.saveUser(user);
            model.addAttribute("message", "User Account Created");
        }
        return "index";
    }


    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/secure")
    public String secure(){
        return "secure";
    }

}
