/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.util.concurrent.Future;
import javax.ejb.AsyncResult;

/**
 *
 * @author manuel
 */

@Stateless
public class AsynchronousSessionBean implements AsynchronousSessionBeanRemote{
    
    private static Logger logger = Logger.getLogger(AsynchronousSessionBean.class.getName());

    @Override
    @Asynchronous
    public void slowMethod() {
        
        long startTime = System.currentTimeMillis();
        logger.info("entering " + this.getClass().getCanonicalName() + ".slowMethod()");
        
        try{
            Thread.sleep(1000); // simulate processing for 10 seconds
        }catch(InterruptedException ex){
            Logger.getLogger(AsynchronousSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        logger.info("leaving " + this.getClass().getCanonicalName() + ".slowMethod()");
        long endTime = System.currentTimeMillis();
        
        logger.info("execution took " + (endTime - startTime) + " milliseconds");
        
    }

    @Override
    @Asynchronous
    public Future<Long> slowMethodWithReturnValue() {
        try{
            Thread.sleep(15000); // simulate processing for 15 seconds
        }catch(InterruptedException ex){
            Logger.getLogger(AsynchronousSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new AsyncResult<Long>(42L);
    }
     
}
