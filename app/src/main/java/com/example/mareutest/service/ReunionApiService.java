package com.example.mareutest.service;

import com.example.mareutest.model.Reunion;

import java.util.List;

/**
 * Reunion API client
 */

public interface ReunionApiService {

    /**
     * Get all Reunions
     * @return {@link List}
     */
    List<Reunion> getReunionsTest();
    List<Reunion> getReunions();


    /**
     * Delete a Reunion
     */
    void deleteReunion(Reunion reunion);

    /**
     * Create a Reunion
     */
    void createReunion(Reunion reunion);

}
