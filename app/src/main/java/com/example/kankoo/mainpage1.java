package com.example.kankoo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mainpage1 extends AppCompatActivity {

    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
    }

    public void ViewQR_onClick(View v){
        Intent Intent = new Intent(getApplicationContext(), ViewQR.class);
        startActivityForResult(Intent, 100);
        finish();
    }

    public void ExchangeQR_onClick(View v) {
        Intent Intent = new Intent(getApplicationContext(), ExchangeQR.class);
        startActivityForResult(Intent, 100);
        finish();
    }

    public void MakeQR_onClick(View v) {
        Intent Intent = new Intent(getApplicationContext(), MakeQR0.class);
        startActivityForResult(Intent, 100);
        finish();
    }
}


