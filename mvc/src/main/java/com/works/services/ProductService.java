
package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    final ProductRepository productRepository;
    
    public Product save( Product product ) {
        return productRepository.save(product);
    }
    
    public Page<Product> list(int pageCount, int size) {
        int endSize = 10;
        if (size < 51) {
            endSize = size;
        }
        Pageable pageable = PageRequest.of(pageCount, endSize);
        Page<Product> page = productRepository.findAll(pageable);
        return page;
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
    
    public List<Product> saveAll( List<Product> products ) {
        return productRepository.saveAll(products);
    }
    
    public List<Product> search(String q) {
        return productRepository.findByTitleContainsOrDetailContains(q, q);
    }
    
    
}
