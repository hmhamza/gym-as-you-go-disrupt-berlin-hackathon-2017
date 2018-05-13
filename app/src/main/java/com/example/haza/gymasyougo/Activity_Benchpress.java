package com.example.haza.gymasyougo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity_Benchpress extends AppCompatActivity {

    TextView textView ;
    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;
    Handler handler;
    int Seconds, Minutes, MilliSeconds ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benchpress);

        setTitle("Bench Press");

        textView = (TextView)findViewById(R.id.textView);

        handler = new Handler() ;

        StartTime = SystemClock.uptimeMillis();
        handler.postDelayed(runnable, 0);

        View.OnClickListener viewListener=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Activity_Benchpress.this);
                builder.setMessage("Finish?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                AlertDialog.Builder builder1 = new AlertDialog.Builder(Activity_Benchpress.this);
                                builder1.setMessage("What do you want to do?")
                                        .setCancelable(false)
                                        .setPositiveButton("To the Payments", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                Intent i = new Intent(Activity_Benchpress.this, Activity_Payments.class);
                                                startActivity(i);
                                                finish();
                                            }
                                        })
                                        .setNegativeButton("Back to Main", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                finish();
                                            }
                                        });
                                AlertDialog alert1 = builder1.create();
                                alert1.show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        };
        View view=(View) findViewById(R.id.view_stopbenchpress);
        view.setOnClickListener(viewListener);
    }

    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;
            UpdateTime = TimeBuff + MillisecondTime;
            Seconds = (int) (UpdateTime / 1000);
            Minutes = Seconds / 60;
            Seconds = Seconds % 60;
            MilliSeconds = (int) (UpdateTime % 1000);

            textView.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));

            handler.postDelayed(this, 0);
        }

    };
}
