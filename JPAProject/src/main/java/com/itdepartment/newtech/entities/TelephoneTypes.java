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
import javax.persistence.Table;

/**
 *
 * @author manuel
 */
@Entity
@Table(name="TELEPHONE_TYPES")
public class TelephoneTypes implements Serializable{
    
    @Id
    @Column(name = "TELEPHONE_TYPE_ID")
    private long telefonoTypeId;
    
    @Column(name="TELEPHONE_TYPE_CD")
    private char telephoneTypeCD;
    
    @Column(name="TELEPHONE_TYPE_TEXT")
    private String telephoneTypeText;
    
    public TelephoneTypes(){
    
    }

    public long getTelefonoTypeId() {
        return telefonoTypeId;
    }

    public void setTelefonoTypeId(long telefonoTypeId) {
        this.telefonoTypeId = telefonoTypeId;
    }

    public char getTelephoneTypeCD() {
        return telephoneTypeCD;
    }

    public void setTelephoneTypeCD(char telephoneTypeCD) {
        this.telephoneTypeCD = telephoneTypeCD;
    }

    public String getTelephoneTypeText() {
        return telephoneTypeText;
    }

    public void setTelephoneTypeText(String telephoneTypeText) {
        this.telephoneTypeText = telephoneTypeText;
    }
    
}
