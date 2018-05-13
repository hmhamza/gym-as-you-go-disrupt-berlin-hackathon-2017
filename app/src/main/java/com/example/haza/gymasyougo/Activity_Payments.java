package com.example.haza.gymasyougo;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Activity_Payments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        setTitle("Payments");

        ImageView qrCode = (ImageView) findViewById(R.id.img_qrcode);
        qrCode.setImageResource(R.drawable.qrcode);

        View.OnClickListener doneBtnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_Payments.this, Activity_Main.class);
                startActivity(i);
                finish();
            }
        };
        Button doneBtn = (Button) findViewById(R.id.btn_done);
        doneBtn.setOnClickListener(doneBtnListener);
    }
}