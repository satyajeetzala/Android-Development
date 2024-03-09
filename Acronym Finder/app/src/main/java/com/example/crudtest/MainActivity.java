package com.example.crudtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TableLayout tableLayout;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper db=new DBHelper(MainActivity.this);
        LinearLayout linearLayout=findViewById(R.id.l1);
        Button insert=findViewById(R.id.button1);
        Button viewAll=findViewById(R.id.button5);
        EditText e1=findViewById(R.id.e1);
        EditText e2=findViewById(R.id.e2);

        //insert
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String acronym=e1.getText().toString();
                String meaning=e2.getText().toString();
                if(acronym.isEmpty() || meaning.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fill the details!!", Toast.LENGTH_SHORT).show();
                }else{
                    db.insertData(acronym,meaning);
                    Toast.makeText(MainActivity.this, "Record Inserted!!!", Toast.LENGTH_SHORT).show();
                }
                viewAll.performClick();
            }
        });

        //viewall
        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = db.displayData();
                int count = c.getCount();
                // Get the linear layout
                LinearLayout linearLayout = findViewById(R.id.lane);
                // Clear the linear layout before adding new content
                linearLayout.removeAllViews();

                // Create the TableLayout
                TableLayout tableLayout = new TableLayout(getApplicationContext());

                for (int i = 0; i < count; i++) {
                    while (c.moveToNext()) {
                        String ID = c.getString(0);
                        String Acronym = c.getString(1);
                        String Meaning = c.getString(2);

                        TableRow row = new TableRow(getApplicationContext());

                        TextView textView1 = new TextView(getApplicationContext());
                        textView1.setText(ID);
                        textView1.setPadding(20, 20, 20, 20);
                        textView1.setBackgroundColor(getColor(R.color.teal_200));

                        TextView textView2 = new TextView(getApplicationContext());
                        textView2.setText(Acronym);
                        textView2.setPadding(20, 20, 20, 20);
                        textView2.setBackgroundColor(getColor(R.color.teal_200));

                        TextView textView3 = new TextView(getApplicationContext());
                        textView3.setText(Meaning);
                        textView3.setPadding(20, 20, 20, 20);
                        textView3.setBackgroundColor(getColor(R.color.teal_200));

                        Button btn1 = new Button(getApplicationContext());
                        btn1.setText("Update");
                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(getApplicationContext(), updateAcronym.class);
                                i.putExtra("ID", ID);
                                i.putExtra("Acronym", Acronym);
                                i.putExtra("Meaning", Meaning);
                                startActivity(i);
                            }
                        });

                        Button btn2 = new Button(getApplicationContext());
                        btn2.setText("Delete");
                        btn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                db.deleteData(ID);
                                // Refresh the layout after deletion
                                LinearLayout linearLayout = findViewById(R.id.lane);
                                // Clear the linear layout before adding new content
                                linearLayout.removeAllViews();
                                viewAll.performClick();
                            }
                        });

                        row.addView(textView1);
                        row.addView(textView2);
                        row.addView(textView3);
                        row.addView(btn1);
                        row.addView(btn2);
                        tableLayout.addView(row);
                    }
                }
                // Add the TableLayout to the LinearLayout
                linearLayout.addView(tableLayout);
            }
        });

    }

    private void refreshLayout() {
    }
}