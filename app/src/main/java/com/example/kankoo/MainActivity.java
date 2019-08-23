package com.example.kankoo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //button1(학생)
        Button button1 = findViewById(R.id.activity_student);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View view){
                Intent Intent = new Intent(getApplicationContext(), mainpage1.class);
                startActivityForResult(Intent, 100);
                Toast.makeText(getApplicationContext(), "메인화면 입니다", Toast.LENGTH_SHORT).show();
            }
        });

        //button2(사장님)
        Button button2 = findViewById(R.id.activity_owner);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View view){
                Intent Intent = new Intent(getApplicationContext(), mainpage2.class);
                startActivityForResult(Intent, 100);
                Toast.makeText(getApplicationContext(), "메인화면 입니다", Toast.LENGTH_SHORT).show();
            }
        });



    }


    public void login_onClick(View view){
        Intent intent = new Intent(getApplicationContext(), mainpage2.class);
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
