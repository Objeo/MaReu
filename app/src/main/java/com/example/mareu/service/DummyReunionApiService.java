package com.example.mareu.service;

import com.example.mareu.model.Reunion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Dummy mock for the Api
 */

public class DummyReunionApiService implements ReunionApiService {

    private List<Reunion> reunionsTest = DummyReunionGenerator.generateReunion();
    private List<Reunion> reunions = new ArrayList<>();

    private ArrayList<String> sallesDeReunion;

    public DummyReunionApiService() {
        sallesDeReunion = new ArrayList<>();
        sallesDeReunion.add("Salle A");
        sallesDeReunion.add("Salle B");
        sallesDeReunion.add("Salle C");
        sallesDeReunion.add("Salle D");
        sallesDeReunion.add("Salle E");
    }


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

    @Override
    public List<String> getSalleReunions() {
        return sallesDeReunion;
    }


    @Override
    public List<String> getSallesDispos(Calendar heureReunion) {
        List<String> sallesDispos = new ArrayList<>(sallesDeReunion);

        // Parcourir toutes les réunions pour filtrer les salles déjà occupées
        for (Reunion reunion : reunions) {
            Calendar heureDebutReunionExistante = reunion.getHeureDebutReunion();

            // Ajouter une marge de 45 minutes avant et après l'heure de début de la réunion existante
            Calendar heureDebutMargeAvant = (Calendar) heureDebutReunionExistante.clone();
            heureDebutMargeAvant.add(Calendar.MINUTE, -45);

            Calendar heureDebutMargeApres = (Calendar) heureDebutReunionExistante.clone();
            heureDebutMargeApres.add(Calendar.MINUTE, 45);

            // Vérifier si la nouvelle réunion chevauche la période de 45 minutes autour de l'heure de début de la réunion existante
            if (heureReunion.after(heureDebutMargeAvant) && heureReunion.before(heureDebutMargeApres)) {
                // La salle est occupée à l'heure spécifiée, la supprimer de la liste des salles disponibles
                sallesDispos.remove(reunion.getSalle());
            }

        }

            if (sallesDispos.isEmpty()){
                Calendar prochaineHeure = (Calendar) heureReunion.clone();
                prochaineHeure.add(Calendar.MINUTE, 1);

                Calendar heureLimite = Calendar.getInstance();
                heureLimite.set(Calendar.HOUR_OF_DAY, 18);
                heureLimite.set(Calendar.MINUTE, 0);
                heureLimite.set(Calendar.SECOND, 0);
                heureLimite.set(Calendar.MILLISECOND, 0);



                while (prochaineHeure.getTime().before(heureLimite.getTime())) {
                     boolean hOk = isHeureOK(prochaineHeure);

                    if (hOk) {
                        break;
                    } else {
                        prochaineHeure.add(Calendar.MINUTE, 1);
                    }
                }
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
                String heureDisponible = sdf.format(prochaineHeure.getTime());

            }

                return sallesDispos;
    }

    @Override
    public String getHeureDispo(Calendar heureReunion) {
        List<String> sallesDispos = new ArrayList<>(sallesDeReunion);

        String heureDisponible = "";

        // Parcourir toutes les réunions pour filtrer les salles déjà occupées
        for (Reunion reunion : reunions) {
            Calendar heureDebutReunionExistante = reunion.getHeureDebutReunion();

            // Ajouter une marge de 45 minutes avant et après l'heure de début de la réunion existante
            Calendar heureDebutMargeAvant = (Calendar) heureDebutReunionExistante.clone();
            heureDebutMargeAvant.add(Calendar.MINUTE, -45);

            Calendar heureDebutMargeApres = (Calendar) heureDebutReunionExistante.clone();
            heureDebutMargeApres.add(Calendar.MINUTE, 45);

            // Vérifier si la nouvelle réunion chevauche la période de 45 minutes autour de l'heure de début de la réunion existante
            if (heureReunion.after(heureDebutMargeAvant) && heureReunion.before(heureDebutMargeApres)) {
                // La salle est occupée à l'heure spécifiée, la supprimer de la liste des salles disponibles
                sallesDispos.remove(reunion.getSalle());
            }

        }

        if (sallesDispos.isEmpty()){
            Calendar prochaineHeure = (Calendar) heureReunion.clone();
            prochaineHeure.add(Calendar.MINUTE, 1);

            Calendar heureLimite = Calendar.getInstance();
            heureLimite.set(Calendar.HOUR_OF_DAY, 18);
            heureLimite.set(Calendar.MINUTE, 0);
            heureLimite.set(Calendar.SECOND, 0);
            heureLimite.set(Calendar.MILLISECOND, 0);



            while (prochaineHeure.getTime().before(heureLimite.getTime())) {
                boolean hOk = isHeureOK(prochaineHeure);

                if (hOk) {
                    break;
                } else {
                    prochaineHeure.add(Calendar.MINUTE, 1);
                }
            }
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
             heureDisponible = sdf.format(prochaineHeure.getTime());

        }//Toast.makeText(context, "Heure la plus proche disponible : " + heureDisponible, Toast.LENGTH_SHORT).show();

        return heureDisponible;
    }

     private boolean isHeureOK(Calendar heureReunion) {
        List<String> sallesDispos = new ArrayList<>(sallesDeReunion);

        // Parcourir toutes les réunions pour filtrer les salles déjà occupées
        for (Reunion reunion : reunions) {
            Calendar heureDebutReunionExistante = reunion.getHeureDebutReunion();

            // Ajouter une marge de 45 minutes avant et après l'heure de début de la réunion existante
            Calendar heureDebutMargeAvant = (Calendar) heureDebutReunionExistante.clone();
            heureDebutMargeAvant.add(Calendar.MINUTE, -45);

            Calendar heureDebutMargeApres = (Calendar) heureDebutReunionExistante.clone();
            heureDebutMargeApres.add(Calendar.MINUTE, 45);

            // Vérifier si la nouvelle réunion chevauche la période de 45 minutes autour de l'heure de début de la réunion existante
            if (heureReunion.after(heureDebutMargeAvant) && heureReunion.before(heureDebutMargeApres)) {
                // La salle est occupée à l'heure spécifiée, la supprimer de la liste des salles disponibles
                sallesDispos.remove(reunion.getSalle());
            }

        }

    return sallesDispos.size()>0;

    }

    public List<Reunion> filtrerParSalle(String salle) {
        List<Reunion> reunionsFiltrees = new ArrayList<>();

        for (Reunion reunion : reunions) {
            if (reunion.getSalle().equals(salle)) {
                reunionsFiltrees.add(reunion);
            }
        }

        return reunionsFiltrees;
    }

}
