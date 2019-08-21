package com.example.kankoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MakeQR0 extends AppCompatActivity {

    EditText year, semester, major, quantity;
    Button btnGenQR;

    String outputString;
    String AES = "AES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_qr0);

        year = findViewById(R.id.year);
        semester = findViewById(R.id.semester);
        major = findViewById(R.id.major);
        quantity = findViewById(R.id.quantity);

        btnGenQR = findViewById(R.id.btnGenQR);

        //암호화
        final String inputPassword = "merongmerong";

        //반복문





        btnGenQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 입력된 값이 하나라도 없다면
                if (year.getText().toString().equals("") ||
                        semester.getText().toString().equals("") ||
                        major.getText().toString().equals("") ||
                        quantity.getText().toString().equals("")) {
                    Toast.makeText(MakeQR0.this,
                            "입력된 값이 없습니다.",
                            Toast.LENGTH_LONG).show();
                } else { // 공백이 아닐 때
                    String s1 = year.getText().toString(); // year 값 가져오기 (xml -> java)
                    String s2 = semester.getText().toString();
                    String s3 = major.getText().toString();
                    String s4 = quantity.getText().toString();
                    String result = s1 + s2 + s3 + s4;
                    String result_original = s1 + s2 + s3 + s4;

                    //암호화
                    try {
                        result = encrypt(Editable.Factory.getInstance().newEditable(result), inputPassword);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Intent Intent = new Intent(getApplicationContext(), MakeQR.class);

                    Intent.putExtra("result", result);
                    Intent.putExtra("result_original", result_original);
                    startActivityForResult(Intent, 100);
                    finish();
                }
            }
        });
    }

    private String encrypt(Editable Data, String password) throws Exception {
        SecretKeySpec key = generateKey(password);
        Cipher c = Cipher.getInstance(AES);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.toString().getBytes());
        String encryptedValue = Base64.encodeToString(encVal, Base64.DEFAULT);
        return encryptedValue;
    }

    private SecretKeySpec generateKey(String password) throws Exception {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = password.getBytes(StandardCharsets.UTF_8);
        digest.update(bytes, 0, bytes.length);
        byte[] key = digest.digest();
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        return secretKeySpec;
    }

}
