/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.ejbproject_2.beansCDI;

import com.itdepartment.newtech.ejbproject_2.service.ISimpleSessionBoth;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author manuel
 */
public class BeanHelper {
    
    
    public static ISimpleSessionBoth getStatelessBean(){
    
        ISimpleSessionBoth statelessBean = null;
        
        try{
        
            Context jndi = new InitialContext();
            statelessBean = (ISimpleSessionBoth) jndi.lookup("java:global/EJBProject_2-1.0/SimpleSessionBeanStateless!com.itdepartment.newtech.ejbproject_2.service.ISimpleSessionBoth");
        
        }catch(NamingException ex){
        
            System.out.println("Something went orrible wrong");
        
        }
        
        return statelessBean;
    }
    
}
