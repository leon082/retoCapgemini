/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenge.capgemini.rest.services.my.bank.controller;

import com.challenge.capgemini.rest.services.my.bank.entities.Product;
import com.challenge.capgemini.rest.services.my.bank.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LuisLeon
 */
@RestController
@RequestMapping("/api/1.0")
public class ProductController {
  @Autowired
    ProductServices productServices;
     
    
    @GetMapping(value = "/product/get")
    public Iterable<Product> getAllProducts(){
        return productServices.getAllProducts();
    }   
}
