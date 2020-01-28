/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.namedbeans;

import com.itdepartment.newtech.entities.Customer;
import com.itdepartment.newtech.entities.TelephoneTypes;
import com.itdepartment.newtech.entities.Telephones;
import java.util.Set;
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
@Named(value = "telephoneRegistrationBean")
@RequestScoped
public class TelephoneRegistrationBean {

    @PersistenceContext
    EntityManager em;
    
    @Resource
    private UserTransaction userTransaction;
    
    /**
     * Creates a new instance of TelephoneRegistrationBean
     */
    public TelephoneRegistrationBean() {
    }
    
    public String updateDatabase(){
  
        String retValue="confirmation";

        Customer customer;
        
        TelephoneTypes telephoneType1;
        TelephoneTypes telephoneType2;
        
            
        Telephones telephone1 = new Telephones();
        Telephones telephone2 = new Telephones();
        
        telephone1.setTelephoneId(1l);
        telephone1.setTelephoneNumber("(829) 839-1027");
        
        telephone2.setTelephoneId(2l);
        telephone2.setTelephoneNumber("(809) 859-5290");
       
        try{
            
            userTransaction.begin();
            
            customer = em.find(Customer.class, 4l);
            
            telephoneType1 = em.find(TelephoneTypes.class, 1l);
            telephoneType2 = em.find(TelephoneTypes.class, 2l);
            
            telephone1.setTelephoneTypes(telephoneType1);
            telephone2.setTelephoneTypes(telephoneType2);
            
            telephone1.setCustomer(customer);
            telephone2.setCustomer(customer);
            
            em.persist(telephone1);
            em.persist(telephone2);
            
            userTransaction.commit();
        
        }catch(HeuristicMixedException | 
                HeuristicRollbackException |
                IllegalStateException |
                NotSupportedException |
                RollbackException | 
                SecurityException | 
                SystemException e){
        
        }
 
        return retValue;
    }
    
}
