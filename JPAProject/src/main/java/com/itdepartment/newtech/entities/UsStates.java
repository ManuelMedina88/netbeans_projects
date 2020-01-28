/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author manuel
 */

@Entity
@Table(name="US_STATES")
public class UsStates {
    
    @Id
    @Column(name="US_STATE_ID")
    private Long usStateId;
    
    @Column(name="US_STATE_CD")
    private String usStateCD;
    
    @Column(name="US_STATE_NM")
    private String usStateName;
    
    public UsStates(){}

    public Long getUsStateId() {
        return usStateId;
    }

    public void setUsStateId(Long usStateId) {
        this.usStateId = usStateId;
    }

    public String getUsStateCD() {
        return usStateCD;
    }

    public void setUsStateCD(String usStateCD) {
        this.usStateCD = usStateCD;
    }

    public String getUsStateName() {
        return usStateName;
    }

    public void setUsStateName(String usStateName) {
        this.usStateName = usStateName;
    }  
    
}
