package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DBhelper dbHelper;
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText idEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBhelper(this);
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        idEditText = findViewById(R.id.IdEditText); // Added EditText for ID

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertRecord();
            }
        });

        Button updateButton = findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRecord();
            }
        });

        Button deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteRecord();
            }
        });

        Button viewButton = findViewById(R.id.viewButton);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewRecords();
            }
        });
    }

    private void insertRecord() {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();

        if (!name.isEmpty() && !email.isEmpty()) {
            dbHelper.addRecord(name, email);
            showToast("Record added successfully");
            clearFields();
        } else {
            showToast("Please enter name and email");
        }
    }

    private void updateRecord() {
        String idStr = idEditText.getText().toString();
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();

        if (!idStr.isEmpty() && !name.isEmpty() && !email.isEmpty()) {
            int id = Integer.parseInt(idStr);
            dbHelper.updateRecord(new Record(id, name, email));
            showToast("Record updated successfully");
            clearFields();
        } else {
            showToast("Please enter ID, name, and email");
        }
    }

    private void deleteRecord() {
        String idStr = idEditText.getText().toString().trim();
        if (!idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            dbHelper.deleteRecord(id);
            showToast("Record deleted successfully");
            clearFields();
        } else {
            showToast("Please enter ID");
        }
    }


    private void viewRecords() {
        List<String> records = dbHelper.getAllRecords();
        StringBuilder stringBuilder = new StringBuilder();
        for (String record : records) {
            stringBuilder.append(record).append("\n");
        }
        showToast(stringBuilder.toString());
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void clearFields() {
        nameEditText.setText("");
        emailEditText.setText("");
        idEditText.setText(""); // Clear ID field as well
    }
}
