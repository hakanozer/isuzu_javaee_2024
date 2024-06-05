
package com.works.controllers;


import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
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
    
    private final CustomerRepository customerRepository;
    
    @GetMapping("/")
    public String index( Model model ) {
        model.addAttribute("title", "App Title");
        
        List<Customer> ls = customerRepository.findAll();
        for(Customer item : ls) {
            System.out.println(item);
        }
        
        // select * from customer where cid = ?
        Optional<Customer> optional = customerRepository.findById(1l);
        if (optional.isPresent()) {
            Customer c = optional.get();
            System.out.println(c);
        }
        
        
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
