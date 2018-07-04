package com.example.android.internastorageapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends Activity {
    EditText ed1;
    TextView tv;
    Button writeButto, readButton;
    private String fileName = "myFile";
    private String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.ed1);
        tv = findViewById(R.id.tv);
        writeButto = findViewById(R.id.write_button);
        readButton = findViewById(R.id.read_button);


        writeButto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = ed1.getText().toString();
                try {
                    FileOutputStream fout = openFileOutput(fileName, MODE_PRIVATE);
                    fout.write(data.getBytes());
                    fout.close();
                    Toast.makeText(MainActivity.this, "Write to file done!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fin = openFileInput(fileName);
                    int c;
                    String temp = "";
                    while ((c = fin.read()) != -1){
                        temp += Character.toString((char) c);
                    }
                    tv.setText(temp);
                    Toast.makeText(MainActivity.this, "Read completed", Toast.LENGTH_SHORT).show();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
