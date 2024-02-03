package com.example.tryapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        Button btn = findViewById(R.id.btnsubmit);
        TextView nm = findViewById(R.id.lblname);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        CheckBox cbAndroid = findViewById(R.id.cbandroid);
        CheckBox cbMern = findViewById(R.id.cbmern);
        CheckBox cbDataScience = findViewById(R.id.cbdatadcience);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radio = radioGroup.getCheckedRadioButtonId();
                RadioButton rd = findViewById(radio);
                String gender = (rd != null) ? rd.getText().toString() : "Not Selected";

                String hobbies = "";
                if (cbAndroid.isChecked()) {
                    hobbies += "Android";
                }
                // Add other hobbies as needed

                // Create the message for the Toast
                String message = "Gender: " + gender + "\nHobbies: " + hobbies;

                // Show the Toast
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
