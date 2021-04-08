package com.example.tugas1_10118348;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    //Tanggal Dibuat : 07-04-2021
    //Nim :10118348
    //Nama : Muhammad Novel Zalsastian
    //Kelas : IF-8
        DatabaseHelper databaseHelper;

        EditText et_username, et_password;
        Button btn_register, btn_login;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            databaseHelper = new DatabaseHelper(this);

            et_username = findViewById(R.id.et_lusername);
            et_password = findViewById(R.id.et_lpassword);

            btn_login = findViewById(R.id.btn_llogin);
            btn_register = findViewById(R.id.btn_lregister);

            btn_register.setOnClickListener(v -> {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            });

            btn_login.setOnClickListener(v -> {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                Boolean checklogin = databaseHelper.CheckLogin(username, password);
                if(checklogin){
                    Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Login Failed...,Try again or register", Toast.LENGTH_SHORT).show();
                }
            });
        }

}


