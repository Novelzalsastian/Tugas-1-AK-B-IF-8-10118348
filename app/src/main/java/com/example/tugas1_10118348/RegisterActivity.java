package com.example.tugas1_10118348;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    //Tanggal Dibuat : 07-04-2021
    //Nim :10118348
    //Nama : Muhammad Novel Zalsastian
    //Kelas : IF-8

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        DatabaseHelper databaseHelper;

        EditText et_lusername, et_lpassword, et_lcpassword , et_lphone ,et_lemail;
        Button btn_lregister,btn_llogin;

        databaseHelper = new DatabaseHelper(this);
            et_lusername = findViewById(R.id.et_lusername);
            et_lpassword = findViewById(R.id.et_lpassword);
            et_lcpassword = findViewById(R.id.et_lcpassword);
            et_lphone = findViewById(R.id.et_lphone);
            et_lemail = findViewById(R.id.et_lemail);
            btn_lregister = findViewById(R.id.btn_lregister);
            btn_llogin=findViewById(R.id.btn_llogin);

        btn_llogin.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });
            btn_lregister.setOnClickListener(v -> {
                String username = et_lusername.getText().toString();
                String password = et_lpassword.getText().toString();
                String confirm_password = et_lcpassword.getText().toString();
                String email_add = et_lemail.getText().toString();
                String phone_no = et_lphone.getText().toString();

                if (username.equals("") || password.equals("") || confirm_password.equals("") || phone_no.equals("") || email_add.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields Required", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(confirm_password)) {
                        Boolean checkusername = databaseHelper.CheckUsername(username);
                        if (checkusername) {
                            boolean insert = databaseHelper.Insert(username, password, email_add, phone_no);
                            if (insert) {
                                Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                                et_lusername.setText("");
                                et_lpassword.setText("");
                                et_lcpassword.setText("");
                                et_lemail.setText("");
                                et_lphone.setText("");
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Username already taken,Make a new one", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password does not match,Try to remeber the right combination", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


