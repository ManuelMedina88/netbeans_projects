/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.services;

import com.itdepartment.newtech.entities.UsStates;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author manuel
 */

@Remote
public interface ILetsTry {
    
    public List<UsStates> getList();
    
}
