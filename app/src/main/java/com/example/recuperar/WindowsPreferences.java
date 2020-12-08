package com.example.recuperar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WindowsPreferences extends AppCompatActivity {

    private String MyPREFERENCES = "Pref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windows_preferences);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LoadPreferences();


    }

    private void SavePreferences(){

        EditText ed1=(EditText)findViewById(R.id.saved1);
        EditText ed2=(EditText)findViewById(R.id.saved2);
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String v1  = ed1.getText().toString();
        String v2  = ed2.getText().toString();

        editor.putString("Valor1", v1);
        editor.putString("Valor2", v2);

        editor.commit();   // I missed to save the data to preference here,.
    }

    private void LoadPreferences(){
        EditText ed1=(EditText)findViewById(R.id.saved1);
        EditText ed2=(EditText)findViewById(R.id.saved2);
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        ed1.setText(sharedPreferences.getString("Valor1",""));
        ed2.setText(sharedPreferences.getString("Valor2",""));

    }

    @Override
    public void onBackPressed()
    {
        Toast.makeText(getApplicationContext(), "works", Toast.LENGTH_SHORT).show();
        SavePreferences();
        super.onBackPressed();
    }
}