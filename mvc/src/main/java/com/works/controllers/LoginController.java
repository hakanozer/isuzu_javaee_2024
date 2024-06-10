
package com.works.controllers;


import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import com.works.services.CustomerService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class LoginController {
    
    final CustomerService customerService;
    
    
    @GetMapping("/")
    public String index( Model model ) {
        customerService.addProduct();
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
        boolean status = customerService.login(customer);
        System.out.println("Login Status : " + status);
        return "login";
    }
    
    
}
