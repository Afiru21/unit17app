package com.example.multi_screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button next_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        next_button = findViewById(R.id.next_button);
        next_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        nextScreen();
        switchActivity ();
    }

    private void switchActivity() {
    }

    private void nextScreen() {
        Intent nextScreen = new Intent(this, SecondActivity.class);
        startActivity(nextScreen);

    }


}
