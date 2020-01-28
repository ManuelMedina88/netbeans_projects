/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.dao;

import com.itdepartment.newtech.domain.Contact;
import java.util.List;

/**
 *
 * @author manuel
 */
public interface IContactDao {
    public void createContact(Contact contact);
    
    public List<Contact> listOfContacts();
    
    public Contact findAContact(int id);
    
    public void updateContact(Contact contact);
    
    public void deleteContact(int id);
}
