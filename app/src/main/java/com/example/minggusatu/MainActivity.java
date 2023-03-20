package com.example.minggusatu;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText emailEdit, passwordEdit;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        emailEdit = findViewById(R.id.editEmail);
        passwordEdit = findViewById(R.id.editPass);
        sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        if (sharedPreferences.contains("email")){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEdit.getText().toString();
                String pass = passwordEdit.getText().toString();
                if (email.equals("admin") && pass.equals("admin")){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    editor.putString("email", email);
                    editor.putString("pass", pass);
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Login gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
