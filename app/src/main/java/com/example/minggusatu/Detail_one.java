package com.example.minggusatu;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Detail_one extends AppCompatActivity {
SharedPreferences sharedPreferences;
TextView emailText, passText;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_one);
        sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        emailText = findViewById(R.id.emailText);
        passText = findViewById(R.id.passText);
        emailText.setText(sharedPreferences.getString("email",null));
        passText.setText(sharedPreferences.getString("pass",null));

    }
}