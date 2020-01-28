/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.namedbeans;

import com.itdepartment.newtech.entities.Addresses;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author manuel
 */
@Named(value = "criteriaUpdateDemoBean")
@RequestScoped
public class CriteriaUpdateDemoBean {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Resource
    private UserTransaction userTransaction;
    
    private int updatedRows;
    /**
     * Creates a new instance of CriteriaUpdateDemoBean
     */
    public CriteriaUpdateDemoBean() {
    }
    
    public String updateData(){
    
        String retVal = "confirmation";
        
        try {
        
            userTransaction.begin();
            
            //insertTempData();
            
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            
            CriteriaUpdate<Addresses> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Addresses.class);
            
            Root<Addresses> root = criteriaUpdate.from(Addresses.class);
            
            criteriaUpdate.set("city", "Boston");
            
            criteriaUpdate.where(criteriaBuilder.equal(root.get("city"), "Bostons"));
            
            Query query = entityManager.createQuery(criteriaUpdate);
            
            updatedRows = query.executeUpdate();
            
            userTransaction.commit();
            
        }catch(Exception ex){
            
            retVal = "error";
            ex.printStackTrace();
            
        }
        
        System.out.println(updatedRows);
        
        return retVal;
    }
    
    private void insertTempData() throws NotSupportedException, 
            SystemException, RollbackException, HeuristicMixedException, 
            HeuristicRollbackException {
    
    }

    public int getUpdatedRows() {
        return updatedRows;
    }

    public void setUpdatedRows(int updatedRows) {
        this.updatedRows = updatedRows;
    }   
    
    
}
