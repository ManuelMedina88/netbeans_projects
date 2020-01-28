/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.primefacesproject.beans;

/**
 *
 * @author manuel
 */
import com.itdepartment.newtech.primefacesproject.entities.UsStates;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ConverterHelper<T> implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        
        UsStates state = new UsStates();
        state.setUsStateName(string);
        
        return state;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        
        UsStates states = (UsStates) t;
        
        String state = states.getUsStateName();
        
        return state;

    }
    
}
