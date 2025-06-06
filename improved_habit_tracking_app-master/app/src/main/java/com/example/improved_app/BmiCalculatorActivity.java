package com.example.improved_app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BmiCalculatorActivity extends AppCompatActivity {

    private EditText heightEditText;
    private EditText weightEditText;
    private Button calculateBmiButton;
    private TextView bmiResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);
        calculateBmiButton = findViewById(R.id.calculateBmiButton);
        bmiResultTextView = findViewById(R.id.bmiResultTextView);

        calculateBmiButton.setOnClickListener(v -> {
            String heightStr = heightEditText.getText().toString();
            String weightStr = weightEditText.getText().toString();

            if (heightStr.isEmpty() || weightStr.isEmpty()) {
                Toast.makeText(BmiCalculatorActivity.this, "Please enter both height and weight", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                float heightCm = Float.parseFloat(heightStr);
                float weightKg = Float.parseFloat(weightStr);

                if (heightCm <= 0 || weightKg <= 0) {
                    Toast.makeText(BmiCalculatorActivity.this, "Height and weight must be positive", Toast.LENGTH_SHORT).show();
                    return;
                }

                float heightM = heightCm / 100;
                float bmi = weightKg / (heightM * heightM);

                String bmiCategory;
                if (bmi < 18.5) bmiCategory = "Underweight";
                else if (bmi < 25) bmiCategory = "Normal weight";
                else if (bmi < 30) bmiCategory = "Overweight";
                else bmiCategory = "Obesity";

                String resultText = String.format("BMI: %.2f (%s)", bmi, bmiCategory);
                bmiResultTextView.setText(resultText);

            } catch (NumberFormatException e) {
                Toast.makeText(BmiCalculatorActivity.this, "Invalid number format", Toast.LENGTH_SHORT).show();
            }
        });
    }
}