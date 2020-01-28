/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.beans;

import java.util.Date;

/**
 *
 * @author manuel
 */
public class PlayerDetails {
    
    private Date birthday;
    private String birthplace;
    
    public PlayerDetails(){
        birthday = new Date();
        birthplace = "Madrid Spain";
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }
    
    
}
