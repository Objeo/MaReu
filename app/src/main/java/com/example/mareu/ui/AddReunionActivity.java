package com.example.mareu.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.mareu.databinding.ActivityAddReunionBinding;
import com.example.mareu.model.Reunion;
import com.example.mareu.viewmodel.ReunionViewModel;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class AddReunionActivity extends AppCompatActivity {

    private static final String TAG = "AddReunionActivity";

    ReunionViewModel mReunionViewModel;
    TimePicker mTimePicker;
    private ActivityAddReunionBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddReunionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

         mReunionViewModel = new ViewModelProvider(this).get(ReunionViewModel.class);

        binding.spinnerSalle.setEnabled(false);

        binding.buttonConfirmHour.setOnClickListener(view -> {
            binding.spinnerSalle.setEnabled(true);


            Calendar userChoiceCalendar = Calendar.getInstance();

            userChoiceCalendar.set(Calendar.HOUR_OF_DAY, mTimePicker.getHour());
            userChoiceCalendar.set(Calendar.MINUTE, mTimePicker.getMinute());

            addSalles(userChoiceCalendar);


                });



        mTimePicker = binding.timePicker;
        mTimePicker.setIs24HourView(true);

        // Définir les valeurs minimales et maximales d'heures et de minutes
        mTimePicker.setHour(8); // Heure minimale : 8h
        mTimePicker.setMinute(0); // Minute minimale : 0



        binding.buttonValidate.setOnClickListener(view -> {
        String theme = Objects.requireNonNull(binding.editTextTheme.getText()).toString();
        String champsParticipants = Objects.requireNonNull(binding.editTextParticipants.getText()).toString();

            if (theme.isEmpty()) {
                Toast.makeText(this, "Veuillez saisir un thème pour la réunion", Toast.LENGTH_SHORT).show();
            } else if (champsParticipants.isEmpty()) {
                Toast.makeText(this, "Veuillez saisir au moins un participant", Toast.LENGTH_SHORT).show();
            } else {
                int selectedHour = mTimePicker.getHour();
                if (selectedHour < 8 || selectedHour >= 18) {
                    Toast.makeText(this, "Veuillez choisir une heure entre 8h et 18h", Toast.LENGTH_SHORT).show();
                } else {

                    //String salle = Objects.requireNonNull(binding.editTextSalle.getText()).toString();
                    List<String> participants = Arrays.asList(Objects.requireNonNull(binding.editTextParticipants.getText()).toString().split(","));
                    String id = UUID.randomUUID().toString();

                    Calendar userValidationCalendar = Calendar.getInstance();
                    userValidationCalendar.set(Calendar.HOUR_OF_DAY, mTimePicker.getHour());
                    userValidationCalendar.set(Calendar.MINUTE, mTimePicker.getMinute());


                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    String time = sdf.format(userValidationCalendar.getTime());

                    String salle = binding.spinnerSalle.getSelectedItem().toString();

                    Reunion reunion = new Reunion(id, theme, salle, participants, time);

                    Intent intent = new Intent();
                    intent.putExtra("MEETING", reunion); //stocker la reunion dans l'intent
                    setResult(Activity.RESULT_OK, intent); //définir l'intent contenant la reunion comme resultat

                    finish();

                }

            }

        });



    }

    private void addSalles(Calendar time){

        List<String> salleDeReunion = mReunionViewModel.getSallesDispos(time);
        if (salleDeReunion.isEmpty()){
            String heureDispo = mReunionViewModel.getHeureDispo(time);
            Toast.makeText(this, "Heure la plus proche disponible : " + heureDispo, Toast.LENGTH_SHORT).show();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, salleDeReunion);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (binding.spinnerSalle != null) {
            binding.spinnerSalle.setAdapter(adapter);
        }
    }
}