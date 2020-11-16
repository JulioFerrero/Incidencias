package com.example.recuperar.DB;

import android.provider.BaseColumns;

class IncidenciaContract  {
    private IncidenciaContract(){}
    public static class IncidenciaEntry implements BaseColumns {
        public static final String TABLE_NAME ="incidencia";
        public static final String ID = "id";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_TITLE2 = "incidencia";
    }
}
