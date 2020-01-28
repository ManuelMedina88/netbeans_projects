/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.entities;

import java.io.Serializable;

/**
 *
 * @author manuel
 */
public class OrderItemPK implements Serializable{
    
    public Long orderId;
    public Long itemId;
    
    public OrderItemPK(){
    
    }
    
    public OrderItemPK(long orderId, long itemId){
        
        this.orderId = orderId;
        this.itemId = itemId;
    
    }
    
    @Override
    public boolean equals(Object obj){
        
        boolean returnVal = false;
        
        if(obj == null){
            
            returnVal = false;
            
        }else if(!obj.getClass().equals(this.getClass())){
            
            returnVal = false;
            
        }else{
            
            OrderItemPK other = (OrderItemPK) obj;
            
            if(this == other){
                
                returnVal = true;
                
            }else if(orderId != null && other.orderId != null && this.orderId.equals(other.orderId)){
                
                if(itemId != null && other.itemId != null && itemId.equals(other.itemId)){
                    
                    returnVal = true;
                }
            
            }else{
            
                returnVal = false;
            }
            
        }
        
        return returnVal;
    }
    
    @Override
    public int hashCode(){
    
        if(orderId == null || itemId == null){
            
            return 0;
            
        }else{
            
            return orderId.hashCode() ^ itemId.hashCode();
        }
    }
}
