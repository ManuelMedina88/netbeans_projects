/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.Application;
import javax.faces.application.ProjectStage;
import javax.faces.context.FacesContext;

/**
 *
 * @author manuel
 */
@Named(value = "customer")
@SessionScoped
public class Customer implements Serializable {

    /**
     * Creates a new instance of Customer
     */
    private String firstName;
    private String lastName;
    private String email;

    public Customer() {}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void showStage(){
    
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application application = facesContext.getApplication();
        if (application.getProjectStage().equals(
                ProjectStage.Production)) {
            System.out.println("Production");
        } else if (application.getProjectStage().equals(
                ProjectStage.Development)) {
            System.out.println("Development");
        } else if (application.getProjectStage().equals(
                ProjectStage.UnitTest)) {
            System.out.println("UniTest");
        } else if (application.getProjectStage().equals(
                ProjectStage.SystemTest)) {
            System.out.println("SystemTest");
        }

    }
}
