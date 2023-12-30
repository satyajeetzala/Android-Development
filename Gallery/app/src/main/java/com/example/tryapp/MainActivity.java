package com.example.tryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText n1, n2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView big = findViewById(R.id.imageView);
        ImageView i1 = findViewById(R.id.imageView0);
        ImageView i2 = findViewById(R.id.imageView1);
        ImageView i3 = findViewById(R.id.imageView2);
        ImageView i4 = findViewById(R.id.imageView3);

        i1.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View view) {
                    Drawable imgpath1= i1.getDrawable();
                    big.setImageDrawable(imgpath1);

                Drawable imgpath2= big.getDrawable();
                i1.setImageDrawable(imgpath2);
            }




        });
        i2.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View view) {
                Drawable imgpath1= i2.getDrawable();
                big.setImageDrawable(imgpath1);
                Drawable imgpath2= big.getDrawable();
                i2.setImageDrawable(imgpath2);
            }




        });
        i3.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View view) {
                Drawable imgpath1= i3.getDrawable();
                big.setImageDrawable(imgpath1);
                Drawable imgpath2= big.getDrawable();
                i3.setImageDrawable(imgpath2);
            }




        });
        i4.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View view) {
                Drawable imgpath1= i4.getDrawable();
                Drawable imgpath2 = big.getDrawable();

                big.setImageDrawable(imgpath1);
                i4.setImageDrawable(imgpath2);


            }




        });

    }

}
