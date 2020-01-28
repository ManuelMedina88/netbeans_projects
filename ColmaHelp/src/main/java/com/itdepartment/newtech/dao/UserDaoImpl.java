/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.dao;

import com.itdepartment.newtech.domain.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author manuel
 */

@Stateless
public class UserDaoImpl implements IUserDao {

    @PersistenceContext(name="com.itdepartment.newtech_ColmaHelp_war_1.0PU")
    EntityManager em;
    
    @Override
    public List<Users> listOfUsers() {
        return em.createNamedQuery("Users.findAll").getResultList();
    }
    
    
    
}
