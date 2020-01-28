/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.bean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author manuel
 */
@Named(value = "helloWorld")
@RequestScoped
public class HelloWorld {

    /**
     * Creates a new instance of HelloWorld
     */
    public HelloWorld() {
        System.out.println("HelloWorld started!");
    }
    
    public String getMessage(){
        return "Hello World!";
    }
}
