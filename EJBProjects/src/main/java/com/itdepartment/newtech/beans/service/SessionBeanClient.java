/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.beans.service;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author manuel
 */
public class SessionBeanClient {
   
    @EJB
    private static SimpleSession simpleSession;
    
    private void invokeSessionBeanMethods(){
    
        System.out.println(simpleSession.getMessage());
        
        System.out.println("\nSimpleSession is of type: " + simpleSession.getClass().getName());
        
    }  
    
    public static void main(String[] args){
        new SessionBeanClient().invokeSessionBeanMethods();
    } 
   
}
