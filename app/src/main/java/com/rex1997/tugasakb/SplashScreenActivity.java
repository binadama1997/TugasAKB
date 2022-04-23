package com.rex1997.tugasakb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

// Pertama dibuat pada 22 April 2022
// NIM      : 10121702
// NAMA     : BINA DAMAREKSA
// KELAS    : AKB IF-7

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        int delay = 3000;
        new Handler().postDelayed(() -> {
            Intent login=new Intent(SplashScreenActivity.this, LoginActivity.class);
            startActivity(login);
            finish();

        }, delay);
    }
}