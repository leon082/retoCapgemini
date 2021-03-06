/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenge.capgemini.rest.services.my.bank.repository;

import com.challenge.capgemini.rest.services.my.bank.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Luis Leon
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer>{
    	@Query(value = "FROM Customer u WHERE u.customerId = :customerId")
    Customer findByCustomerID(@Param("customerId") String customerId);
   
}
