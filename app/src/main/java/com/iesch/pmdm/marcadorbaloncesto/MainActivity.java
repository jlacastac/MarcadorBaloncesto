package com.iesch.pmdm.marcadorbaloncesto;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.iesch.pmdm.marcadorbaloncesto.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    private Counter localScore;
    private Counter visitantScore;

    private TextView localScoreTV;
    private TextView visitantScoreTV;

    private Button localAddOneBtn;
    private Button localAddTwoBtn;
    private Button localSubBtn;

    private Button visitantAddOneBtn;
    private Button visitantAddTwoBtn;
    private Button visitantSubBtn;

    private ImageButton restartScoreIBtn;
    private ImageButton openDetailsIBtn;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialize();
        setListeners();
        resetMatch();
    }

    private void initialize() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        localScore = new Counter(0);
        visitantScore = new Counter(0);

        localScoreTV = binding.localScoreTV;
        visitantScoreTV = binding.visitantScoreTV;

        localAddOneBtn = binding.localAddOneBtn;
        localAddTwoBtn = binding.localAddTwoBtn;
        localSubBtn = binding.localSubBtn;

        visitantAddOneBtn = binding.visitantAddOneBtn;
        visitantAddTwoBtn = binding.visitantAddTwoBtn;
        visitantSubBtn = binding.visitantSubBtn;

        restartScoreIBtn = binding.restartScoreIBtn;
        openDetailsIBtn = binding.openDetailsIBtn;

        setContentView(binding.getRoot());
    }

    private void setListeners() {
        localAddOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add(localScoreTV, localScore, 1);
            }
        });

        localAddTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add(localScoreTV, localScore, 2);
            }
        });

        localSubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sub(localScoreTV, localScore, 1);
            }
        });

        visitantAddOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add(visitantScoreTV, visitantScore, 1);
            }
        });

        visitantAddTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add(visitantScoreTV, visitantScore, 2);
            }
        });

        visitantSubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sub(visitantScoreTV, visitantScore, 1);
            }
        });

        restartScoreIBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetMatch();
            }
        });

        openDetailsIBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goDetails();
            }
        });
    }

    private void goDetails() {
        Intent detailIntent = new Intent(this, ScoreActivity.class);

        detailIntent.putExtra("localScore", Integer.toString(localScore.getNumber()));
        detailIntent.putExtra("visitantScore", Integer.toString(visitantScore.getNumber()));

        startActivity(detailIntent);
    }

    private void add(TextView tv, Counter score, int points) {
        score.add(points);
        tv.setText(Integer.toString(score.getNumber()));
    }

    private void sub(TextView tv, Counter score, int points) {
        score.sub(points);
        tv.setText(Integer.toString(score.getNumber()));
    }

    private void resetMatch() {
        localScore.reset();
        visitantScore.reset();

        localScoreTV.setText(Integer.toString(localScore.getNumber()));
        visitantScoreTV.setText(Integer.toString(visitantScore.getNumber()));
    }
}