package com.example.minggusatu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
Button btnKembali, btnLogout, btnDetail;
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        btnKembali = findViewById(R.id.btnKembali);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();

            }
        });
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
        btnDetail = findViewById(R.id.btnDetail);
        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, DetailActivity.class);
                startActivity(intent);

            }

        });
    }
    private boolean isLoggedIn() {
        return sharedPreferences.getBoolean("isLoggedIn", false);
    }

    // Fungsi untuk logout
    private void logout() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear(); // Menghapus semua data dari SharedPreference
        editor.apply();
    }
}