/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author manuel
 */

@Entity
@Table(name = "ORDER_ITEMS")
@IdClass(value= OrderItemPK.class)
public class OrderItem {
    
    @Id
    @Column(name="ORDER_ID")
    private Long orderId;
    
    @Id
    @Column(name="ITEM_ID")
    private Long itemId;
    
    @Column(name="ITEM_QTY")
    private Long itemQTY;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemQTY() {
        return itemQTY;
    }

    public void setItemQTY(Long itemQTY) {
        this.itemQTY = itemQTY;
    }
    
}
