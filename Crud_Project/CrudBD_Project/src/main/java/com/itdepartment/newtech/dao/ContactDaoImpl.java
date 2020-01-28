/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.dao;

import com.itdepartment.newtech.domain.Contact;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author manuel
 */
@Stateless
public class ContactDaoImpl implements IContactDao{
    
    @PersistenceContext(unitName="com.itdepartment.newtech_CrudBD_Project_war_1.0PU")
    EntityManager em;

    @Override
    public void createContact(Contact contact) {
        em.persist(contact);
    }

    @Override
    public List<Contact> listOfContacts() {
        return em.createNamedQuery("Contact.findAll").getResultList();
    }
    
    @Override
    public Contact findAContact(int id){
        
        return em.find(Contact.class, id);
    }

    @Override
    public void updateContact(Contact contact) {
        em.merge(contact);
    }

    @Override
    public void deleteContact(int id) {
        Contact contactFound = em.find(Contact.class, id);
        em.remove(contactFound);
    }
    
}
