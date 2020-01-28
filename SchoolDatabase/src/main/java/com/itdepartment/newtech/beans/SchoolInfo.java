/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.beans;

import com.itdepartment.newtech.domain.Students;
import com.itdepartment.newtech.service.ISchoolService;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author manuel
 */
@Named(value = "schoolInfo")
@ApplicationScoped
public class SchoolInfo {

    private ISchoolService service;
    private List<Students> listOfStudents;
    
    /**
     * Creates a new instance of SchoolInfo
     */
    public SchoolInfo() {
        service = SchoolInfo.setSchoolService();
        listOfStudents = service.listOfStudents();
    }

    public ISchoolService getService() {
        return service;
    }

    public void setService(ISchoolService service) {
        this.service = service;
    }

    public List<Students> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Students> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }
    
    public static ISchoolService setSchoolService(){
    
        ISchoolService service = null;
        
        try{
        
            Context jndi = new InitialContext();
            service = (ISchoolService) jndi.lookup("java:global/SchoolDatabase/SchoolServiceImpl!com.itdepartment.newtech.service.ISchoolService");
        }catch(NamingException ex){
            System.out.println("Something went wrong");
        }
        
        return service;
    }
    
}
