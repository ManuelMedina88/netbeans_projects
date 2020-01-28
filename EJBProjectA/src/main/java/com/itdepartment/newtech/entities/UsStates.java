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
import javax.validation.constraints.Size;

/**
 *
 * @author manuel
 */

@Entity
@Table(name="US_STATES")
public class UsStates implements Serializable{
    
    
    @Id
    @Column(name="US_STATE_ID")
    private Long usState;
    
    @Column(name="US_STATE_CD")
    @Size(min=2, max=2)
    private String usStateCD;
    
    @Column(name="US_STATE_NM")
    private String usStateName;

    public UsStates() {
    }

    public Long getUsState() {
        return usState;
    }

    public void setUsState(Long usState) {
        this.usState = usState;
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
