/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author manuel
 */
@Named(value = "jsfBean1_1")
@RequestScoped
public class JsfBean1_1 {

    private String firstName;
    private String lastName;
    private int integer1;
    private int integer2;
    private int integer3;
    private double double1;
    private double double2;
    private boolean bool1;
    private boolean bool2;
    private String expressionLanguage;
    private String expressionLanguage2;
    
    /**
     * Creates a new instance of JsfBean1_1
     */
    public JsfBean1_1() {
        
        firstName = "Manuel";
        lastName = "Medina";
        integer1 = 3;
        integer2 = 5;
        double1 = 5.5;
        double2 = 7.8;
        bool1 = true;
        bool2 = false;
        expressionLanguage = "#{jsfBean1_1.firstName}";
        expressionLanguage2 = "#{jsfBean1_1['lastName']}";
        
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

    public int getInteger1() {
        return integer1;
    }

    public void setInteger1(int integer1) {
        this.integer1 = integer1;
    }

    public int getInteger2() {
        return integer2;
    }

    public void setInteger2(int integer2) {
        this.integer2 = integer2;
    }

    public int getInteger3() {
        return integer3;
    }

    public void setInteger3(int integer3) {
        this.integer3 = integer3;
    }
    
    public double getDouble1() {
        return double1;
    }

    public void setDouble1(double double1) {
        this.double1 = double1;
    }

    public double getDouble2() {
        return double2;
    }

    public void setDouble2(double double2) {
        this.double2 = double2;
    }

    public boolean isBool1() {
        return bool1;
    }

    public void setBool1(boolean bool1) {
        this.bool1 = bool1;
    }

    public boolean isBool2() {
        return bool2;
    }

    public void setBool2(boolean bool2) {
        this.bool2 = bool2;
    }

    public String getExpressionLanguage() {
        return expressionLanguage;
    }

    public void setExpressionLanguage(String expressionLanguage) {
        this.expressionLanguage = expressionLanguage;
    }

    public String getExpressionLanguage2() {
        return expressionLanguage2;
    }

    public void setExpressionLanguage2(String expressionLanguage2) {
        this.expressionLanguage2 = expressionLanguage2;
    }
        
}
