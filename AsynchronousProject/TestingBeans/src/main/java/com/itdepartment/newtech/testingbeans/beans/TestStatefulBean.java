/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.testingbeans.beans;

import com.itdepartment.newtech.testingbeans.service.IStatefulBean;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author manuel
 */
@Named(value = "testStatefulBean")
@RequestScoped
public class TestStatefulBean {

    
    private String name;
    private String value1;
    private String value2;
    
    @EJB
    private IStatefulBean statefulle;
    
   // @EJB(name="StatelessBean")
   // private IStatefulBean statelessBean;
    
    /**
     * Creates a new instance of TestStatefulBean
     */
    public TestStatefulBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IStatefulBean getStatefulle() {
        return statefulle;
    }

    public void setStatefulle(IStatefulBean statefulle) {
        this.statefulle = statefulle;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }
    
    public String llamameStateful(){
    
        setValue1(statefulle.testBean(name));
        //setValue2(statelessBean.testBean(name));
        return "index.xhtml";
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
}
