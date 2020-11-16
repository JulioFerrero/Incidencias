package com.example.recuperar;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.recuperar.DB.IncidenciaDBHelper;
import com.example.recuperar.DB.IncidenciaDBHelper.*;

import java.util.Objects;

public class list extends Fragment {

    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;
    ListView simpleList;



    public list() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Creation of the dbHelper
        dbHelper = new IncidenciaDBHelper(getActivity().getApplicationContext());
        db = dbHelper.getWritableDatabase();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        IncidenciaDBHelper database = new IncidenciaDBHelper(requireActivity().getApplicationContext());
        //TextView textView = (TextView) getView().findViewById(R.id.textView);
        //textView.setText(database.returnName());

        ListView listView = (ListView) getView().findViewById(R.id.simpleListView);
        String[] returnTable = database.returnName();

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(getContext(), R.layout.activity_listview, returnTable);
        listView.setAdapter(adapter);

        if(database.returnName().length == 0){
            TextView textView = (TextView) getView().findViewById(R.id.textView);
            textView.setText("ᕕ( ᐛ )ᕗ");
        }

    }

    @Override
    public void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }
}