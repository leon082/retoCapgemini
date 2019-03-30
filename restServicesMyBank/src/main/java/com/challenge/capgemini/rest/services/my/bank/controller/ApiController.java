/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenge.capgemini.rest.services.my.bank.controller;

import com.challenge.capgemini.rest.services.my.bank.entities.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis Leon
 */
@RestController
@RequestMapping("/services")
public class ApiController {
    
    @PostMapping(value = "/login")
    public String login(@RequestBody String customerId, @RequestBody String password ){
        return "";
    }
            
    
}
