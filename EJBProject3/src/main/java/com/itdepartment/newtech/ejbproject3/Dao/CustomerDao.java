/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.ejbproject3.Dao;

import com.itdepartment.newtech.ejbproject3.Entity.Customers;
import javax.ejb.Remote;

/**
 *
 * @author manuel
 */

@Remote
public interface CustomerDao {
    
    public void saveCustomer(Customers customer);
    
    public Customers getCustomer(Long customerId);
    
    public void deleteCustomer(Customers customer);
}
