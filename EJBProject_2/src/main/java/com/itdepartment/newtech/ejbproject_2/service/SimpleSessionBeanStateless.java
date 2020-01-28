/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.ejbproject_2.service;


import javax.ejb.Stateless;

/**
 *
 * @author manuel
 */
@Stateless
public class SimpleSessionBeanStateless implements ISimpleSessionBoth{

    private String param;
    
    public SimpleSessionBeanStateless(){
        this.param = "Mere mortal";
    }
    
    @Override
    public String getMessage() {
        return "If you don't see this, it didn't work! " +  this.param;
    }

    @Override
    public void setParam(String param) {
        this.param = param;
    }

    @Override
    public String getParam() {
        return this.param;
    }
    
}
