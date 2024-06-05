
package com.works.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;
    
    @Column(length = 300)
    private String name;
    
    private String surname;
    private String email;
    private String password;
    private Integer age;
    
    
}
