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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author manuel
 */

@Entity
@Table(name="ADDRESSES")
public class Addresses {
    
    @Id
    @Column(name="ADDRESS_ID")
    private Long addressId;
    
    @OneToOne
    @JoinColumn(name="ADDRESS_TYPE_ID")
    private AddressTypes addressTypes;
    
    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;
    
    @Column(name="ADDR_LINE_1")
    private String addrLine1;
    
    @Column(name="ADDR_LINE_2")
    private String addrLine2;
    
    @Column(name="CITY")
    private String city;
    
    @OneToOne
    @JoinColumn(name="US_STATE_ID")
    private UsStates usStates;
    
    @Column(name="ZIP")
    private String zip;
    
    public Addresses(){
    
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public AddressTypes getAddressType() {
        return addressTypes;
    }

    public void setAddressType(AddressTypes addressType) {
        this.addressTypes = addressType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAddrLine1() {
        return addrLine1;
    }

    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public String getAddrLine2() {
        return addrLine2;
    }

    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UsStates getUsStates() {
        return usStates;
    }

    public void setUsStates(UsStates usStates) {
        this.usStates = usStates;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }  
}
