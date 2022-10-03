package com.iesch.pmdm.marcadorbaloncesto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.iesch.pmdm.marcadorbaloncesto.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityScoreBinding binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = new Bundle();

        TextView localScore = binding.localScoreDetailTV;
        TextView visitantScore = binding.visitantScoreDetailTV;

        localScore.setText(Integer.toString(extras.getInt("localScore")));
        visitantScore.setText(Integer.toString(extras.getInt("visitantScore")));
    }
}