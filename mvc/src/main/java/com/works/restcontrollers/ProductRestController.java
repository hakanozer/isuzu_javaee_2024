
package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductRestController {
    
    final ProductService productService;
    
    @PostMapping("save")
    public Product save( @Valid @RequestBody Product product ) {
        return productService.save(product);
    }
    
    @GetMapping("list")
    public List<Product> list() {
        return productService.list();
    }
    
    @GetMapping("delete/{stPid}")
    public boolean delete(@PathVariable String stPid) {
        return productService.delete(stPid);
    }
    
    @PostMapping("update")
    public Product update( @Valid @RequestBody Product product ) {
        return productService.update(product);
    }

}
