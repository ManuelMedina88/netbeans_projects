/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.ejbproject_2.service;

import javax.ejb.Remote;

/**
 *
 * @author manuel
 */

@Remote
public interface ISimpleSessionBoth {
    
    public String getMessage();
    
    public void setParam(String param);
    
    public String getParam();
   
}
