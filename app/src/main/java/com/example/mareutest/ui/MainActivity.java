package com.example.mareutest.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;



import com.example.mareutest.databinding.ActivityMainBinding;
import com.example.mareutest.di.DI;
import com.example.mareutest.model.Reunion;
import com.example.mareutest.service.ReunionApiService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ReunionApiService mApiService;
    private List<Reunion> mReunions;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mApiService = DI.getReunionApiService();
        mReunions = mApiService.getReunions();

        for (Reunion r : mReunions){
            Log.d(TAG, "onCreate: "+r);


        }
    }
}