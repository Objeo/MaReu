package com.example.mareutest.repositories;

import com.example.mareutest.model.Reunion;
import com.example.mareutest.service.DummyReunionApiService;

import java.util.List;

public class ReunionRepository {
DummyReunionApiService mDummyReunionApiService;

    public ReunionRepository() {
        this.mDummyReunionApiService = new DummyReunionApiService();
    }

    public List<Reunion> loadReunions(){
    return mDummyReunionApiService.getReunions();
    }

    public List<Reunion> loadInitialReunions(){
        return mDummyReunionApiService.getReunionsTest();
    }

    public void deleteReunion(Reunion reunion){
        mDummyReunionApiService.deleteReunion(reunion);
    }

    public void createReunion(Reunion reunion){
        mDummyReunionApiService.createReunion(reunion);
    }


}
