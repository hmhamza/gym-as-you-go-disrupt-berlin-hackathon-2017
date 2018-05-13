package com.example.haza.gymasyougo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity_Welcome extends AppCompatActivity {

    //private static int TIME_OUT = 10000; //Time to launch the another activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        /*
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Activity_Welcome.this, Activity_Main.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
        */


        View.OnClickListener viewListener=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_Welcome.this, Activity_Main.class);
                startActivity(i);
                finish();
            }
        };

        View view=(View) findViewById(R.id.view_onwelcome );
        view.setOnClickListener(viewListener);
    }
}
