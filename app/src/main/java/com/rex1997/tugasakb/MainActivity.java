package com.rex1997.tugasakb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

// Pertama dibuat pada 23 April 2022
// NIM      : 10121702
// NAMA     : BINA DAMAREKSA
// KELAS    : AKB IF-7

public class MainActivity extends AppCompatActivity {

    Button btnProfile, btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProfile = findViewById(R.id.btnProfile);
        btnLogout = findViewById(R.id.btnLogout);

        btnProfile.setOnClickListener(view -> {
            Intent login = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(login);
            finish();
        });

        btnLogout.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this,
                    "SUCCESS : Logout berhasil", Toast.LENGTH_SHORT).show();
            Intent login = new Intent(MainActivity.this, SplashScreenActivity.class);
            startActivity(login);
            finish();
        });
    }
}