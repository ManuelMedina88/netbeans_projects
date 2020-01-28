/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.service;

import com.itdepartment.newtech.dao.IUserDao;
import com.itdepartment.newtech.domain.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author manuel
 */

@Stateless
public class UserServiceImpl implements IUserService{

    @Inject
    private IUserDao userDao;
    
    @Override
    public List<Users> listOfUsers() {
        return userDao.listOfUsers();
    }
    
    
    
}
