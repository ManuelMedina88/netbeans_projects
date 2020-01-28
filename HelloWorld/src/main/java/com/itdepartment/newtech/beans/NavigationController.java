/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author manuel
 */
@Named(value = "navigationController")
@RequestScoped
public class NavigationController {

    private String pageId;
    
    /**
     * Creates a new instance of NavigationController
     */
    public NavigationController() {
    }
    
    public String moveToPage1(){
        return "page1";
    }
    
    public String moveToPage2(){
        return "page2";
    }
    
    public String backToHome(){
        return "index";
    }
    
    public String showPage( String value){
     
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        System.out.println("Best player ever is " + facesContext.getExternalContext().getInitParameter("number.one.in.ATP"));
        pageId = value;
        System.out.println(pageId);
        
        if(pageId == null){
            return "home";
        }
        
        if(pageId.equals("1")){
            return "page1";
        }else if(pageId.equals("2")){
            return "page2";
        }else {
            return "home";
        }
    }
}
