package com.example.app_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int waterIntake = 0;
    private int workoutCount = 0;

    private TextView waterTextView;
    private TextView workoutTextView;
    private TextView wellnessTipTextView;
    private Button addWaterButton;
    private Button addWorkoutButton;
    private Button goToTimerButton;
    private Button goToBmiCalculatorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views
        waterTextView = findViewById(R.id.waterTextView);
        workoutTextView = findViewById(R.id.workoutTextView);
        addWaterButton = findViewById(R.id.addWaterButton);
        addWorkoutButton = findViewById(R.id.addWorkoutButton);
        goToTimerButton = findViewById(R.id.goToTimerButton);


        // Water intake logic
        addWaterButton.setOnClickListener(v -> {
            waterIntake++;
            waterTextView.setText("Water Intake: " + waterIntake + " glasses");
        });

        // Workout count logic
        addWorkoutButton.setOnClickListener(v -> {
            workoutCount++;
            workoutTextView.setText("Workouts: " + workoutCount);
        });


        // Navigate to TimerActivity
        goToTimerButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TimerActivity.class);
            startActivity(intent);
        });


    }
}