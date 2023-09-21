package com.example.mareu.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

import com.example.mareu.di.DI;
import com.example.mareu.service.ReunionApiService;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private ReunionApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

}