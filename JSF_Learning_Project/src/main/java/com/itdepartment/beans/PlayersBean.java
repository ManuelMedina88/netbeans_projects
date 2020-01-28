/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdepartment.beans;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author manuel
 */
enum Plays{
        LEFT, RIGHT
    }

@Named(value = "playersBean")
@RequestScoped
public class PlayersBean {
    
    
    
    private String playerName;
    private String playerSurname;
    private PlayerDetails playerDetails;
    private Boolean champion;
    private Plays play;
    private String[] titles_2013 = {"Sao Paulo", "Acapulco", "ATP World Tour Master 1000 Indian Wells", "Barcelona"};
    private Map<String, String> matchfacts = new HashMap<>();
    private String facebook;
    private boolean show_prize;
    private int prize;
    private boolean show_racquet;
    /**
     * Creates a new instance of PlayersBean
     */
    public PlayersBean() {
        playerName = "Rafael";
        playerSurname = "Nadal";
        champion = true;
        playerDetails = new PlayerDetails(); 
        play = Plays.LEFT;
        matchfacts.put("Aces", "12");
        matchfacts.put("Double Faults", "2");
        matchfacts.put("1st Serve", "70%");
        facebook = "Manuel Medina Pineda";
        show_prize = false;
        prize = 60941937;
                
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerSurname() {
        return playerSurname;
    }

    public Boolean isChampion() {
        return champion;
    }

    public PlayerDetails getPlayerDetails() {
        return playerDetails;
    }    

    public Plays getPlay() {
        return play;
    }

    public String[] getTitles_2013() {
        return titles_2013;
    } 

    public Map<String, String> getMatchfacts() {
        return matchfacts;
    }

    public void vamosRafa_1(){
        System.out.println("Vamos Rafa!");
    }
    
    public String vamosRafa_2(){
        return "Vamos Rafa!";
    }
    
    public void vamosRafa_3(String text){
        System.out.println(text);
    }
    
    public String vamosRafa_4(String name, String surname){
        return "Vamos " + name + " " + surname + "!";
    }
    
    public String vamosRafa_5(){
        return "vamos";
    }

    public String getFacebook() {
        return facebook;
    }

    public boolean isShow_prize() {
        return show_prize;
    }
    
    public void showPrizeMoney(){
        this.show_prize = true;
    }
    
    public void hidePrizeMoney(){
        this.show_prize = false;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isShow_racquet() {
        return show_racquet;
    }

    public void setShow_racquet(boolean show_racquet) {
        this.show_racquet = show_racquet;
    }
    
    public void showHideRacquetPicture(ValueChangeEvent e){
        if(e.getNewValue() == Boolean.TRUE){
            this.show_racquet = true;
            
        } else {
            this.show_racquet = false;
        }
    }
}
