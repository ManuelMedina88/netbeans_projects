/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.beans.service;

import javax.ejb.Stateless;

/**
 *
 * @author manuel
 */
@Stateless
public class SimpleSessionBean implements SimpleSession{
    
    private String message = "If you don't see this, it didn't work";
    
    public String getMessage(){
        return message;
    }
    
}
