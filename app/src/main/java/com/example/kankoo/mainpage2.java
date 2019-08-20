package com.example.kankoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class mainpage2 extends MainActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_owner);
        Toast.makeText(getApplicationContext(), "QR코드 스캔", Toast.LENGTH_SHORT).show();

        Button qrscan = (Button) findViewById(R.id.btnReadQR);
        qrscan.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QRscanActivity.class);
                startActivity(intent);
            }
        });
    }

    /*
    public void QRscan_onClick(View v){
        intent.putExtra("result", "QR코드 스캔");
        setResult(RESULT_OK, intent);
        finish();
    }


    public void Maechul_onClick(View v){
        intent.putExtra("result", "거래 목록");
        setResult(RESULT_OK, intent);
        finish();
    }

    */


}
