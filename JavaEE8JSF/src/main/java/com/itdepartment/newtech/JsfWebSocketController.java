/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author manuel
 */
@Named(value = "jsfWebSocketController")
@SessionScoped
public class JsfWebSocketController implements Serializable {

    @Inject
    private JsfWebSocketMessageSender jsfWebSocketMessageSender;
    
    private String userName;
    private String message;
    
    /**
     * Creates a new instance of JsfWebSocketController
     */
    
    public JsfWebSocketController() {
    }
    
    public void sendMessage(){
        
        jsfWebSocketMessageSender.send(String.format("%s: %s", userName, message));
    }

    public JsfWebSocketMessageSender getJsfWebSocketMessageSender() {
        return jsfWebSocketMessageSender;
    }

    public void setJsfWebSocketMessageSender(JsfWebSocketMessageSender jsfWebSocketMessageSender) {
        this.jsfWebSocketMessageSender = jsfWebSocketMessageSender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    } 
    
}
