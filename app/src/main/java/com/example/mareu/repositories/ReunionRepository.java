package com.example.mareu.repositories;

/**
 * Cette classe représente le Repository pour les réunions.
 * Elle utilise le ReunionApiService pour récupérer, ajouter et supprimer des réunions.
 */

import com.example.mareu.di.DI;
import com.example.mareu.model.Reunion;
import com.example.mareu.service.ReunionApiService;

import java.util.Calendar;
import java.util.List;

/** Service pour accéder aux réunions */
public class ReunionRepository {
    private static final ReunionApiService service = DI.getReunionApiService();

    /**
     * Retourne une liste de toutes les réunions à partir du ReunionApiService.
     *
     * @return Liste de toutes les réunions.
     */
    public List<Reunion> getReunions(){
        return service.getReunions();
    }

    /**
     * Retourne une liste de réunions de test à partir du ReunionApiService.
     *
     * @return Liste de réunions de test.
     */
    public List<Reunion> getReunionsTest(){
        return service.getReunionsTest();
    }


    public List<String> getSalleReunion(){
        return service.getSalleReunions();
    }



    /**
     * Supprime une réunion donnée à partir du ReunionApiService.
     *
     * @param reunion La réunion à supprimer.
     */
    public void deleteReunion(Reunion reunion){
        service.deleteReunion(reunion);
    }

    /**
     * Ajoute une réunion donnée à partir du ReunionApiService.
     *
     * @param reunion La réunion à ajouter.
     */
    public void addReunion(Reunion reunion){
        service.createReunion(reunion);
    }

    public List<String> getSallesDispos(Calendar heureReunion) {
        return service.getSallesDispos(heureReunion);
    }

    public List<Reunion> filtrerParSalle(String salle) {
        return service.filtrerParSalle (salle);
    }

    public String getHeureDispo(Calendar time) {
       return service.getHeureDispo(time);
    }
}
