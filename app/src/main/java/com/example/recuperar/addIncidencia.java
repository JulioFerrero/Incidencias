package com.example.recuperar;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recuperar.DB.IncidenciaDBHelper;

public class addIncidencia extends Fragment {

    IncidenciaDBHelper dbHelper;
    SQLiteDatabase db;
    public addIncidencia() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //Creation of the dbHelper
        dbHelper = new IncidenciaDBHelper(requireActivity().getApplicationContext());
        db = dbHelper.getWritableDatabase();


        // Inflate the layout for this fragment
        View addIncidencia = inflater.inflate(R.layout.fragment_add_incidencia, container, false);

        final Button btnsave = addIncidencia.findViewById(R.id.btnsave);


        Spinner spinner = (Spinner) addIncidencia.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getView());

        Spinner spinnerEstate = (Spinner) addIncidencia.findViewById(R.id.spinnerEstate);
        spinnerEstate.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getView());
        //List<String> categories = new ArrayList<String>();
        //categories.add("Baja");
        //categories.add("Media");
        //categories.add("Alta");

        String[ ] labelsImpotancia;
        Resources res1 = getResources();
        labelsImpotancia = res1.getStringArray( R.array.Incidencia ) ;

        String[ ] labelsEstado;
        Resources res = getResources();
        labelsEstado = res.getStringArray( R.array.Estados ) ;

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labelsImpotancia);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter1);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, labelsEstado);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstate.setAdapter(dataAdapter);

        EditText edittext=(EditText)addIncidencia.findViewById(R.id.txtIncidencia);
        @SuppressLint("CutPasteId") Button submit=(Button)addIncidencia.findViewById(R.id.btnsave);

        edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    //do what you want on the press of 'done'
                    submit.performClick();
                    Toast.makeText(getActivity(), "Saved!", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtIncidencia = addIncidencia.findViewById(R.id.txtIncidencia);
                String titleIncidencia = txtIncidencia.getText().toString();

                String item = spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
                EditText txtDescripcion = addIncidencia.findViewById(R.id.descrpicion);
                String Descripcion = txtDescripcion.getText().toString();
                String Estate = spinnerEstate.getItemAtPosition(spinnerEstate.getSelectedItemPosition()).toString();
                dbHelper.insertIncidencia(db,titleIncidencia,item,Descripcion,Estate,"Date");

                Toast.makeText(getActivity(), "Saved!", Toast.LENGTH_LONG).show();
                //Incidencia in = new Incidencia(titleIncidencia, "Alta");


            }
        });

                
        return addIncidencia;
    }

    @Override
    public void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }
}