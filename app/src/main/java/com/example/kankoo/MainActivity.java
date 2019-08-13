package com.example.kankoo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Button button = (Button)findViewById(R.id.activity_student);

        button.setOnClickListener(new button.OnClickListener(){
            public void onClick(View v)
        });
        Toast.makeText(getApplicationContext(), "학생화면", Toast.LENGTH_SHORT).show();


    }


    public void login_onClick(View view){
        Intent intent = new Intent(getApplicationContext(), OwnerActivity.class);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == RESULT_OK){
            Toast.makeText(getApplicationContext(), data.getStringExtra("result"), Toast.LENGTH_LONG).show();
        }
    }
}
