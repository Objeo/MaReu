package com.example.mareutest.service;

import com.example.mareutest.model.Reunion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyReunionGenerator {

    public static List<Reunion> DUMMY_REUNION;
    static {
        ArrayList<String> groupe1 = new ArrayList<>(Arrays.asList("jerome@mail.fr", "Abriel@mail.fr", "Liu@mail.fr"));
        ArrayList<String> groupe2 = new ArrayList<>(Arrays.asList("Claire@mail.fr", "Isabelle@mail.fr", "Gertrude@mail.fr"));
        ArrayList<String> groupe3 = new ArrayList<>(Arrays.asList("Isabelle@mail.fr", "Pedro@mail.fr", "Melisa@mail.fr"));

        DUMMY_REUNION = Arrays.asList(
                new Reunion(1, "theme A","Salle 1", groupe1, 14),
                new Reunion(2, "theme B","Salle 2", groupe2, 16),
                new Reunion(3, "theme C","Salle 3", groupe3, 18)
        );
    }

    static List<Reunion> generateReunion(){
return new ArrayList<>(DUMMY_REUNION);
    }
}
