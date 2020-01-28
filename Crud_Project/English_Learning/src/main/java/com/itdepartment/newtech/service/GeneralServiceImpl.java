/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.service;

import com.itdepartment.newtech.dao.IAnswerdDao;
import com.itdepartment.newtech.dao.IUserDao;
import com.itdepartment.newtech.domain.ExamAnswerds;
import com.itdepartment.newtech.domain.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author manuel
 */

@Stateless
public class GeneralServiceImpl implements IGeneralService{

    @Inject
    private IUserDao userDao;
    
    @Inject
    private IAnswerdDao answerdDao;
    
    @Override
    public List<Users> listOfUsers() {
        return userDao.listOfUsers();
    }
    
    @Override
    public List<ExamAnswerds> listOfAnswerds(){
        return answerdDao.listOfAnswerds();
    }
}
