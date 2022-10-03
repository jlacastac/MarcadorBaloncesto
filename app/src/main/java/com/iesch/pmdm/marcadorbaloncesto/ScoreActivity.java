package com.iesch.pmdm.marcadorbaloncesto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.iesch.pmdm.marcadorbaloncesto.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    Bundle extras;
    TextView localScoreTV;
    TextView visitantScoreTV;
    TextView resultTV;
    ActivityScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialize();
        setResult();
    }

    private void initialize() {
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        extras = getIntent().getExtras();
        localScoreTV = binding.localScoreDetailTV;
        visitantScoreTV = binding.visitantScoreDetailTV;

        setContentView(binding.getRoot());
    }

    private void setResult() {
        localScoreTV.setText(extras.getString("localScore"));
        visitantScoreTV.setText(extras.getString("visitantScore"));

        switch(Integer.compare(Integer.valueOf(extras.getString("localScore")),
                               Integer.valueOf((extras.getString("visitantScore"))))) {
            case 1:
                resultTV.setText(getResources().getString(R.string.victoria));
                break;

            case 0:
                resultTV.setText(getResources().getString(R.string.empate));
                break;

            case -1:
                resultTV.setText(getResources().getString(R.string.derrota));
                break;
        }
    }
}