package com.example.mareutest.model;


import java.util.List;

/**
 * Model object représentant une Reunion
 */

public class Reunion {

    /**
     * Identifiant
     */
    private long id;

    /**
     * Theme de la reunion
     */
    private String theme;

    /**
     * Salle de reunion
     */
    private String salle;

    /**
     * Liste des Participants
     */
    private List<String> participants;

    /**
     * Choix horaire
     */
    private int timePicker;


    /**
     * Constructor
     */
    public Reunion(long id, String theme, String salle, List<String> participants, int timePicker) {
        this.id = id;
        this.theme = theme;
        this.salle = salle;
        this.participants = participants;
        this.timePicker = timePicker;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public int getTimePicker() {
        return timePicker;
    }

    public void setTimePicker(int timePicker) {
        this.timePicker = timePicker;
    }

    @Override
    public String toString() {
        return "Reunion{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", salle='" + salle + '\'' +
                ", participants=" + participants +
                ", timePicker=" + timePicker +
                '}';
    }
}
