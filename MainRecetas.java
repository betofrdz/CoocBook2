package com.example.ca.coocbook;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainRecetas extends AppCompatActivity {
  Button btnAgregar, btnBorrar, btnBuscar, btnActualizar;
    EditText etId, etNombre,etDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);
        btnAgregar = (Button)findViewById(R.id.btnAgregar);
        btnBuscar = (Button)findViewById(R.id.btnBuscar);
        btnBorrar = (Button)findViewById(R.id.btnBorrar);
        btnActualizar = (Button)findViewById(R.id.btnActualizar);
         etId= (EditText)findViewById(R.id.etId);
        etNombre= (EditText)findViewById(R.id.etNombre);
        etDescripcion= (EditText)findViewById(R.id.etDescripcion);

        final AyudaBD ayudabd= new AyudaBD(getApplicationContext());
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v){

                SQLiteDatabase db = ayudabd.getWritableDatabase();
                ContentValues valores= new ContentValues();
                valores.put(AyudaBD.DatosTabla.COLUMNA_ID,etId.getText().toString());
                valores.put(AyudaBD.DatosTabla.COLUMNA_NOMBRE,etNombre.getText().toString());
                valores.put(AyudaBD.DatosTabla.COLUMNA_DESCRIPCION,etDescripcion.getText().toString());



                Long IdGuardado =db.insert(AyudaBD.DatosTabla.NOMBRE_TABLA, AyudaBD.DatosTabla.COLUMNA_ID, valores);
                Toast.makeText(getApplicationContext(), "Receta Guardada: "+IdGuardado ,Toast.LENGTH_LONG).show();
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v){
                SQLiteDatabase db = ayudabd.getWritableDatabase();
                String Selection = AyudaBD.DatosTabla.COLUMNA_ID+"=?";
                String[] argsel ={etId.getText().toString()};
                db.delete(AyudaBD.DatosTabla.NOMBRE_TABLA,Selection,argsel);


            }
        });
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v){
                SQLiteDatabase db = ayudabd.getReadableDatabase();
                String[] argsel ={etId.getText().toString()};
                String[] projection = {AyudaBD.DatosTabla.COLUMNA_NOMBRE, AyudaBD.DatosTabla.COLUMNA_DESCRIPCION};
                Cursor c = db.query(AyudaBD.DatosTabla.NOMBRE_TABLA, projection, AyudaBD.DatosTabla.COLUMNA_ID+"=?",argsel, null, null, null );

                c.moveToFirst();
                etNombre.setText(c.getString(0));
                etDescripcion.setText(c.getString(1));


            }
        });
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v){
                SQLiteDatabase db = ayudabd.getWritableDatabase();
                ContentValues valores= new ContentValues();
                valores.put(AyudaBD.DatosTabla.COLUMNA_NOMBRE,etNombre.getText().toString());
                valores.put(AyudaBD.DatosTabla.COLUMNA_DESCRIPCION,etDescripcion.getText().toString());
                String Selection = AyudaBD.DatosTabla.COLUMNA_ID+"=?";
                String[] argsel ={etId.getText().toString()};
                int count = db.update(AyudaBD.DatosTabla.NOMBRE_TABLA,valores,Selection,argsel);


            }
        });

    }
    private class CargarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            Toast.makeText(getApplicationContext(), "Se almacenaron los datos correctamente", Toast.LENGTH_LONG).show();

        }
    }
    private String downloadUrl(String myurl) throws IOException {
        Log.i("URL",""+myurl);
        myurl = myurl.replace(" ","%20");
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 500;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("respuesta", "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = readIt(is, len);
            return contentAsString;

            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }
}