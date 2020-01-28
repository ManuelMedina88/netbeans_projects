/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.primefacesproject.dao;

import com.itdepartment.newtech.primefacesproject.entities.UsStates;
import java.util.List;

/**
 *
 * @author manuel
 */
public interface IStatesDao {
    
    public List<UsStates> listOfStates();
    
    public List<UsStates> lookListByStateNames(String state);
    
}
