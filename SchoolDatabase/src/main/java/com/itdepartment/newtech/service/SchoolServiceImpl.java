/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.service;

import com.itdepartment.newtech.dao.ISchoolDao;
import com.itdepartment.newtech.domain.Students;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author manuel
 */

@Stateless
public class SchoolServiceImpl implements ISchoolService {

    @Inject
    private ISchoolDao dao;
    
    @Override
    public List<Students> listOfStudents() {
        return dao.listOfStudents();
    }
    
}
