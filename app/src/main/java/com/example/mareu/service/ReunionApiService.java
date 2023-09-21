package com.example.mareu.service;

import com.example.mareu.model.Reunion;

import java.util.Calendar;
import java.util.List;

/**
 * Reunion API client
 */

public interface ReunionApiService {


    List<Reunion> getReunionsTest();

    /**
     * Get all Reunions
     * @return {@link List}
     */
    List<Reunion> getReunions();


    /**
     * Delete a Reunion
     */
    void deleteReunion(Reunion reunion);

    /**
     * Create a Reunion
     */
    void createReunion(Reunion reunion);

    List<String> getSalleReunions();

    List<String> getSallesDispos(Calendar heureReunion);

    String getHeureDispo(Calendar heureReunion);

    List<Reunion> filtrerParSalle(String salle);
}
