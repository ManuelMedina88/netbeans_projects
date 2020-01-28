/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.namedbeans;

import com.itdepartment.newtech.entities.Item;
import com.itdepartment.newtech.entities.Order;
import java.util.ArrayList;
import java.util.Collection;
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
@Named(value = "manyToManyRelationshipDemoBean")
@RequestScoped
public class ManyToManyRelationshipDemoBean {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Resource
    private UserTransaction userTransaction;
    
    /**
     * Creates a new instance of ManyToManyRelationshipDemoBean
     */
    public ManyToManyRelationshipDemoBean() {
    }
    
    public String updateDatabase(){
    
        String retVal = "confirmation";
        
        Order order;
        Collection<Item> items = new ArrayList<Item>();
        Item item1 = new Item();
        Item item2 = new Item();
        
        item1.setItemId(1l);
        item1.setItemNumber("BCD1234");
        item1.setItemShortDesc("Notebook Computer");
        item1.setItemLongDesc("64 bit Quad core CPU, 4GB memory");
        
        item2.setItemId(2l);
        item2.setItemNumber("CDF2345");
        item2.setItemShortDesc("Cordless Mouse");
        item2.setItemLongDesc("Three button, infrared, vertical and horizontal scrollwheels");
        
        items.add(item1);
        items.add(item2);
        
        try {
            
            userTransaction.begin();
            
            entityManager.persist(item1);
            entityManager.persist(item2);
            order = entityManager.find(Order.class, 1l);
            order.setItems(items);
            entityManager.persist(order);
            
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
