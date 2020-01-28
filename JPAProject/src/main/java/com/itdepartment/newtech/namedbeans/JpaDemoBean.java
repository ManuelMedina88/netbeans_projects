/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.namedbeans;

import com.itdepartment.newtech.entities.Customer;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author manuel
 */
@Named(value = "jpaDemoBean")
@RequestScoped
public class JpaDemoBean {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Resource
    private UserTransaction userTransaction;
    
    /**
     * Creates a new instance of JpaDemoBean
     */
    public JpaDemoBean() {
    }
    
    public String updateDatabase(){
    
        String retVal = "Confirmation";
        
        Customer customer = new Customer();
        Customer customer2 = new Customer();
        Customer customer3;
        
        customer.setCustomerId(3l);
        customer.setFirstName("James");
        customer.setLastName("McKenzie");
        customer.setEmail("jamesm@notreal.com");
        
        customer2.setCustomerId(4l);
        customer2.setFirstName("Charles");
        customer2.setLastName("Jonson");
        customer2.setEmail("cjohnson@phony.org");
        
        try{
        
            userTransaction.begin();
            
            entityManager.persist(customer);
            entityManager.persist(customer2);
            customer3 = entityManager.find(Customer.class, 4l);
            customer3.setLastName("Johnson");
            entityManager.persist(customer3);
            //entityManager.remove(customer);
            
            userTransaction.commit();
            
            
        }catch(HeuristicMixedException | 
                HeuristicRollbackException |
                IllegalStateException |
                NotSupportedException |
                RollbackException | 
                SecurityException | 
                SystemException e){
            
            retVal = "Error";
            
            e.printStackTrace();
        
        }
        
        return retVal;
        
    }
    
}
