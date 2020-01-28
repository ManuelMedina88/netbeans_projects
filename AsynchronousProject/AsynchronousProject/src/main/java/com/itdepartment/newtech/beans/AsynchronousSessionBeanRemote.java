/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.beans;

import java.util.concurrent.Future;
import javax.ejb.Remote;

/**
 *
 * @author manuel
 */

@Remote
public interface AsynchronousSessionBeanRemote {
    
    public void slowMethod();
    
    public Future<?> slowMethodWithReturnValue();
    
}
