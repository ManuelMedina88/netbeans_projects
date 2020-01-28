/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.ejbproject3.Dao;

import com.itdepartment.newtech.ejbproject3.Entity.Customers;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author manuel
 */
@Stateful
public class CustomerDaoBean implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveCustomer(Customers customer) {

        System.out.println(customer.getCustomerId()+"\n"+customer.getFirstName()+"\n"+customer.getLastName()+"\n"+customer.getEmail());
        
        try {

            
            if (customer.getCustomerId() == null) {
                saveNewCustomer(customer);
            } else {
                saveNewCustomer(customer);
            }

        } catch (Exception ex) {
            System.out.println("I don't know what happened!");
            ex.printStackTrace();
        }

    }

    private void saveNewCustomer(Customers customer) {
        
        try{
        entityManager.persist(customer);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void updateCustomer(Customers customer) {
        entityManager.merge(customer);
    }

    @Override
    public Customers getCustomer(Long customerId) {
        Customers customer;

        customer = entityManager.find(Customers.class, customerId);

        return customer;
    }

    @Override
    public void deleteCustomer(Customers customer) {

        entityManager.remove(customer);
    }
}
