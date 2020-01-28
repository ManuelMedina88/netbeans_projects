/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.bean;

import com.itdepartment.newtech.entities.UsStates;
import com.itdepartment.newtech.services.ISingletonSessionBean;
import com.itdepartment.newtech.services.SingletonSessionBean;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author manuel
 */
@Named(value = "testingSingletonBean")
@RequestScoped
public class TestingSingletonBean implements Serializable {

    private List<UsStates> stateList;

    
    private ISingletonSessionBean singleton;

    /**
     * Creates a new instance of TestingSingletonBean
     */
    public TestingSingletonBean() {
        
           singleton = new SingletonSessionBean();
            
           /*List<UsStates> list = new ArrayList<UsStates>();

            UsStates state = new UsStates(1l, "N/A", "NA");

            list.add(state);*/
           
           try{
               
               singleton.init();
               stateList = singleton.getStateList();
               
               System.out.println(stateList);
               
           }catch(Exception ex){
               ex.printStackTrace();
           }  
    }

    public List<UsStates> getStateList() {
        return stateList;
    }

}
