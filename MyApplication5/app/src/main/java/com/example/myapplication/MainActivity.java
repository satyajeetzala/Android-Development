package com.example.databaseoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2,bt3,bt4;
    EditText ed1,ed2,ed3;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=findViewById(R.id.button);
        bt2=findViewById(R.id.button2);
        bt3=findViewById(R.id.button3);
        bt4=findViewById(R.id.button4);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        tv=findViewById(R.id.textView);


        SqliteDB sqliteDB=new SqliteDB(getApplicationContext());

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c=sqliteDB.getshivtbl();
                c.moveToFirst();
                String data="";
                do{
                    data+=c.getString(0)+"-"+c.getString(1)+"-"+c.getString(2)+"\n";

                }while(c.moveToNext());
                tv.setText(data);

            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqliteDB.addrecord(ed2.getText().toString(),ed3.getText().toString());
                Toast toast=Toast. makeText(getApplicationContext(),"record inserted",Toast. LENGTH_SHORT);
                toast.show();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqliteDB.updaterecord(Integer.parseInt(ed1.getText().toString()),ed2.getText().toString(),ed3.getText().toString());
                Toast toast=Toast. makeText(getApplicationContext(),"record update",Toast. LENGTH_SHORT);
                toast.show();
            }
        });


        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sqliteDB.delrecord(Integer.parseInt(ed1.getText().toString()));
                Toast toast=Toast. makeText(getApplicationContext(),"record delete",Toast. LENGTH_SHORT);
                toast.show();

            }
        });


    }
}
