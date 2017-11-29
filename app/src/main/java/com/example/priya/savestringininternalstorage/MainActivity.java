package com.example.priya.savestringininternalstorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etsave;
    TextView tv,tv3;
    Button btsave,btread,btcheck;
    String data;
    private String file1 ="mydata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etsave = (EditText) findViewById(R.id.et);
        tv= (TextView) findViewById(R.id.tv);
        btsave =(Button) findViewById(R.id.btsave);
        btread =(Button) findViewById(R.id.btread);
        btcheck =(Button)findViewById(R.id.btcheck);
        tv3 =(TextView)findViewById(R.id.tv3);

        btsave.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {


                data = etsave.getText().toString();

                try {

                    FileOutputStream fout = openFileOutput(file1, MODE_PRIVATE);
                    fout.write(data.getBytes());
                    fout.close();
                    Toast.makeText(getBaseContext(), "File Saved", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            });


        btread.setOnClickListener (new View.OnClickListener() {

            @Override
                    public void onClick(View v){

                    try {
                        FileInputStream fin = openFileInput(file1);
                        int c;
                        String temp = "";
                        while ((c = fin.read()) != -1) {

                            temp = temp + Character.toString((char) c);
                        }
                        tv.setText(temp);
                        Toast.makeText(getBaseContext(), "File read", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                    }
                }
                });

        btcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    File file2 = new File("internal sotrage path here" + File.separator + "filename with extention");
                   // File file = getBaseContext().getFileStreamPath(file1);
                  //  file.exists();
                   try {
                       file2.exists();
                       Toast.makeText(getBaseContext(), "File Exists", Toast.LENGTH_SHORT).show();
                       tv3.append(file1);
                   }
                catch (Exception e) {
                }

            }
        });


        }
    }






