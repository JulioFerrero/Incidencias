package com.example.recuperar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = findViewById(R.id.insertAdmin);
        final EditText password = findViewById(R.id.insertPass);
        final Button button = findViewById(R.id.btnlogin);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String User = username.getText().toString();
                String Password = password.getText().toString();

                if (User.equals("admin") && Password.equals("admin")) {
                    Success();
                } else  {
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Success() {
        Intent TrueMain = new Intent(this, MainActivity.class);
        startActivity(TrueMain);
    }
}