package com.example.mareutest.service;

import com.example.mareutest.model.Reunion;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */

public class DummyReunionApiService implements ReunionApiService {

    private List<Reunion> reunionsTest = DummyReunionGenerator.generateReunion();
    private List<Reunion> reunions = new ArrayList<>();

    /**
     * {@inheritDoc}
     */

    @Override
    public List<Reunion> getReunionsTest() {
        return reunionsTest;
    }


    @Override
    public List<Reunion> getReunions() {
        return reunions;
    }



    @Override
    public void deleteReunion(Reunion reunion) {
        reunions.remove(reunion);


    }

    @Override
    public void createReunion(Reunion reunion) {
        reunions.add(reunion);

    }
}
