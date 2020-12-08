package com.example.recuperar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.preference.Preference;
import android.preference.PreferenceManager;
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

        final String PREF_FILE = "Login";

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);

        int ifLoged = sharedPreferences.getInt("Loged", 0);
        if (ifLoged == 1) {
            Success();
        }

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String User = username.getText().toString();
                String Password = password.getText().toString();

                if (User.equals("admin") && Password.equals("admin")) {
                    Success();
                } else {
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @SuppressLint("ApplySharedPref")
    public void Success() {

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Loged",1);
        editor.commit();

        Intent TrueMain = new Intent(this, MainActivity.class);
        startActivity(TrueMain);
    }
}