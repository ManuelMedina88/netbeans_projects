/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.newtech.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

/**
 *
 * @author manuel
 */
@Named(value = "personaBean")
@SessionScoped
public class PersonaBean implements Serializable{

    private Persona persona = new Persona();
    
    List<Persona> listaDePersonas = new ArrayList<>();
    /**
     * Creates a new instance of PersonaBean
     */
    public PersonaBean() {
        
        listaDePersonas.add(new Persona("jM", 50));
        listaDePersonas.add(new Persona("jM", 50));
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void agregar(){
    
        listaDePersonas.add(new Persona(persona.getNombre(), persona.getEdad()));
        System.out.println("Si paso por aqui");
        notificarPush();
    }

    public List<Persona> getListaDePersonas() {
        return listaDePersonas;
    }

    public void setListaDePersonas(List<Persona> listaDePersonas) {
        this.listaDePersonas = listaDePersonas;
    }
    
    public void notificarPush(){
    
        String summary = "Nuevo Elemento";
        String detail = "Se agrego a la lista";
        String CHANNEL = "/notify";
        
        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        eventBus.publish(CHANNEL, new FacesMessage(summary, detail));
        
        for(Persona persona : listaDePersonas){
            System.out.println("Nombre: "+ persona.getNombre() + " Edad: "+ persona.getEdad());
        }
    }

}
