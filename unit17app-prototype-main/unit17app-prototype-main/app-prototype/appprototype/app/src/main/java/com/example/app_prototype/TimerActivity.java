package com.example.app_prototype;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;
import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private boolean isRunning = false;
    private long pauseOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        chronometer = findViewById(R.id.chronometer);
        Button startStopButton = findViewById(R.id.startStopButton);
        Button resetButton = findViewById(R.id.resetButton);
        Button backToMainButton = findViewById(R.id.backToMainButton);

        startStopButton.setOnClickListener(v -> {
            if (isRunning) {
                chronometer.stop();
                pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            } else {
                chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                chronometer.start();
            }
            isRunning = !isRunning;
        });

        resetButton.setOnClickListener(v -> {
            chronometer.setBase(SystemClock.elapsedRealtime());
            pauseOffset = 0;
            if (isRunning) {
                chronometer.start();
            }
        });

        backToMainButton.setOnClickListener(v -> {
            finish(); // Ends TimerActivity, returns to MainActivity
        });
    }
}