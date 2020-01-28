/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.services;

import com.itdepartment.newtech.entities.UsStates;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author manuel
 */



@Singleton
public class SingletonSessionBean implements ISingletonSessionBean{
    
    @PersistenceContext(unitName="customerPersistenceUnit")
    EntityManager entityManager;
    
    private List<UsStates> stateList;

    public SingletonSessionBean() {
    }
    
    @PostConstruct
    public void init(){
        
        UsStates state = entityManager.find(UsStates.class, 4l);
        
        System.out.println("No relaje Funciona " + state.getUsStateName());
        
        /*System.out.println("Just fine");
        Query query = entityManager.createQuery("SELECT S FROM UsStates S", UsStates.class);
        System.out.println("Just fine1");
        
       Stream<UsStates> matchingStatesStream = query.getResultStream();
        
       if (matchingStatesStream != null) {
            
                stateList = matchingStatesStream.collect(Collectors.toList());
                
                System.out.println("noemy pase");
       }*/
        
    }

    @Override
    public List<UsStates> getStateList() {
        
        return stateList;
        
    }
    
    public String getString(){
        return "this works";
    }

}
