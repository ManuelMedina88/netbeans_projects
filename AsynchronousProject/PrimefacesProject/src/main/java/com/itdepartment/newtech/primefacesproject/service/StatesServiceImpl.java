/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.primefacesproject.service;

import com.itdepartment.newtech.primefacesproject.dao.IStatesDao;
import com.itdepartment.newtech.primefacesproject.entities.UsStates;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author manuel
 */

@Stateless
public class StatesServiceImpl implements IStatesService{

    @EJB
    private IStatesDao states;
    
    @Override
    public List<UsStates> listOfStates() {
        return states.listOfStates();
    }
    
    @Override
    public List<UsStates> lookListByStateNames(String state){
    
        return states.lookListByStateNames(state);
    }
    
}
