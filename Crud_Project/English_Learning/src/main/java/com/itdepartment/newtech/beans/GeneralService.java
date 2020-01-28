/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.beans;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.itdepartment.newtech.service.IGeneralService;

/**
 *
 * @author manuel
 */
public class GeneralService {
    
    private static final IGeneralService service = setService();
    
    private GeneralService(){
     
    }

    public static IGeneralService getService() {
        return service;
    }
    
    private static IGeneralService setService(){
        
        IGeneralService service = null;
        
        try{
        
            Context jndi = new InitialContext();
            service = (IGeneralService) jndi.lookup("java:global/English_Learning/GeneralServiceImpl!com.itdepartment.newtech.service.IGeneralService");
        }catch(NamingException ex){
            System.out.println("Something went wrong.");
        }
        
        return service;
    }
}
