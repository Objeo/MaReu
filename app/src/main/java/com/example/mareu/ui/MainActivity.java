package com.example.mareu.ui;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.R;
import com.example.mareu.databinding.ActivityMainBinding;
import com.example.mareu.events.DeleteReunionEvent;
import com.example.mareu.model.Reunion;
import com.example.mareu.viewmodel.ReunionViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ReunionViewModel mReunionViewModel;
    RecyclerView recyclerView;

    ReunionListAdapter mAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.salleA) {
            // Filtrer par salle A
            List<Reunion> reunionsFiltrees = mReunionViewModel.filtrerParSalle("Salle A");
            mAdapter.submitList(reunionsFiltrees);
            return true;
        } else if (itemId == R.id.salleB) {
            // Filtrer par salle B
            List<Reunion> reunionsFiltrees = mReunionViewModel.filtrerParSalle("Salle B");
            mAdapter.submitList(reunionsFiltrees);
            return true;
        } else if (itemId == R.id.salleC) {
            // Filtrer par salle C
            List<Reunion> reunionsFiltrees = mReunionViewModel.filtrerParSalle("Salle C");
            mAdapter.submitList(reunionsFiltrees);
            return true;
        } else if (itemId == R.id.salleD) {
            // Filtrer par salle D
            List<Reunion> reunionsFiltrees = mReunionViewModel.filtrerParSalle("Salle D");
            mAdapter.submitList(reunionsFiltrees);
            return true;
        } else if (itemId == R.id.salleE) {
            // Filtrer par salle E
            List<Reunion> reunionsFiltrees = mReunionViewModel.filtrerParSalle("Salle E");
            mAdapter.submitList(reunionsFiltrees);
            return true;
        } else if (itemId == R.id.menu_reset) {
            // Réinitialiser le filtre
            List<Reunion> toutesLesReunions = mReunionViewModel.getMutableLiveData().getValue();
            mAdapter.submitList(toutesLesReunions);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = binding.ReunionRV;

        setSupportActionBar(binding.toolbar);


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddReunionActivity.class);
                startActivityForResult(intent, 10);
            }
        });


        initViewModel();
    }

    private void initViewModel() {
        // Initialisation du ViewModel
        mReunionViewModel = new ViewModelProvider(this).get(ReunionViewModel.class);

        // Déclenchement de la récupération des réunions depuis le Repository
        mReunionViewModel.fetchReunionsTest();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Observation des changements du LiveData dans le ViewModel
        mReunionViewModel.getMutableLiveData().observe(this, reunions -> {
            // Lorsque le LiveData est mis à jour, cette lambda est exécutée

            // Création d'un nouvel adaptateur avec les données mises à jour
            mAdapter = new ReunionListAdapter(new ReunionListAdapter.MyDiffCallback());

            // Soumission de la nouvelle liste de réunions à l'adaptateur
            mAdapter.submitList(reunions);

            // Définition de l'adaptateur pour le RecyclerView
            recyclerView.setAdapter(mAdapter);
        });
    }

    public ReunionViewModel getViewModel() {
        return mReunionViewModel;
    }

    @Subscribe
    public void onDeleteReunion(DeleteReunionEvent event) {
        mReunionViewModel.deleteReunion(event.reunion);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onResume() {
    super.onResume();
    //mReunionViewModel.fetchReunions();
        mReunionViewModel.getMutableLiveData().observe(this, reunions -> {
            mAdapter.submitList(reunions);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode ==10 && resultCode  == RESULT_OK){
            Reunion reunion = (Reunion) data.getSerializableExtra("MEETING");
            mReunionViewModel.addReunion(reunion);
        }
    }

}
