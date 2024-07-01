
package com.works.restcontrollers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginRestController {
    
    final CustomerService customerService;
    
    
    @PostMapping("customerLogin")
    public boolean login( @RequestBody Customer customer ) {
        return customerService.login(customer);
    }
    
}
