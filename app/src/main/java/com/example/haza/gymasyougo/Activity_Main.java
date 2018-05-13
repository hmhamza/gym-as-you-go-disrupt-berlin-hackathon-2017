package com.example.haza.gymasyougo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Main");

        View.OnClickListener view1Listener=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Activity_Main.this);
                builder.setMessage("Start Bench Press?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i = new Intent(Activity_Main.this, Activity_Benchpress.class);
                                startActivity(i);
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
        View view1=(View) findViewById(R.id.view_benchpress);
        view1.setOnClickListener(view1Listener);

        View.OnClickListener view2Listener=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Activity_Main.this);
                builder.setMessage("Start Incline Dumbell Press?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i = new Intent(Activity_Main.this, Activity_Benchpress.class);
                                startActivity(i);
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

        View view2=(View) findViewById(R.id.view_dumbbellpress );
        view2.setOnClickListener(view2Listener);

        View.OnClickListener paymentsBtnListener=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_Main.this, Activity_Payments.class);
                startActivity(i);
            }
        };
        Button paymentsBtn=(Button) findViewById(R.id.btn_payments);
        paymentsBtn.setOnClickListener(paymentsBtnListener);
    }
}
