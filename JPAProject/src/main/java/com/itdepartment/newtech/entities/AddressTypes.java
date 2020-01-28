/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author manuel
 */

@Entity
@Table(name="ADDRESS_TYPES")
public class AddressTypes {
    
    @Id
    @Column(name="ADDRESS_TYPE_ID")
    private Long addressTypeId;
    
    @Column(name="ADDRESS_TYPE_CODE")
    private char addressTypeCode;
    
    @Column(name="ADDRESS_TYPE_TEXT")
    private String addressTypeText;
    
    public AddressTypes(){}

    public Long getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(Long addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public char getAddressTypeCode() {
        return addressTypeCode;
    }

    public void setAddressTypeCode(char addressTypeCode) {
        this.addressTypeCode = addressTypeCode;
    }

    public String getAddressTypeText() {
        return addressTypeText;
    }

    public void setAddressTypeText(String addressTypeText) {
        this.addressTypeText = addressTypeText;
    }
    
    
    
}
