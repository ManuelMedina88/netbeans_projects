/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author manuel
 */
@Named(value = "mockTest")
@SessionScoped
public class MockTest implements Serializable{

    private String answerd1;
    private String answerd2;
    private String answerd3;
    private double total;
    private boolean showTotal;
    
    /**
     * Creates a new instance of MockTest
     */
    public MockTest() {
        showTotal = false;
        total = 0.0;
    }

    public String getAnswerd1() {
        System.out.println("InteractGet1");
        return answerd1;
    }

    public void setAnswerd1(String answerd1) {
        System.out.println("InteractSet1");
        this.answerd1 = answerd1;
    }

    public String getAnswerd2() {
        System.out.println("InteractGet2");
        return answerd2;
    }

    public void setAnswerd2(String answerd2) {
        System.out.println("InteractSet2");
        this.answerd2 = answerd2;
    }

    public String getAnswerd3() {
        System.out.println("InteractGet3");
        return answerd3;
    }

    public void setAnswerd3(String answerd3) {
        System.out.println("InteractSet3");
        this.answerd3 = answerd3;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isShowTotal() {
        return showTotal;
    }

    public void setShowTotal(boolean showTotal) {
        this.showTotal = showTotal;
    }
        
    public void calculateTest(){
        
        String[] answerds = {"Pink", "Blue", "Green"};
        String[] studentAnswerds = {answerd1, answerd2, answerd3};
                      
        System.out.println(answerd1);
        System.out.println(answerd2);
        System.out.println(answerd3);
        
        for(int i = 0; i < answerds.length; i++){
            if(answerds[i].equals(studentAnswerds[i])){
                total += 3.0;
            }
        }
        
        showTotal = true;
        
    }
    
}
