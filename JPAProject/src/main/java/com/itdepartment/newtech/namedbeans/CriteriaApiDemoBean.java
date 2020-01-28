/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.namedbeans;

import com.itdepartment.newtech.entities.UsStates;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author manuel
 */
@Named(value = "criteriaApiDemoBean")
@RequestScoped
public class CriteriaApiDemoBean {

    @PersistenceContext
    private EntityManager entityManager;
    
    private Stream<UsStates> matchingStatesStream;
    private List<UsStates> matchingStatesList;
    
    
    /**
     * Creates a new instance of CriteriaApiDemoBean
     */
    public CriteriaApiDemoBean() {
    }
    
    public String findStates(){
        
        String retVal = "confirmation";
        
        try {
        
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            
            CriteriaQuery<UsStates> criteriaQuery = criteriaBuilder.createQuery(UsStates.class);
            
            Root<UsStates> root = criteriaQuery.from(UsStates.class);
            
            Metamodel metamodel = entityManager.getMetamodel();
            
            EntityType<UsStates> usStateEntityType = metamodel.entity(UsStates.class);
            
            SingularAttribute<UsStates, String> usStateAttribute = 
                    usStateEntityType.getDeclaredSingularAttribute("usStateName", String.class);
            
            Path<String> path = root.get(usStateAttribute);
            
            Predicate predicate = criteriaBuilder.like(path, "New%");
            
            criteriaQuery = criteriaQuery.where(predicate);
            
            TypedQuery typedQuery = entityManager.createQuery(criteriaQuery);
            
            matchingStatesStream = typedQuery.getResultStream();
            
            if(matchingStatesStream != null){
                matchingStatesList = matchingStatesStream.collect(Collectors.toList());
            }
            
            
            
            
        }catch(Exception ex){
        
            retVal = "error";
            
            ex.printStackTrace();
        }
        
        return retVal;
        
    }

    public List<UsStates> getMatchingStatesList() {
        return matchingStatesList;
    }

    public void setMatchingStatesList(List<UsStates> matchingStatesList) {
        this.matchingStatesList = matchingStatesList;
    }
    
    
   
}
