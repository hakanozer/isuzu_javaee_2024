
package com.works.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Data
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    
    @NotNull
    @NotEmpty
    private String title;
    
    @NotNull
    @NotEmpty
    private String detail;
    
    
    @NotNull
    @Min(value = 1)
    @Max(value = 5000000)
    private Integer price;
    
}
