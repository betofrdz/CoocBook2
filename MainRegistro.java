package com.example.ca.coocbook;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class MainRegistro extends AppCompatActivity {
  Button btnAgregar, btnSubir;
    EditText etId, etNombre,etPass,txtEmail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etPass = (EditText) findViewById(R.id.etPass);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        btnAgregar = (Button) findViewById(R.id.btnRegister);

        final AyudaBD ayudabd= new AyudaBD(getApplicationContext());
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v){

                SQLiteDatabase db = ayudabd.getWritableDatabase();
                ContentValues valores= new ContentValues();
                valores.put(AyudaBD.DatosTabla2.COLUMNA_ID,etId.getText().toString());
                valores.put(AyudaBD.DatosTabla2.COLUMNA_NOMBRE,etNombre.getText().toString());
                valores.put(AyudaBD.DatosTabla2.COLUMNA_EMAIL,txtEmail.getText().toString());
                valores.put(AyudaBD.DatosTabla2.COLUMNA_PASS,etPass.getText().toString());



                Long IdGuardado =db.insert(AyudaBD.DatosTabla2.NOMBRE_TABLA, AyudaBD.DatosTabla.COLUMNA_ID, valores);
                Toast.makeText(getApplicationContext(), "Usuario Registrado: "+IdGuardado ,Toast.LENGTH_LONG).show();
            }
        });

    }

}
