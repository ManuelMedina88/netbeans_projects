/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.primefacesproject.dao;

import com.itdepartment.newtech.primefacesproject.entities.UsStates;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author manuel
 */
@Stateless
public class StatesDaoImpl implements IStatesDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<UsStates> listOfStates() {
        return em.createQuery("SELECT u FROM UsStates u").getResultList();
    }

    @Override
    public List<UsStates> lookListByStateNames(String state) {
         
        Query query = em.createQuery("SELECT s FROM UsStates s WHERE s.usStateName LIKE :name");
        query.setParameter("name", state+"%");
        return query.getResultList();
        
    }
    
    

}
