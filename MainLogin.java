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

public class MainLogin extends AppCompatActivity {
  Button btnAgregar, btnSubir;
    EditText etId, etNombre,etDescripcion;
    private TextView lblGotoRegister;
    private Button btnLogin;
    private EditText inputEmail;
    private EditText inputPassword;
    private TextView loginErrorMsg;
    final AyudaBD ayudabd= new AyudaBD(getApplicationContext());
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = (EditText) findViewById(R.id.etNombre);
        inputPassword = (EditText) findViewById(R.id.etPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        loginErrorMsg = (TextView) findViewById(R.id.login_error);
        lblGotoRegister=(TextView) findViewById(R.id.link_to_register);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                SQLiteDatabase db = ayudabd.getReadableDatabase();
                String[] argsel ={email};
                String[] projection = {AyudaBD.DatosTabla2.COLUMNA_NOMBRE, AyudaBD.DatosTabla2.COLUMNA_NOMBRE};
                Cursor c = db.query(AyudaBD.DatosTabla2.NOMBRE_TABLA, projection, AyudaBD.DatosTabla2.COLUMNA_NOMBRE+"=?",argsel, null, null, null );
if(c != null){
                c.moveToFirst();
                etNombre.setText(c.getString(0));
                etDescripcion.setText(c.getString(1));
                Toast.makeText(getApplication(),"Iniciando sesion",Toast.LENGTH_LONG).show();
    Intent MainActivity = new Intent(getApplicationContext(), MainActivity.class);
    startActivity(MainActivity);}
                else {
    Toast.makeText(getApplication(),"Usuario incorrecto", Toast.LENGTH_LONG).show();
}

                }

        });
        lblGotoRegister.setOnClickListener(new View.OnClickListener() {

             public void onClick(View view) {
                 Intent MainRegistro = new Intent(getApplicationContext(), MainRegistro.class);
                 startActivity(MainRegistro);
            }
        });
}}