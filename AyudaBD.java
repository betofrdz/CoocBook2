package com.example.ca.coocbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Judith on 19/11/2016.
 */

public class AyudaBD extends SQLiteOpenHelper {

    public static class DatosTabla implements BaseColumns {
        public static final String NOMBRE_TABLA = "Recetario";
        public static final String COLUMNA_ID = "Id";
        public static final String COLUMNA_NOMBRE = "Nombre";
        public static final String COLUMNA_DESCRIPCION = "Descripcion";

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        private static final String CREAR_TABLA1 =
                "CREATE TABLE " + DatosTabla.NOMBRE_TABLA + " (" +
                        DatosTabla.COLUMNA_ID + " INTEGER PRIMARY KEY," +
                        DatosTabla.COLUMNA_NOMBRE + TEXT_TYPE + COMMA_SEP +
                        DatosTabla.COLUMNA_DESCRIPCION + TEXT_TYPE + " )";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + DatosTabla.NOMBRE_TABLA;
    }
    public static class DatosTabla2 implements BaseColumns {
        public static final String NOMBRE_TABLA = "Usuarios";
        public static final String COLUMNA_ID = "Id";
        public static final String COLUMNA_NOMBRE = "Nombre";
        public static final String COLUMNA_EMAIL = "email";
        public static final String COLUMNA_PASS = "Password";

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        private static final String CREAR_TABLA1 =
                "CREATE TABLE " + DatosTabla2.NOMBRE_TABLA + " (" +
                        DatosTabla2.COLUMNA_ID + " INTEGER PRIMARY KEY," +
                        DatosTabla2.COLUMNA_NOMBRE + TEXT_TYPE + COMMA_SEP +DatosTabla2.COLUMNA_PASS + TEXT_TYPE + COMMA_SEP +
                        DatosTabla2.COLUMNA_EMAIL + TEXT_TYPE + " )";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + DatosTabla2.NOMBRE_TABLA;
    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MiBasedeDatos.db";

    public AyudaBD(Context context) {
        super(context, DATABASE_NAME , null,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DatosTabla.CREAR_TABLA1);
        onCreate(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DatosTabla.SQL_DELETE_ENTRIES);
    }
}