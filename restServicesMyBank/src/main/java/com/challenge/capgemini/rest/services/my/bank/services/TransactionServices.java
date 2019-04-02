/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenge.capgemini.rest.services.my.bank.services;

import com.challenge.capgemini.rest.services.my.bank.DTO.TransactionDTO;
import com.challenge.capgemini.rest.services.my.bank.entities.Customer;
import com.challenge.capgemini.rest.services.my.bank.entities.Transaction;
import com.challenge.capgemini.rest.services.my.bank.repository.CustomerRepository;
import com.challenge.capgemini.rest.services.my.bank.repository.TransactionRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author LuisLeon
 */
@Service
public class TransactionServices {

    @Autowired
    TransactionRepository transactionRepository;
    
    @Autowired
    CustomerRepository customerRepository;

    public List<TransactionDTO> getLastTransactions(Integer limit, String customerId, String productNumber) {
        
         List<Transaction> result;
         List<TransactionDTO> listResult = new ArrayList<>();
        
        Pageable p = PageRequest.of(0, limit);
        result = transactionRepository.lastTransaction(customerId, productNumber, p);
        
        
         
         result.stream().map((itemFound) -> {
             TransactionDTO dto = new TransactionDTO();
             Transaction item = (Transaction) itemFound;
             dto.setAmount(item.getAmount());
             dto.setChannelId(String.valueOf(item.getChannelId().getId()));
             dto.setCustomerId(customerId);
             dto.setDate(item.getDate());
             dto.setProductNumber(productNumber);
             dto.setStatus(item.getStatus());
             dto.setTransactionNumber(item.getTransactionNumber());
             dto.setType(String.valueOf(item.getType().getId()));
            return dto;
        }).forEach((dto) -> {
           
            listResult.add(dto);
            
        });
         return listResult;
    }
}
