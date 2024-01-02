package com.example.tryapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = findViewById(R.id.btn);
        Button b2= findViewById(R.id.btn2);
        EditText t1= findViewById(R.id.nm);
        WebView webView = findViewById(R.id.ok1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(Intent.ACTION_VIEW);
                i1.setData(Uri.parse("https://www.digitalgujarat.gov.in/"));
                startActivity(i1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(getApplicationContext(),MainActivity2.class);
                String name=t1.getText().toString();
                i2.putExtra("name",name);
                startActivity(i2);
            }
        });
        Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView webView = findViewById(R.id.ok1);
                webView.loadUrl("https://www.google.com"); // Replace with your desired URL
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                // Do something when the page finishes loading
            }
        });

    }

}
