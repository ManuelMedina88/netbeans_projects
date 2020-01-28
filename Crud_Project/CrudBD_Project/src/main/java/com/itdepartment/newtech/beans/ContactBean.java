/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.beans;

import com.itdepartment.newtech.domain.Contact;
import com.itdepartment.newtech.service.IContactService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author manuel
 */
@Named(value = "contactBean")
@SessionScoped
public class ContactBean implements Serializable {
    
    private int idContact;
    private String firstName;
    private String lastName;
    private String occupation;
    
    private IContactService service;
    
    /**
     * Creates a new instance of ContactBean
     */
    public ContactBean() {
        service = ContactBean.setService();
    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    public void createContact(){
        Contact contact1 = new Contact(firstName, lastName, occupation);
        service.createContact(contact1);
        clearFields();
        
    }
    
    public void search(){
        
        Contact contactSearched = service.findAContact(idContact);
        firstName = contactSearched.getFirstName();
        lastName = contactSearched.getLastName();
        occupation = contactSearched.getOcupation();
        
    }
    
    public void updateContact(){
        Contact contact1 = new Contact(firstName, lastName, occupation);
        contact1.setContactId(idContact);
        service.updateContact(contact1);
        clearFields();
    }
    
    public void deleteContact(){        
        service.deleteContact(idContact);
        clearFields();
    }
    
    public void clearFields(){
    
        idContact = 0;
        firstName = "";
        lastName = "";
        occupation = "";
    }
    
    public List<Contact> listOfContact(){
        return service.listOfContacts();
    }
    
    private static IContactService setService(){
    
        IContactService service = null;
        
        try{
        
            Context jndi = new InitialContext();
            service = (IContactService) jndi.lookup("java:global/CrudBD_Project/ContactServiceImpl!com.itdepartment.newtech.service.IContactService");
            
        }catch(NamingException ex){
            System.out.println("Something wrong.");
        }
        
        return service;
    }
    
}
