/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.helper;

import com.itdepartment.newtech.service.IProductService;
import com.itdepartment.newtech.service.IUserService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author manuel
 */
public class BeanHelper {
    
    
    public static IProductService getService(){
        
        IProductService service = null;
        
        try{

            Context jndi = new InitialContext();
            service = (IProductService)jndi.lookup("java:global/ColmaHelp/ProductServiceImpl!com.itdepartment.newtech.service.IProductService");

        }catch(NamingException ex){
            System.out.println("Something went wrong!");
        }
        
        return service;
    }
    
    public static IUserService getUserService(){
        
        IUserService service = null;
        
        try{

            Context jndi = new InitialContext();
            service = (IUserService)jndi.lookup("java:global/ColmaHelp/UserServiceImpl!com.itdepartment.newtech.service.IUserService");

        }catch(NamingException ex){
            System.out.println("Something went wrong!");
        }
        
        return service;
    }
}
