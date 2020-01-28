/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.testingbeans.service;

import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 *
 * @author manuel
 */

@Remote
public interface IStatefulBean {
    
    public String testBean(String name);
    
}
