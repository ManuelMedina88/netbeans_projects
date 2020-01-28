/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;

/**
 *
 * @author manuel
 */
@Named(value = "jsfWebSocketMessageSender")
@ApplicationScoped
public class JsfWebSocketMessageSender implements Serializable {

    @Inject
    @Push
    private PushContext pushContext;
    
    /**
     * Creates a new instance of JsfWebSocketMessageSender
     */
    
    public JsfWebSocketMessageSender() {
    }
    
    public void send(String message){
    
        System.out.println("Sending message: " + message);
        pushContext.send(message);
        
    }
    
}
