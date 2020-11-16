package com.example.recuperar;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recuperar.DB.IncidenciaDBHelper;

import java.util.Objects;

import static com.example.recuperar.DB.IncidenciaDBHelper.DATABASE_NAME;

public class remove extends Fragment {

    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;
    int counterNuke=6;

    public remove() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Creation of the dbHelper
        dbHelper = new IncidenciaDBHelper(getActivity().getApplicationContext());
        db = dbHelper.getWritableDatabase();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_remove, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        IncidenciaDBHelper database = new IncidenciaDBHelper(requireActivity().getApplicationContext());

        final Button btnremove = getView().findViewById(R.id.btnRemove);
        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtRemove = getView().findViewById(R.id.txtRemove);
                String titleRemoveString = txtRemove.getText().toString();
                int titleRemove = Integer.parseInt(titleRemoveString);
                database.deleteRow(titleRemove);
                //Incidencia in = new Incidencia(titleIncidencia, "Alta");
                Toast.makeText(getActivity(), "Removed!", Toast.LENGTH_LONG).show();


            }
        });


        final Button btnnuke = getView().findViewById(R.id.nuke);
        btnnuke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(counterNuke > 1) {
                    counterNuke--;
                    Toast.makeText(getActivity(), "La base de datos será borrada en "+counterNuke+" pulsaciones", Toast.LENGTH_SHORT).show();
                } else  {

                    getActivity().deleteDatabase(DATABASE_NAME);
                    Toast.makeText(getActivity(), "Removed!", Toast.LENGTH_LONG).show();
                }

            }
        });

        EditText edittext=(EditText)getView().findViewById(R.id.txtRemove);
        Button submit=(Button)getView().findViewById(R.id.btnRemove);
        edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    //do what you want on the press of 'done'
                    submit.performClick();
                    Toast.makeText(getActivity(), "Removed!", Toast.LENGTH_LONG).show();

                }
                return false;
            }
        });
    }

    @Override
    public void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }
}