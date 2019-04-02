/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenge.capgemini.rest.services.my.bank.controller;

import com.challenge.capgemini.rest.services.my.bank.DTO.TransactionDTO;
import com.challenge.capgemini.rest.services.my.bank.entities.Transaction;
import com.challenge.capgemini.rest.services.my.bank.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LuisLeon
 */
@RestController
@RequestMapping("/api/1.0")
public class TransactionController {
    @Autowired
    TransactionServices transactionServices;
    
     @GetMapping(value = "/transaction/getLast/{limit}/{customerId}/{productNumber}")
    public Iterable<TransactionDTO> getProductsByCustomerId(@PathVariable(value = "limit" ) Integer limit, @PathVariable(value = "customerId" ) String customerId ,@PathVariable(value = "productNumber" ) String productNumber){
         System.out.println("Llego la peticion...");
        return transactionServices.getLastTransactions(limit, customerId, productNumber);
    }
}
