/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenge.capgemini.rest.services.my.bank.constant;

/**
 *
 * @author Luis Leon
 */
public class Constant {

    public static final String HEADER = "Authorization";
    public static final int EXPIRES_IN = 600;
    public static final String SECRET = "queenvictoria";
    public static final String APP_NAME = "Spring Service project";
    public static final String DEVICE = "Generic";

    public enum TokenParameter {
        USER, CREATED, EXPIRATION, AUDIENCE
    }

}
