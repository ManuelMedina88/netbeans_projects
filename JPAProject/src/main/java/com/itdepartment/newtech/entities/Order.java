/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.entities;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author manuel
 */
@Entity
@Table(name="ORDERS")
public class Order {
    
    @Id
    @Column(name="ORDER_ID")
    private long orderId;
    
    @Column(name="ORDER_NUMBER")
    private String orderNumber;
    
    @Column(name="ORDER_DESCRIPTION")
    private String orderDescription;
    
    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;
    
    @ManyToMany
    @JoinTable(name = "ORDER_ITEMS", 
            joinColumns = @JoinColumn(name="ORDER_ID",
                    referencedColumnName = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID",
                    referencedColumnName = "ITEM_ID"))
    private Collection<Item> items;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }
    
     
    
}
