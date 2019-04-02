/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenge.capgemini.rest.services.my.bank.repository;

import com.challenge.capgemini.rest.services.my.bank.entities.Customer;
import com.challenge.capgemini.rest.services.my.bank.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author LuisLeon
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>{
    
}
