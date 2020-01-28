/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "TELEPHONES")
public class Telephones implements Serializable{
    
    @Id
    @Column(name="TELEPHONE_ID")
    private long telephoneId;
    
    @OneToOne
    @JoinColumn(name="TELEPHONE_TYPE_ID")
    private TelephoneTypes telephoneTypes;
    
    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;
    
    @Column(name="TELEPHONE_NUMBER")
    private String telephoneNumber;    
    
    public Telephones(){
    
    }

    public long getTelephoneId() {
        return telephoneId;
    }

    public void setTelephoneId(long telephoneId) {
        this.telephoneId = telephoneId;
    }

    public TelephoneTypes getTelephoneTypes() {
        return telephoneTypes;
    }

    public void setTelephoneTypes(TelephoneTypes telephoneTypes) {
        this.telephoneTypes = telephoneTypes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    
    
}
