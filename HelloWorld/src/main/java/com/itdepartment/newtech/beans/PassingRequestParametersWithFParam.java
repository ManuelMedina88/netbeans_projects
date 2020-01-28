/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.beans;

import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 *
 * @author manuel
 */
@Named(value = "passingRequestParametersWithFParam")
@RequestScoped
public class PassingRequestParametersWithFParam {

    private FacesContext facesContext = FacesContext.getCurrentInstance();
    
    private String playerName;
    
    private String playerSurname;
    /**
     * Creates a new instance of PassingRequestParametersWithFParam
     */
    public PassingRequestParametersWithFParam() {
    }
    
    
    
    public String parametersAction(){
    
        Map<String, String> params = 
                facesContext.getExternalContext().getRequestParameterMap();
        
        playerName = params.get("playerNameParam");
        playerSurname = params.get("playerSurnameParam");
        
        return "fparam2";
    }
    
    /*public String parametersAction(){
        
        return "fparam2";
    }*/

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerSurname() {
        return playerSurname;
    }

    public void setPlayerSurname(String playerSurname) {
        this.playerSurname = playerSurname;
    }
    
    
}
