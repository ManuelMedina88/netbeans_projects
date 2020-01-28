/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.service;

import com.itdepartment.newtech.dao.IContactDao;
import com.itdepartment.newtech.domain.Contact;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author manuel
 */

@Stateless
public class ContactServiceImpl implements IContactService{

     @Inject
     IContactDao dao;
    
    @Override
    public void createContact(Contact contact) {
        dao.createContact(contact);
    }

    @Override
    public List<Contact> listOfContacts() {
        return dao.listOfContacts();
    }
    
    public Contact findAContact(int id){
        return dao.findAContact(id);
    }

    @Override
    public void updateContact(Contact contact) {
        dao.updateContact(contact);
    }

    @Override
    public void deleteContact(int id) {
        dao.deleteContact(id);
    }
    
}
