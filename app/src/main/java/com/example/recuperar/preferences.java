package com.example.recuperar;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class preferences extends Fragment {

    public preferences() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Muy importante
        View RootView = inflater.inflate(R.layout.fragment_preferences, container, false);

        final Button btn = RootView.findViewById(R.id.button);

        Spinner spinner = (Spinner) RootView.findViewById(R.id.spinner2);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getView());

        String [] values = {"English","Spanish",};

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(RootView.getContext(), android.R.layout.simple_spinner_item, values);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        Toast.makeText(RootView.getContext(), values[spinner.getSelectedItemPosition()], Toast.LENGTH_LONG).show();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (values[spinner.getSelectedItemPosition()] .equals("Spanish")){
                    setLocale("es");
                }
                if (values[spinner.getSelectedItemPosition()] .equals("English")) {
                    setLocale("en");
                }
                String item = spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
                //Toast.makeText(RootView.getContext(), values[spinner.getSelectedItemPosition()], Toast.LENGTH_LONG).show();
                //Incidencia in = new Incidencia(titleIncidencia, "Alta");


            }
        });

        return RootView;

    }


    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(getContext(), MainActivity.class);
        getActivity().finish();
        startActivity(refresh);
    }
}
/*        Configuration config = new Configuration(getResources().getConfiguration());
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
*/