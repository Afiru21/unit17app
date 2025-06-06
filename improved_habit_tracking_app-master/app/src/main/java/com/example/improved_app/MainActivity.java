package com.example.improved_app;

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
        wellnessTipTextView = findViewById(R.id.wellnessTipTextView);
        addWaterButton = findViewById(R.id.addWaterButton);
        addWorkoutButton = findViewById(R.id.addWorkoutButton);
        goToTimerButton = findViewById(R.id.goToTimerButton);
        goToBmiCalculatorButton = findViewById(R.id.goToBmiCalculatorButton);

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

        // Random wellness tip
        String[] tips = {
                "Drink water regularly.",
                "Take short breaks during workouts.",
                "Maintain a balanced diet.",
                "Stretch before and after exercise.",
                "Get 8 hours of sleep for recovery.",
                "Take deep breaths to relieve stress."
        };
        Random random = new Random();
        String tip = tips[random.nextInt(tips.length)];
        wellnessTipTextView.setText("Wellness Tip: " + tip);

        // Navigate to TimerActivity
        goToTimerButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TimerActivity.class);
            startActivity(intent);
        });

        // Navigate to BMI Calculator Activity
        goToBmiCalculatorButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BmiCalculatorActivity.class);
            startActivity(intent);
        });
    }
}