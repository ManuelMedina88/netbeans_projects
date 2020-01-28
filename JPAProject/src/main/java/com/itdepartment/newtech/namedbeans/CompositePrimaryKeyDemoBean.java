/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.namedbeans;

import com.itdepartment.newtech.entities.OrderItem;
import com.itdepartment.newtech.entities.OrderItemPK;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author manuel
 */
@Named(value = "compositePrimaryKeyDemoBean")
@RequestScoped
public class CompositePrimaryKeyDemoBean {

    @PersistenceContext
    EntityManager entityManager;
    
    private OrderItem orderItem;
    
    /**
     * Creates a new instance of CompositePrimaryKeyDemoBean
     */
    
    public CompositePrimaryKeyDemoBean() {
    }
    
    public String findOrderItem(){
        
        String retVal = "confirmation";
        
        try{
            
            orderItem = entityManager.find(OrderItem.class, new OrderItemPK(1l, 2l));
        
        }catch(Exception e){
        
            retVal = "error";
            e.printStackTrace();
            
        }
        
        return retVal;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    } 
    
}
