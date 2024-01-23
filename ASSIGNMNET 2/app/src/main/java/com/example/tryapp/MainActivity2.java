package com.example.tryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Retrieve EditText views
        EditText nameEditText = findViewById(R.id.nm);
        EditText enrollmentEditText = findViewById(R.id.roll);
        EditText subject1EditText = findViewById(R.id.sub1);
        EditText subject2EditText = findViewById(R.id.sub2);
        EditText subject3EditText = findViewById(R.id.sub3);

        Button showResultButton = findViewById(R.id.showres);

        // Set OnClickListener for the "showres" button
        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Check if any of the fields are empty
                if (isEmpty(nameEditText.getText().toString()) ||
                        isEmpty(enrollmentEditText.getText().toString()) ||
                        isEmpty(subject1EditText.getText().toString()) ||
                        isEmpty(subject2EditText.getText().toString()) ||
                        isEmpty(subject3EditText.getText().toString())) {
                    // Show a toast message indicating that all fields must be filled
                    showToast("Please fill in all fields");
                } else {
                    // All fields are filled, you can proceed with further processing if needed
                    double subject1Grade = Double.parseDouble(subject1EditText.getText().toString());
                    double subject2Grade = Double.parseDouble(subject2EditText.getText().toString());
                    double subject3Grade = Double.parseDouble(subject3EditText.getText().toString());

                    // Calculate average percentage
                    double averagePercentage = (subject1Grade + subject2Grade + subject3Grade) / 3.0;

                    // Determine pass or fail
                    String result;
                    if (averagePercentage > 50) {
                        result = "Pass";
                    } else {
                        result = "Fail";
                    }

                    // For example, display the data in a TextView
                    Intent i2=new Intent(getApplicationContext(),ResultShow.class);
                    i2.putExtra("percentage", averagePercentage);
                    i2.putExtra("passFailStatus", result);
                    startActivity(i2);
                }
            }
        });
    }

    // Helper method to check if a string is empty
    private boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    // Helper method to show a toast message
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
