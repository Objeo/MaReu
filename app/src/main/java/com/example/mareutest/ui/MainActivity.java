package com.example.mareutest.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.mareutest.di.DI;
import com.example.mareutest.model.Reunion;
import com.example.mareutest.service.ReunionApiService;
import com.example.mareutest.databinding.ActivityMainBinding;
import com.example.mareutest.viewmodel.ReunionViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ReunionApiService mApiService;
    private List<Reunion> mReunions;
    private static final String TAG = "MainActivity";

    ReunionViewModel mReunionViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initData();

        mApiService = DI.getReunionApiService();


    }

    private void initData(){
        mReunionViewModel = new ViewModelProvider(this).get(ReunionViewModel.class);
        mReunionViewModel.getMutableLiveData().observe(this, reunion -> {
            Log.d(TAG, "initData: "+mReunions.toString());
        });
    }
}