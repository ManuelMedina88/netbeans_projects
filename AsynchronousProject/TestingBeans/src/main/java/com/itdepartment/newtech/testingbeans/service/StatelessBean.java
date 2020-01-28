/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.testingbeans.service;

import javax.ejb.Stateless;

/**
 *
 * @author manuel
 */

@Stateless
public class StatelessBean{
 
    private String name;
    
    //@Override
    public String testBean(String name) {
        
        setName(name);
        return "My name is the wonderful " + name;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
