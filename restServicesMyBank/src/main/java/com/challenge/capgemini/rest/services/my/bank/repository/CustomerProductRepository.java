/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenge.capgemini.rest.services.my.bank.repository;

import com.challenge.capgemini.rest.services.my.bank.entities.CustomerProduct;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author LuisLeon
 */
public interface CustomerProductRepository extends PagingAndSortingRepository<CustomerProduct, Integer>{
    
    @Query(value ="from CustomerProduct cp where cp.customerId.customerId = :customerId")
    List<CustomerProduct> findByCustomerId( @Param("customerId") String customerId);
    
}
