/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.namedbeans;

import com.itdepartment.newtech.entities.Customer;
import com.itdepartment.newtech.entities.Order;
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
@Named(value = "oneToManyRelationShipDemoBean")
@RequestScoped
public class OneToManyRelationShipDemoBean {

    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Resource
    private UserTransaction userTransaction;
    /**
     * Creates a new instance of OneToManyRelationShipDemoBean
     */
    public OneToManyRelationShipDemoBean() {
    }
    
    public String updateDatabase(){
        
        String retVal = "confirmation";
        
        Customer customer;
        Order order1;
        Order order2;
        
        order1 = new Order();
        order1.setOrderId(1l);
        order1.setOrderNumber("SFX12345");
        order1.setOrderDescription("Dummy order.");        
        
        order2 = new Order();
        order2.setOrderId(2l);
        order2.setOrderNumber("SFX23456");
        order2.setOrderDescription("Another dummy order.");
        
        try{
        
            userTransaction.begin();
            
                customer = entityManager.find(Customer.class, 4L);
                
                order1.setCustomer(customer);
                order2.setCustomer(customer);
                
                entityManager.persist(order1);
                entityManager.persist(order2);
            
            userTransaction.commit();
            
        }catch(HeuristicMixedException | 
                HeuristicRollbackException |
                IllegalStateException |
                NotSupportedException |
                RollbackException | 
                SecurityException | 
                SystemException e){
        
            retVal = "error";
            e.printStackTrace();
        }
        
        
        
        
        return retVal;
    }
    
}
