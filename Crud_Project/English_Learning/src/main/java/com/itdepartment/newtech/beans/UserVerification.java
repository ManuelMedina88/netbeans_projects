/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.beans;

import com.itdepartment.newtech.domain.Users;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author manuel
 */
@Named(value = "userVerification")
@RequestScoped
public class UserVerification {

    
    private String userName;
    private String password;
    private List<Users> listOfUsers;
    /**
     * Creates a new instance of UserVerification
     */
    public UserVerification() {
        
        listOfUsers = GeneralService.getService().listOfUsers();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String processAuthentication(){
        
        boolean validation = false;
        
        String page = "";
        
        for(Users user : listOfUsers){
            if(userName.equals(user.getUserName()) && password.equals(user.getUserPassword())){
                
                validation = true;
                break;
            }
        }
        
        if(validation){
            page = "FrontPage.xhtml";
        }
        
        return page;
    }
  
}
