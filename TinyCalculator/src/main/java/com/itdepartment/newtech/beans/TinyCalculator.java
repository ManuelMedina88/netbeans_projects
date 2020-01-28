/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author manuel
 */
@Named(value = "tinyCalculator")
@RequestScoped
public class TinyCalculator {

    private Double _param1;
    private Double _param2;
    private Double _result;
    /**
     * Creates a new instance of TinyCalculator
     */
    public TinyCalculator() {
    }

    public Double getParam1() {
        return _param1;
    }

    public void setParam1(Double _param1) {
        this._param1 = _param1;
    }

    public Double getParam2() {
        return _param2;
    }

    public void setParam2(Double _param2) {
        this._param2 = _param2;
    }

    public Double getResult() {
        return _result;
    }

    public void setResult(Double _result) {
        this._result = _result;
    }
    
    public void sum(){
        
        _result = _param1 + _param2;
        
    }
    
    public void subst(){
        
        _result = _param1 - _param2;
    }
    
    public void mult(){
        
        _result = _param1 * _param2;
    }
    
    public void division(){
        
        _result = _param1 / _param2;
    }
    
}
