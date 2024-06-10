
package com.works.repositories;

import com.works.entities.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
    // select * from customer where email = ? and password = ?
    Optional<Customer> findByEmailAndPasswordEquals(String email, String password); 
    
}
