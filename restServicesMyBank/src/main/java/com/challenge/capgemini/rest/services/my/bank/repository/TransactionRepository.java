/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenge.capgemini.rest.services.my.bank.repository;

import com.challenge.capgemini.rest.services.my.bank.entities.Transaction;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author LuisLeon
 */
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Integer> {

    @Query(value = "select t from Transaction t "
            + "where t.customerProductId.customerId.customerId = :Id " 
            + " AND t.customerProductId.productNumber = :productNumber "
            + "order by t.date asc")
    List<Transaction> lastTransaction(@Param("Id") String id, @Param("productNumber") String productNumbe, Pageable pageable);

}
