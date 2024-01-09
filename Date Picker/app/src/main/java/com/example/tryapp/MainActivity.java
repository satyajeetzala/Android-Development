package com.example.tryapp;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatePicker picker;
    Button displayDate;
    TextView textview1;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview1 = findViewById(R.id.textView);
        picker = findViewById(R.id.datePicker);


        picker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                textview1.setText(getCurrentDate());
            }
        });
    }

    @SuppressLint("NewApi")
    public String getCurrentDate() {
        StringBuilder builder = new StringBuilder();
        builder.append(picker.getDayOfMonth() + "/");
        builder.append((picker.getMonth() + 1) + "/"); // month is 0 based

        builder.append(picker.getYear());
        return builder.toString();
    }
}
