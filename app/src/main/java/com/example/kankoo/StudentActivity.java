package com.example.kankoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StudentActivity extends MainActivity{

    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_student);
    }

    public void Custom_onClick(View v){
        intent.putExtra("result", "고객 관리 클릭함");
        setResult(RESULT_OK, intent);
        finish();
    }

    public void Maechul_onClick(View v){
        intent.putExtra("result", "고객 관리 클릭함");
        setResult(RESULT_OK, intent);
        finish();
    }

    public void Goods_onClick(View v){
        intent.putExtra("result", "고객 관리 클릭함");
        setResult(RESULT_OK, intent);
        finish();
    }


}

