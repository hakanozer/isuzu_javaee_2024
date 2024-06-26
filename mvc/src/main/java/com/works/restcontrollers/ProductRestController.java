
package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductRestController {
    
    final ProductService productService;
    
    @PostMapping("productSave")
    public Product save( @RequestBody Product product ) {
        return productService.save(product);
    }
    
    
}
