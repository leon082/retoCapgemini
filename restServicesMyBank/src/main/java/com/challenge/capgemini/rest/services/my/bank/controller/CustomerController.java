/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenge.capgemini.rest.services.my.bank.controller;


import com.challenge.capgemini.rest.services.my.bank.DTO.CustomerProductDTO;
import com.challenge.capgemini.rest.services.my.bank.entities.Customer;
import com.challenge.capgemini.rest.services.my.bank.entities.CustomerProduct;
import com.challenge.capgemini.rest.services.my.bank.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis Leon
 */
@RestController
@RequestMapping("/api/1.0")
public class CustomerController {
    
    @Autowired
    CustomerServices customerServices;
    
    
    @PostMapping(value = "/customer/sign-up")
    public String signUp(@RequestBody Customer customer){
        return customerServices.createCustomer(customer);
    }
    
    @GetMapping(value = "/customer/{customerId}/get")
    public Customer getCustomerByCustomerId(@PathVariable(value = "customerId" ) String customerId){
        return customerServices.findByCustomerID(customerId);
    }
    
    @GetMapping(value = "/product/{customerId}/get")
    public Iterable<CustomerProductDTO> getProductsByCustomerId(@PathVariable(value = "customerId" ) String customerId){
        return customerServices.findProductByCustomerID(customerId);
    }
    
    
            
    
}
