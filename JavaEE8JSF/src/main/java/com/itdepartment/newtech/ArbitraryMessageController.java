/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author manuel
 */
@Named(value = "arbitraryMessageController")
@ViewScoped
public class ArbitraryMessageController implements Serializable{

    @Inject
    FacesContext facesContext;
    /**
     * Creates a new instance of ArbitraryMessageController
     */
    public ArbitraryMessageController() {
    }
    
    public void saveData(){
        
        FacesMessage facesMessage = 
                new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Data saved successfully", "All Data successfully");
        
        facesContext.addMessage(null, facesMessage);
        
    }
    
}
