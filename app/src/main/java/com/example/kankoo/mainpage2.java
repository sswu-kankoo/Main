package com.example.kankoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class mainpage2 extends AppCompatActivity {

    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage2);
    }

    public void ReadQR_onClick(View v){
        Intent Intent = new Intent(getApplicationContext(), QRscanActivity.class);
        startActivityForResult(Intent, 100);
        finish();
    }

    public void ManageQR_onClick(View v) {
        Intent Intent = new Intent(getApplicationContext(), ManageQR.class);
        startActivityForResult(Intent, 100);
        finish();
    }
}