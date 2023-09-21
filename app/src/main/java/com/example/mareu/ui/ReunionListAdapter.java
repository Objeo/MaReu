package com.example.mareu.ui;

import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.databinding.ElementAppearanceBinding;
import com.example.mareu.events.DeleteReunionEvent;
import com.example.mareu.model.Reunion;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class ReunionListAdapter extends ListAdapter<Reunion, ReunionListAdapter.ReunionViewHolder> {
    protected ReunionListAdapter(@NonNull DiffUtil.ItemCallback diffCallback) {
        super(diffCallback);
    }

    private static final String TAG = "ReunionListAdapter";
    private ElementAppearanceBinding binding;
    List<Reunion> reunions;
    private static final int[] colors = {0x958BC34A, 0x7500BCD4,0x97FF9800, 0xBA6F559C};


    @NonNull
    @Override
    public ReunionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ElementAppearanceBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Log.d(TAG, "onCreateViewHolder: ");
        return new ReunionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReunionViewHolder holder, int position) {
        Reunion reunion = getItem(position);
        Log.d(TAG, "onBindViewHolder: "+reunion.getSalle());
        holder.txt1.setText(reunion.getTheme()+" - "+reunion.getTimePicker()+" - "+reunion.getSalle());
        //holder.txt2.setText(reunion.getParticipants());
        String participantsString = "";
        for (String participant : reunion.getParticipants()) {
            participantsString += participant + ". ";
        }
        holder.txt2.setText(participantsString);

        int color = colors[position % colors.length];
        holder.setCircleColor(color);



        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               EventBus.getDefault().post(new DeleteReunionEvent(reunion));
            }
        });



        //Quand cette méthode s'éxécute, le RV demande à ce qu'on lui fournisse un élément d'affichage avec les données.
        // l'élément d'affichage il l'a déjà c'est le parametre holder. Les données sont
    }


    public static class MyDiffCallback extends DiffUtil.ItemCallback<Reunion> {
        @Override
        public boolean areItemsTheSame(@NonNull Reunion oldItem, @NonNull Reunion newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Reunion oldItem, @NonNull Reunion newItem) {
            return oldItem.equals(newItem);
        }
    }

    public static class ReunionViewHolder extends RecyclerView.ViewHolder {
        TextView txt1;
        TextView txt2;
        View mCircleView;
        ImageButton mDeleteButton;

        public void setCircleColor(int color) {
            GradientDrawable background = (GradientDrawable) mCircleView.getBackground();
            background.setColor(color);
        }

        public ReunionViewHolder(@NonNull ElementAppearanceBinding binding) {
            super(binding.getRoot());
            txt1 = binding.textViewSalleHeureTheme;
            txt2 = binding.textViewParticipants;
            mCircleView = binding.circleView;
            mDeleteButton = binding.deleteButton;
        }
    }


}