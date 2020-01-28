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
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author manuel
 */
@Named(value = "criteriaDeleteDemoBean")
@RequestScoped
public class CriteriaDeleteDemoBean {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Resource
    private UserTransaction userTransaction;
    
    private int deletedRows;
    
    /**
     * Creates a new instance of CriteriaDeleteDemoBean
     */
    public CriteriaDeleteDemoBean() {
    }
    
    public String deleteData(){
    
        String retVal = "confirmation";
        
        try{
        
            userTransaction.begin();
            
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            
            CriteriaDelete<Addresses> criteriaDelete = criteriaBuilder.createCriteriaDelete(Addresses.class);
            
            Root<Addresses> root = criteriaDelete.from(Addresses.class);
            
            criteriaDelete.where(criteriaBuilder.or(criteriaBuilder.equal(root.get("city"), "Boston"), 
                    criteriaBuilder.equal(root.get("city"), "Boston")));
            
            Query query = entityManager.createQuery(criteriaDelete);
            
            deletedRows = query.executeUpdate();
            
            userTransaction.commit();
            
        }catch(Exception ex){
        
            retVal = "error";
            ex.printStackTrace();
        }
        
        return retVal;
        
    }

    public int getDeletedRows() {
        return deletedRows;
    }

    public void setDeletedRows(int deletedRows) {
        this.deletedRows = deletedRows;
    }
    
    
    
}
