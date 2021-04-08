package com.example.tugas1_10118348;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

//Tanggal Dibuat : 07-04-2021
//Nim :10118348
//Nama : Muhammad Novel Zalsastian
//Kelas : IF-8

public class MainActivity extends AppCompatActivity {
    private int loading_time=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //next after splash
                Intent login = new Intent(MainActivity.this , LoginActivity.class);
                startActivity(login);
                finish();

            }
        },loading_time);
    }
}

