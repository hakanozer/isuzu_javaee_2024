
package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    final ProductRepository productRepository;
    
    public Product save( Product product ) {
        return productRepository.save(product);
    }
    
    public List<Product> list() {
        return productRepository.findAll();
    }
    
    public boolean delete( String stPid ) {
        try {
            long pid = Long.parseLong(stPid);
            Optional<Product> optional = productRepository.findById(pid);
            if (optional.isPresent()) {
                productRepository.deleteById(pid);
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    } 
    
    public Product update( Product product ) {
        productRepository.saveAndFlush(product);
        return product;
    }
    
    
}
