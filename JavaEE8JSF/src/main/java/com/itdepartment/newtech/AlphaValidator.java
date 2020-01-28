/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author manuel
 */
@Named(value = "alphaValidator")
@RequestScoped
public class AlphaValidator {

    /**
     * Creates a new instance of AlphaValidator
     */
    public AlphaValidator() {
    }
    
    public void validateAlpha(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        
        if(!StringUtils.isAlphaSpace((String) value)){
            
            HtmlInputText htmlInputText = (HtmlInputText) uiComponent;
            
            FacesMessage facesMessage = new FacesMessage(
                    htmlInputText.getLabel() + ": only alphabetic characters are allowed.");
            
            throw new ValidatorException(facesMessage);
            
        }    
    }    
}
