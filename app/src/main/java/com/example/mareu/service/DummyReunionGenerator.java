package com.example.mareu.service;

import com.example.mareu.model.Reunion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyReunionGenerator {

    public static List<Reunion> DUMMY_REUNION;
    static {
        ArrayList<String> groupe1 = new ArrayList<>(Arrays.asList("jerome@lamzone.fr", "abriel@lamzone.fr", "liu@lamzone.fr"));
        ArrayList<String> groupe2 = new ArrayList<>(Arrays.asList("claire@lamzone.fr", "isabelle@lamzone.fr", "gertrude@lamzone.fr"));
        ArrayList<String> groupe3 = new ArrayList<>(Arrays.asList("isabelle@lamzone.fr", "pedro@lamzone.fr", "melissa@lamzone.fr"));

        DUMMY_REUNION = Arrays.asList(
                new Reunion("1", "Theme 1","Salle A", groupe1, "14:00"),
                new Reunion("2", "Theme 2","Salle B", groupe2, "16:00"),
                new Reunion("3", "Theme 3","Salle C", groupe3, "18:00")
        );
    }

    static List<Reunion> generateReunion(){
return new ArrayList<>(DUMMY_REUNION);
    }
}
