/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.singleton;

import com.itdepartment.newtech.dao.IStateDao;
import com.itdepartment.newtech.entities.UsStates;
import com.itdepartment.newtech.service.IStateService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author manuel
 */

@Singleton
public class SingletonSessionBean implements SingletonSessionBeanRemote{
    
    /*@EJB
    private IStateService dao;*/
    
    @PersistenceContext
    private EntityManager entityManager;
    
    
    private List<UsStates> stateList;
    
    public SingletonSessionBean(){
        
       
    }
    
    @PostConstruct
    public void init(){
        
        Query query = entityManager.createQuery("SELECT u FROM UsStates u");
        stateList = query.getResultList();

    }
    
    @Override
    public List<UsStates> getStateList(){

        return stateList;
         
    }
    
}
