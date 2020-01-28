/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author manuel
 */
@Entity
@Table(name="CUSTOMERS")
public class Customer implements Serializable {
    
    @Id
    @Column(name="CUSTOMER_ID")
    private long customerId;
    
    @Column(name="FIRST_NAME")
    private String firstName;
    
    @Column(name="LAST_NAME")
    private String lastName;
    
    private String email;
    
    @OneToOne(mappedBy="customer")
    private LoginInfo loginInfo;
    
    @OneToMany(mappedBy="customer")
    private Set<Order> orders;
    
    @OneToMany(mappedBy="customer")
    private Set<Telephones> telephones;
    
    @OneToMany(mappedBy="customer")
    private Set<Addresses> addresses;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }  

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Telephones> getTelephones() {
        return telephones;
    }

    public void setTelephones(Set<Telephones> telephones) {
        this.telephones = telephones;
    }
    
}
