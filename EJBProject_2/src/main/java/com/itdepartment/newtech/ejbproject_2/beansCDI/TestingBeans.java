/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.ejbproject_2.beansCDI;

import com.itdepartment.newtech.ejbproject_2.service.ISimpleSessionBoth;
import com.itdepartment.newtech.ejbproject_2.service.SimpleSessionBeanStateless;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author manuel
 */
@Named(value = "testingBeans")
@RequestScoped
public class TestingBeans {

    @EJB    
    private ISimpleSessionBoth statelessBean;
    /**
     * Creates a new instance of TestingBeans
     */
    public TestingBeans() {
        
        // statelessBean = BeanHelper.getStatelessBean();
    }

    public ISimpleSessionBoth getStatelessBean() {
        return statelessBean;
    }

    public void setStatelessBean(ISimpleSessionBoth statelessBean) {
        this.statelessBean = statelessBean;
    }
    
}
