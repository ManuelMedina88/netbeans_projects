/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author manuel
 */
@Named(value = "asynchronousProjects")
@SessionScoped
public class AsynchronousProjects implements Serializable {

    @EJB
    AsynchronousSessionBeanRemote asynchronous;
    
    /**
     * Creates a new instance of AsynchronousProjects
     */
    public AsynchronousProjects() {
    }
    
    public void testingAsynchronousBean(){
    
        System.out.println("Asynchronous initialized.");
        
        asynchronous.slowMethod();
        
        System.out.println("We're welcome back!");
        
    }
}
