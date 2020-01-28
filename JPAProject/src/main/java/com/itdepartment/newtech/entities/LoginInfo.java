/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author manuel
 */
@Entity
@Table(name="LOGIN_INFO")
public class LoginInfo {
    
    @Id
    @Column(name="LOGIN_INFO_ID")
    private long loginInfoId;
    
    @Column(name="LOGIN_NAME")
    private String loginName;
    
    @Column(name="PASSWORD")
    private String password;
    
    @OneToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;

    public long getLoginInfoId() {
        return loginInfoId;
    }

    public void setLoginInfoId(long loginInfoId) {
        this.loginInfoId = loginInfoId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
