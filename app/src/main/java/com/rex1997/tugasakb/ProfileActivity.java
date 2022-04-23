package com.rex1997.tugasakb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

// Pertama dibuat pada 23 April 2022
// NIM      : 10121702
// NAMA     : BINA DAMAREKSA
// KELAS    : AKB IF-7

public class ProfileActivity extends AppCompatActivity {

    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnHome = findViewById(R.id.btnHome);

        btnHome.setOnClickListener(view -> {
            Intent home = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(home);
            finish();
        });
    }
}