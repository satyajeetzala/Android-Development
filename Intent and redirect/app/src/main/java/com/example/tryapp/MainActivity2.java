package com.example.tryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView t=findViewById(R.id.textView2);
        Intent i=getIntent();
        String name=i.getStringExtra("name");
        t.setText("HELLO  "+name);
    }
}