/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.works.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.works.entities.Customer;
import com.works.models.Product;
import com.works.repositories.CustomerRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerService {
    
    final ObjectMapper objectMapper;
    final CustomerRepository customerRepository;
    
    public boolean login(Customer customer) {
        Optional<Customer> optional = customerRepository.findByEmailAndPasswordEquals(customer.getEmail(), customer.getPassword());
        boolean status = optional.isPresent();
        if (status) {
            Customer c = optional.get();
            System.out.println(c);
        }
        return status;
    }
    
    
    public void addProduct() {
        
        RestTemplate restTemplate = new RestTemplate();
        
        String url = "https://dummyjson.com/products/add";
        Product product = new Product();
        product.setTitle("TV");
        
        String sendData = "";
        try {
            sendData = objectMapper.writeValueAsString(product);
        } catch (Exception e) {
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(sendData, headers);
        
        ResponseEntity<Product> entity = restTemplate.postForEntity(url, httpEntity, Product.class);
        
        System.out.println(entity.getBody());

    }
    
    
    
}
