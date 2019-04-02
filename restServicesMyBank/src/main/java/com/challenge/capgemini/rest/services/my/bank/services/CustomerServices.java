/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenge.capgemini.rest.services.my.bank.services;

import com.challenge.capgemini.rest.services.my.bank.DTO.CustomerProductDTO;
import com.challenge.capgemini.rest.services.my.bank.entities.Customer;
import com.challenge.capgemini.rest.services.my.bank.entities.CustomerProduct;
import com.challenge.capgemini.rest.services.my.bank.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.challenge.capgemini.rest.services.my.bank.repository.CustomerProductRepository;
import java.util.ArrayList;

/**
 *
 * @author LuisLeon
 */
@Service
public class CustomerServices {

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private CustomerProductRepository customerProductRepository;
    
    public String createCustomer (Customer customer){
        if(customer == null){
            return "";
        }else if( customerRepository.save(customer) != null){
            return "Customer created successfull";
        }else{
            return "";
        }
    }
    
    public Customer findByCustomerID(@Param("customerId") String customerId){
        if(!"".equalsIgnoreCase(customerId)){
            return customerRepository.findByCustomerID(customerId);
        }else{
            return new Customer();
        }
    }
    
      public List<CustomerProductDTO> findProductByCustomerID(@Param("customerId") String customerId){
            List<CustomerProduct> cp =  customerProductRepository.findByCustomerId(customerId);  
            List<CustomerProductDTO> listDto = new ArrayList<>();
            
            cp.stream().map((item)-> {
                CustomerProductDTO dto = new CustomerProductDTO();
                dto.setCustomerId(item.getCustomerId().getCustomerId());
                dto.setProductName(item.getProductId().getName());
                dto.setProductNumber(item.getProductNumber());
                dto.setBalance(item.getBalance());
                dto.setCreationDate(item.getCreationDate());
                dto.setTerminationDate(item.getTerminationDate());
                dto.setStatus(item.getStatus());
                return dto;
            }).forEach(dto-> listDto.add(dto));
            
            
     return listDto;   
    }
}
