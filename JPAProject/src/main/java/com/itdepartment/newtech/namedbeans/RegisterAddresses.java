/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.namedbeans;

import com.itdepartment.newtech.entities.AddressTypes;
import com.itdepartment.newtech.entities.Addresses;
import com.itdepartment.newtech.entities.Customer;
import com.itdepartment.newtech.entities.UsStates;
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
@Named(value = "registerAddresses")
@RequestScoped
public class RegisterAddresses {

    @PersistenceContext
    EntityManager em;
    
    @Resource
    private UserTransaction ut;
    /**
     * Creates a new instance of RegisterAddresses
     */
    public RegisterAddresses() {
    }
    
    public String updateDatabase(){
    
        String retVal = "confirmation";
        
        Customer customer;
        
        UsStates usState;
        
        AddressTypes addrType;
        
        Addresses addresses1 = new Addresses();
        Addresses addresses2 = new Addresses();
        Addresses addresses3 = new Addresses();
        
        addresses1.setAddrLine1("St. Lucas 123");
        addresses1.setAddrLine2("nearby to st. Nicolas");
        addresses1.setZip("00245");
        addresses1.setCity("Brooklin");
        
        addresses2.setAddrLine1("Marcobelo Av. 343");
        addresses2.setAddrLine2("In front Disney Plaza");
        addresses2.setZip("00526");
        addresses2.setCity("Hamilton");
        
        addresses3.setAddrLine1("Main Street Av. 1205");
        addresses3.setAddrLine2("accross The Alan galaguer Street ");
        addresses3.setZip("00245");
        addresses3.setCity("Boston");
        
        try{
            ut.begin();
            
            customer = em.find(Customer.class, 4l);
            
            usState = em.find(UsStates.class, 37l ); 
            addrType = em.find(AddressTypes.class, 1l);
            
            addresses1.setAddressId(1l);
            addresses1.setCustomer(customer);
            addresses1.setUsStates(usState);
            addresses1.setAddressType(addrType);
            
            em.persist(addresses1);
            
            usState = em.find(UsStates.class, 41l);
            addrType = em.find(AddressTypes.class, 2l);
            
            
            addresses2.setAddressId(2l);
            addresses2.setCustomer(customer);
            addresses2.setUsStates(usState);
            addresses2.setAddressType(addrType);
            
            em.persist(addresses2);
            
            usState = em.find(UsStates.class, 25l);
            addrType = em.find(AddressTypes.class, 3l);
            
            addresses3.setAddressId(3l);
            addresses3.setCustomer(customer);
            addresses3.setUsStates(usState);
            addresses3.setAddressType(addrType);
             
            em.persist(addresses3);
            
            ut.commit();
            
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
        
        System.out.println(retVal);
        
        return retVal;
    }
    
}
