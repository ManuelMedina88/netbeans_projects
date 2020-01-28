/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.beans;

import com.itdepartment.newtech.domain.Users;
import com.itdepartment.newtech.helper.BeanHelper;
import com.itdepartment.newtech.service.IUserService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author manuel
 */
@Named(value = "usernameCredentialBeans")
@SessionScoped
public class UsernameCredentialBeans implements Serializable {

    private String username;
    private String password;
    private final IUserService userService;
    private Users currentUser;
    
    /**
     * Creates a new instance of UsernameCredentialBeans
     */
    public UsernameCredentialBeans() {
        userService = BeanHelper.getUserService();
        currentUser = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users getCurrentUser() {
        return currentUser;
    }
    
    
    
    public String verifyUser(){
        
        for(Users user : userService.listOfUsers()){
            if(user.getUsername().equals(username) && 
                    user.getPassword().equals(password)){
                
                System.out.println("Info Manuel: " + user.getUserType());
                currentUser = user;
                
                if(user.getUserType().equals("normal")){
                    
                    return "home_page_normal.xhtml";
                }else{
                    return "homepage.xhtml";
                }
            }
        }
        
        return "index.xhtml";
    }
    
}
