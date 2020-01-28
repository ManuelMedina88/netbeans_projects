/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.dao;

import com.itdepartment.newtech.domain.Students;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author manuel
 */

@Stateless
public class SchoolDaoImpl implements ISchoolDao{

    @PersistenceContext(unitName="com.itdepartment.newtech_SchoolDatabase_war_1.0PU")
    EntityManager em;
    
    @Override
    public List<Students> listOfStudents() {
        
        return em.createNamedQuery("Students.findAll").getResultList();
    } 
}
