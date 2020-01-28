/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.service;

import com.itdepartment.newtech.dao.IStateDao;
import com.itdepartment.newtech.entities.UsStates;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author manuel
 */

@Stateless
public class StateService implements IStateService{

    @EJB
    private IStateDao dao;
    
    
    @Override
    public List<UsStates> listOfStates() {
        return dao.listOfStates();
    }
    
}
