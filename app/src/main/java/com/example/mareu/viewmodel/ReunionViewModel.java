package com.example.mareu.viewmodel;

/**
 * Cette classe représente le ViewModel pour les réunions.
 * Elle gère la récupération, l'ajout et la suppression de réunions à partir du Repository.
 */

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mareu.model.Reunion;
import com.example.mareu.repositories.ReunionRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReunionViewModel extends ViewModel {

    private static final String TAG = "ReunionViewModel";



    /** Repository pour accéder aux réunions */
     ReunionRepository reunionRepository;

    /** Liste des réunions */
    ArrayList<Reunion> reunions;

    /** MutableLiveData pour notifier les observateurs des changements de données */
    MutableLiveData<ArrayList<Reunion>> mutableLiveData;

    /**
     * Initialise le ViewModel en créant un nouveau ReunionRepository et un nouveau MutableLiveData.
     */
    public ReunionViewModel(){
        reunionRepository = new ReunionRepository();
        mutableLiveData = new MutableLiveData<>();
    }

    /**
     * Retourne le MutableLiveData contenant la liste des réunions.
     *
     * @return MutableLiveData contenant la liste des réunions.
     */
    public MutableLiveData<ArrayList<Reunion>> getMutableLiveData() {
        return mutableLiveData;
    }

    /**
     * Récupère les réunions à partir du Repository et met à jour la liste des réunions dans MutableLiveData.
     */
    //public void fetchReunions(){
        //reunions = new ArrayList<>(reunionRepository.getReunions());
        //mutableLiveData.setValue(reunions);
    //}

    public void fetchReunionsTest(){
        reunions = new ArrayList<>(reunionRepository.getReunionsTest());
        Log.d(TAG, "fetchReunionsTest: "+reunions.size());
        mutableLiveData.setValue(reunions);
    }

    /**
     * Supprime une réunion donnée de la liste des réunions dans le Repository et dans MutableLiveData.
     *
     * @param reunion La réunion à supprimer.
     */
    public void deleteReunion(Reunion reunion){
        reunionRepository.deleteReunion(reunion);
        reunions.remove(reunion);
        mutableLiveData.setValue(reunions);
    }

    /**
     * Ajoute une réunion donnée à la liste des réunions dans le Repository et dans MutableLiveData.
     *
     * @param reunion La réunion à ajouter.
     */
    public void addReunion (Reunion reunion){
        reunionRepository.addReunion(reunion);
        reunions.add(reunion);
        mutableLiveData.setValue(reunions);
    }

    public List<String> getSalleDeReunion(){
        return reunionRepository.getSalleReunion();
    }

    public List<String> getSallesDispos(Calendar heureReunion) {
        return reunionRepository.getSallesDispos(heureReunion);
    }

    public List<Reunion> filtrerParSalle(String salle) {
        return reunionRepository.filtrerParSalle (salle);
    }


    public String getHeureDispo(Calendar time) {
        return reunionRepository.getHeureDispo(time);
    }
}
