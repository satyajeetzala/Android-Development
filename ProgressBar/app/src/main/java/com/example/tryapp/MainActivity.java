package com.example.tryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProgressBar pb =findViewById(R.id.progressBar);
//        pb.setProgress(50);
//        pb.setSecondaryProgress(75);
        Thread T=new Thread(){
            @Override
            public void run() {
                for (int i=0;i<pb.getMax();i++){
                    pb.setProgress(i);
                     pb.setSecondaryProgress(i+1);
                     try {
                         Thread.sleep(500);

                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                }
            }
        };
        T.start();
    }
    }


