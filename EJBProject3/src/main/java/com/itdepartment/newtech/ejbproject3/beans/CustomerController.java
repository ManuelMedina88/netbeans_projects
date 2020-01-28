/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.ejbproject3.beans;

import com.itdepartment.newtech.ejbproject3.Dao.CustomerDao;
import com.itdepartment.newtech.ejbproject3.Dao.CustomerDaoBean;
import com.itdepartment.newtech.ejbproject3.Entity.Customers;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author manuel
 */
@Named(value = "customerController")
@RequestScoped
public class CustomerController implements Serializable{

    @EJB
    private CustomerDao customerDaoBean;
    
    private Customers customer;
    
    private String firstName;
    private String lastName;
    private String email;
    
    /**
     * Creates a new instance of CustomerController
     */
    public CustomerController() {
        
        customer = new Customers();
    }
    
    public String saveCustomer(){
    
        String returnValue = "customer_saved";
        
        try {
            populateCustomer();
            
            customerDaoBean.saveCustomer(customer);
        }catch(Exception ex){
            ex.printStackTrace();
            returnValue = "error_saving_customer";
        }
        
        return returnValue;
        
    }
    
    private void populateCustomer() {
    
        if(customer == null){
        
            customer = new Customers();
        }
        
        customer.setCustomerId(14);
        customer.setFirstName(getFirstName());
        customer.setLastName(getLastName());
        customer.setEmail(getEmail());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
