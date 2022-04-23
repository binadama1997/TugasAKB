package com.rex1997.tugasakb;

import android.content.ContentValues;
import android.content.Intent;
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

public class RegistrationActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText textRegEmail, textRegPassword, textConPassword;
    Button btnSignUp, btnGoSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        textRegEmail = findViewById(R.id.textRegEmail);
        textRegPassword = findViewById(R.id.textRegPassword);
        textConPassword = findViewById(R.id.textConPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnGoSignIn = findViewById(R.id.btnGoSignIn);
        openHelper = new DatabaseHelper(this);

        btnSignUp.setOnClickListener(view -> {
            db=openHelper.getWritableDatabase();
            String regEmail = textRegEmail.getText().toString();
            String regPass = textRegPassword.getText().toString();
            String conPass = textConPassword.getText().toString();

            if(TextUtils.isEmpty(regEmail) ||
                    TextUtils.isEmpty(regPass) || TextUtils.isEmpty(conPass)) {
                Toast.makeText(RegistrationActivity.this,
                        "ERROR : Data tidak lengkap", Toast.LENGTH_SHORT).show();
            } else
            if(!regEmail.matches(String.valueOf(Patterns.EMAIL_ADDRESS))){
                Toast.makeText(RegistrationActivity.this,
                        "ERROR : Format email tidak sesuai", Toast.LENGTH_SHORT).show();
            } else
            if (!regPass.equals(conPass)) {
                Toast.makeText(RegistrationActivity.this,
                        "ERROR : Password tidak sesuai", Toast.LENGTH_SHORT).show();
            } else {
                insertData(regEmail, regPass);
                Toast.makeText(RegistrationActivity.this,
                        "SUCCESS : Berhasil registrasi", Toast.LENGTH_SHORT).show();
                Intent result = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(result);
                finish();
            }
        });

        btnGoSignIn.setOnClickListener(view -> {
            Intent sign_in = new Intent(RegistrationActivity.this, LoginActivity.class);
            startActivity(sign_in);
            finish();
        });
    }

    public void insertData(String regEmail, String regPass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_1, regEmail);
        contentValues.put(DatabaseHelper.COL_2, regPass);
        long result = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }
}