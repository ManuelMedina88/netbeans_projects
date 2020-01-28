/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.primefacesproject.beans;

import com.itdepartment.newtech.primefacesproject.entities.UsStates;
import com.itdepartment.newtech.primefacesproject.service.IStatesService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author manuel
 */
@Named(value = "primefacesData")
@ViewScoped
public class PrimefacesData implements Serializable{

    private List<UsStates> listOfStates;
    
    private FacesContext fc = FacesContext.getCurrentInstance();
    UIComponent uic = fc.getViewRoot().getComponentResources(fc).get(2);
    
    private String state;
    private String stateA;
    
    @EJB
    private IStatesService services;
    
    /**
     * Creates a new instance of PrimefacesData
     */
    public PrimefacesData() {
        
    }

    public List<UsStates> getListOfStates() {
        this.listOfStates = services.listOfStates();
        return listOfStates;
    }

    public void setListOfStates(List<UsStates> listOfStates) {
        this.listOfStates = listOfStates;
    }

    public IStatesService getServices() {
        return services;
    }

    public void setServices(IStatesService services) {
        this.services = services;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateA() {
        return stateA;
    }

    public void setStateA(String stateA) {
        this.stateA = stateA;
    }
    
    public List<String> listOfName(){
    
        List<String> result = new ArrayList<>();
        
        for(UsStates state : services.listOfStates()){
            result.add(state.getUsStateName());
        }
        
        return result;
    }
    
    public List<String> listOfStatesA(String query){
    
        List<String> result = new ArrayList<>();
        
        for(UsStates state : services.lookListByStateNames(query)){
            result.add(state.getUsStateName());
        }
        
        return result;
    }
    
    public Converter testConverter(){
        
        ConverterHelper<UsStates> ch = new ConverterHelper<>();
        
        return ch;
        
    }
}
