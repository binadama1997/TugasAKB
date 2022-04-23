package com.rex1997.tugasakb;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// Pertama dibuat pada 22 April 2022
// NIM      : 10121702
// NAMA     : BINA DAMAREKSA
// KELAS    : AKB IF-7

public class LoginActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText textEmail, textPassword;
    Button btnSignIn, btnGoSignUp;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textEmail = findViewById(R.id.textEmail);
        textPassword = findViewById(R.id.textPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnGoSignUp = findViewById(R.id.btnGoSignUp);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        btnSignIn.setOnClickListener(view -> {

            String email = textEmail.getText().toString();
            String pass = textPassword.getText().toString();

            if(TextUtils.isEmpty(email) ||
                    TextUtils.isEmpty(pass)) {
                Toast.makeText(LoginActivity.this,
                        "ERROR : Data tidak lengkap", Toast.LENGTH_SHORT).show();
            } else
            if(!email.matches(String.valueOf(Patterns.EMAIL_ADDRESS))){
                Toast.makeText(LoginActivity.this,
                        "ERROR : Format email tidak sesuai", Toast.LENGTH_SHORT).show();
            } else {
                //cursor = db.rawQuery("SELECT * FROM users WHERE email=? AND password=?", new String[]{email, pass});
                Toast.makeText(LoginActivity.this,
                        "SUCCESS : Login berhasil", Toast.LENGTH_SHORT).show();
                Intent login = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(login);
                finish();
            }
        });
        btnGoSignUp.setOnClickListener(view -> {
            Intent sign_up = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(sign_up);
            finish();
        });
    }
}