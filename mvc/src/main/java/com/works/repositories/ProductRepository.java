
package com.works.repositories;

import com.works.entities.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long>{
    
    // select * from product where title like '%q%'
    List<Product> findByTitleContainsOrDetailContains(String title, String detail);
    
}
