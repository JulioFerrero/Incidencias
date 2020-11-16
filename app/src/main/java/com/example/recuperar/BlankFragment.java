package com.example.recuperar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BlankFragment extends Fragment {

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View menu = inflater.inflate(R.layout.fragment_blank, container, false);

        final Button btnadd = menu.findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();
                Fragment fragmentAddIncidencia = new addIncidencia();

                menuTransaction.replace(R.id.MainFragment, fragmentAddIncidencia);
                menuTransaction.commit();
            }
        });

        final Button btnlist = menu.findViewById(R.id.btnlist);
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();
                Fragment fragmentList = new list();

                menuTransaction.replace(R.id.MainFragment, fragmentList);
                menuTransaction.commit();
            }
        });

        final Button btnremove = menu.findViewById(R.id.btnremove);
        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();
                Fragment fragmentRemove = new remove();

                menuTransaction.replace(R.id.MainFragment, fragmentRemove);
                menuTransaction.commit();
            }
        });


        return menu;
    }
}