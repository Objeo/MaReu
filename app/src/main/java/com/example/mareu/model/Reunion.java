package com.example.mareu.model;


import android.util.Log;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;


/**
 * Model object représentant une Reunion
 */

public class Reunion implements Serializable {



    /**
     * Identifiant
     */
    private String id;

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
    private String timePicker;


    /**
     * Constructor
     */
    public Reunion(String id, String theme, String salle, List<String> participants, String timePicker) {
        this.id = id;
        this.theme = theme;
        this.salle = salle;
        this.participants = participants;
        this.timePicker = timePicker;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getTimePicker() {
        return timePicker;
    }

    public void setTimePicker(String timePicker) {
        this.timePicker = timePicker;
    }


    //public Calendar getHourReunion(){
    // String hh = timePicker.split(":")[0];
    // String mm = timePicker.split(":")[1];


    // Calendar heureReunion = null;
    //heureReunion.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hh));
    //heureReunion.set(Calendar.MINUTE, Integer.parseInt(mm));

    //return heureReunion;
    //}

    public Calendar getHeureDebutReunion(){
        String hh = timePicker.split(":")[0];
        String mm = timePicker.split(":")[1];

        //extraient les heures (hh) et les minutes (mm) à partir d'une variable timePicker qui est une chaîne de caractères au format "HH:mm".
        //La méthode split(":") divise la chaîne en deux parties en utilisant le caractère ":" comme séparateur.
        // Ainsi, hh contient la partie avant les deux points, et mm contient la partie après les deux points.

        Calendar heureDebutReunion = Calendar.getInstance();
        heureDebutReunion.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hh));
        heureDebutReunion.set(Calendar.MINUTE, Integer.parseInt(mm));

        Log.d("getHeureDebutReunion", "Time Picker: " + timePicker);

        //Ces deux lignes définissent les valeurs des heures et des minutes dans l'objet heureReunion.
        // Calendar.HOUR_OF_DAY représente l'heure du jour en format 24 heures.
        // Integer.parseInt(hh) et Integer.parseInt(mm) convertissent les chaînes hh et mm en entiers respectivement,
        // puis les utilisent pour définir les heures et les minutes dans l'objet heureDebutReunion.

        return heureDebutReunion;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reunion reunion = (Reunion) o;
        return id == reunion.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
