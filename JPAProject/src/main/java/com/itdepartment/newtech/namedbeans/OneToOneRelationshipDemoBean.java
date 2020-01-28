/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.namedbeans;

import com.itdepartment.newtech.entities.Customer;
import com.itdepartment.newtech.entities.LoginInfo;
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
@Named(value = "oneToOneRelationshipDemoBean")
@RequestScoped
public class OneToOneRelationshipDemoBean {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Resource
    private UserTransaction userTransaction;
    /**
     * Creates a new instance of OneToOneRelationshipDemoBean
     */
    public OneToOneRelationshipDemoBean() {
    }
    
    public String updateDatabase(){
    
        String retVal = "confirmation";
        Customer customer;
        LoginInfo loginInfo = new LoginInfo();
        
        loginInfo.setLoginInfoId(1l);
        loginInfo.setLoginName("charlesj");
        loginInfo.setPassword("iwonttellyou");
        
        try {
        
            userTransaction.begin();
            
            customer = entityManager.find(Customer.class, 4l);
            loginInfo.setCustomer(customer);
            
            entityManager.persist(loginInfo);
            
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
