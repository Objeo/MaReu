package com.example.mareu.service;

import static org.junit.Assert.*;


import com.example.mareu.model.Reunion;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class DummyReunionApiServiceTest {

    DummyReunionApiService SUT;

    @Before
    public void setUp() {
        SUT = new DummyReunionApiService();
    }

    @Test
    public void getReunionsTest_shouldReturnListOfReunions() {
        List<Reunion> reunionsTest = SUT.getReunionsTest();
        assertNotNull(reunionsTest);
        assertEquals(DummyReunionGenerator.generateReunion().size(), reunionsTest.size());
    }

    @Test
    public void getReunions_shouldReturnListOfReunions() {
        List<Reunion> reunions = SUT.getReunions();
        assertNotNull(reunions);
    }

    @Test
    public void deleteReunion_shouldRemoveReunionFromList() {
        List<String> particpantTest = new ArrayList<>();
        Reunion reunionToDelete = new Reunion("idTest", "themeTest", "SalleTest", particpantTest, "18h");

        SUT.createReunion(reunionToDelete);
        int initialSize = SUT.getReunions().size();
        assertEquals(1, initialSize);

        SUT.deleteReunion(reunionToDelete);

        int newSize = SUT.getReunions().size();
        assertEquals(0, newSize);
        assertFalse(SUT.getReunions().contains(reunionToDelete));
    }

    @Test
    public void createReunion_shouldAddReunionToList() {
        List<String> particpantTest = new ArrayList<>();
        Reunion newReunion = new Reunion("idTest", "themeTest", "SalleTest", particpantTest, "18h");
        int initialSize = SUT.getReunions().size();

        SUT.createReunion(newReunion);

        int newSize = SUT.getReunions().size();
        assertEquals(initialSize + 1, newSize);
        assertTrue(SUT.getReunions().contains(newReunion));
    }

    @Test
    public void getSalleReunions_shouldReturnListOfSalleNames() {
        List<String> sallesDeReunion = SUT.getSalleReunions();
        assertNotNull(sallesDeReunion);
        assertEquals(5, sallesDeReunion.size());
        // Add more specific assertions if needed
    }

    @Test
    public void getSallesDispos_shouldReturnAvailableSalleNames() {
        // Assuming you have a Calendar object and Context object
        Calendar heureReunion = new GregorianCalendar();

        List<String> sallesDispos = SUT.getSallesDispos(heureReunion);
        assertNotNull(sallesDispos);
        // Add more specific assertions if needed
    }


    @Test
    public void filtrerParSalle_shouldReturnListOfReunionsFilteredBySalle() {
        // Assuming you have a salle name
        String salleToFilter = "Salle A";

        List<Reunion> reunionsFiltrees = SUT.filtrerParSalle(salleToFilter);
        assertNotNull(reunionsFiltrees);
        // Add more specific assertions if needed
    }


}