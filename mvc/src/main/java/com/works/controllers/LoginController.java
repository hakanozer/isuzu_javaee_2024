
package com.works.controllers;


import com.works.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    
    
    @GetMapping("/")
    public String index( Model model ) {
        model.addAttribute("title", "App Title");
        return "login";
    }
    
    
    /*
    @PostMapping("login")
    public String login( 
            @RequestParam String email, 
            @RequestParam String password ) {
        System.out.println(email + " - " + password);
        return "login";
    }
    */
    
    @PostMapping("login")
    public String login( Customer customer ) {
        //System.out.println(customer.getEmail() + " - " + customer.getPassword());
        System.out.println(customer);
        return "login";
    }
    
    
}
