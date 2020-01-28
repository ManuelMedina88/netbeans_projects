/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.namedbeans;

import com.itdepartment.newtech.entities.UsStates;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author manuel
 */
@Named(value = "selectQueryDemoBean")
@RequestScoped
public class SelectQueryDemoBean {

    @PersistenceContext
    EntityManager entityManager;
    
    private Stream<UsStates> matchingStatesStream;
    private List<UsStates> matchingStateList;
    private String searchParameter;
    
    /**
     * Creates a new instance of SelectQueryDemoBean
     */
    
    public SelectQueryDemoBean() {
        
        matchingStateList = new ArrayList<>();
        matchingStateList.add(new UsStates());
        matchingStateList.add(new UsStates());
       // findStates();
    }
    
    public String findStates(){
    
        String retVal="confirmatin";
        
        try{
            Query query = entityManager.createQuery("SELECT s FROM UsStates s WHERE s.usStateName LIKE :name");
            
            query.setParameter("name",searchParameter + "%");
            
            
            matchingStatesStream = query.getResultStream();
            
            if (matchingStatesStream != null) {
            
                matchingStateList =
                        matchingStatesStream.collect(Collectors.toList());
            }
            
        }catch(Exception e){
            retVal = "error";
            e.printStackTrace();
        }
        
        System.out.println(matchingStateList + " " + "Si Manuel retorna vacio.");
        
        return retVal;
    }

    public List<UsStates> getMatchingStateList() {
        return matchingStateList;
    }

    public void setMatchingStateList(List<UsStates> matchingStateList) {
        this.matchingStateList = matchingStateList;
    }

    public String getSearchParameter() {
        return searchParameter;
    }

    public void setSearchParameter(String searchParameter) {
        this.searchParameter = searchParameter;
    }
    
    
}
