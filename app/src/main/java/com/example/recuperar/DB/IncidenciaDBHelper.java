package com.example.recuperar.DB;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.recuperar.DB.IncidenciaContract.*;
import com.example.recuperar.DatosVO;

import java.util.ArrayList;

public class IncidenciaDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "incidencies.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + IncidenciaEntry.TABLE_NAME + "(" + IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + IncidenciaEntry.COLUMN_NAME_TITLE + " TEXT ," + IncidenciaEntry.COLUMN_NAME_TITLE2 + " TEXT)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public IncidenciaDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insertIncidencia(SQLiteDatabase db, String Contenido, String Contenido2){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the incidence getting all values
            values.put(IncidenciaEntry.COLUMN_NAME_TITLE, Contenido);
            values.put(IncidenciaEntry.COLUMN_NAME_TITLE2, Contenido2);

            db.insert(IncidenciaEntry.TABLE_NAME, null, values);
        }else{
            Log.d("sql","Database is closed");
        }
     }


   public ArrayList<DatosVO> returnName() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(IncidenciaEntry.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();

       ArrayList<DatosVO> listaDatos = new ArrayList<>();


       for (int i = 0; i < cursor.getCount(); i++) {
           listaDatos.add(new DatosVO(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
           cursor.moveToNext();
       }
       return listaDatos;
        /*StringBuilder AllString = new StringBuilder();

        String[] AllIncidencia = new String[cursor.getCount()];

        for (int i = 0; i < cursor.getCount(); i++){
            AllIncidencia[i] = "id: "+ cursor.getString(0) + " | Title: " + cursor.getString(1) + " | Incidencia: " + cursor.getString(2);
            cursor.moveToNext();
        }*/

        /*ArrayList<ArrayList<String>> AllIncidencia;
        AllIncidencia = new ArrayList<>();

        for (int i = 0; i < cursor.getCount(); i++){
            AllIncidencia.add(new ArrayList<>());
            AllIncidencia.get(i).add(cursor.getString(0));
            AllIncidencia.get(i).add(cursor.getString(1));
            AllIncidencia.get(i).add(cursor.getString(2));
            cursor.moveToNext();
        }


        AllIncidencia = new ArrayList<String>();

        for (int i = 0; i < cursor.getCount(); i++){
            AllIncidencia.add("id: "+ cursor.getString(0) + " | Title: " + cursor.getString(1) + " | Incidencia: " + cursor.getString(2));
            cursor.moveToNext();
        }*/
    }



    public void deleteRow(int value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + IncidenciaEntry.TABLE_NAME+ " WHERE id ='"+value+"'");
        db.close();
    }


}

