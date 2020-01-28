/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.beans;

import com.itdepartment.newtech.entities.UsStates;
import com.itdepartment.newtech.service.IStateService;
import com.itdepartment.newtech.singleton.SingletonSessionBean;
import com.itdepartment.newtech.singleton.SingletonSessionBeanRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author manuel
 */
@Named(value = "demonstration")
@RequestScoped
public class Demonstration {

    @EJB
    private SingletonSessionBeanRemote singleton;
    
    private String hello = "Hellow";
    
    private List<UsStates> listOfStates;
    
    @EJB
    private IStateService states;
    /**
     * Creates a new instance of Demonstration
     */
    public Demonstration() {
        
       
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public List<UsStates> getListOfStates() {
        return  listOfStates = singleton.getStateList();
    }
    
    public void printList(){
    
        for(UsStates state: singleton.getStateList()){
            System.out.println(state.getUsStateName());
        }
    }
    
}
