package com.example.ca.coocbook;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton imageEntradas, imageCarnes, imageGuarniciones, imageEnsaladas, imagePastas, imageDesayunos, imageSopas, imagePescados, imagePostres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageEntradas = (ImageButton)findViewById(R.id.imageEntradas);
        imageCarnes = (ImageButton)findViewById(R.id.imageCarnes);
        imageGuarniciones = (ImageButton)findViewById(R.id.imageGuarniciones);
        imageEnsaladas = (ImageButton)findViewById(R.id.imageEnsaladas);
        imagePastas = (ImageButton)findViewById(R.id.imagePastas);
        imageDesayunos = (ImageButton)findViewById(R.id.imageDesayunos);
        imageSopas = (ImageButton)findViewById(R.id.imageSopas);
        imagePescados = (ImageButton)findViewById(R.id.imagePescados);
        imagePostres = (ImageButton)findViewById(R.id.imagePostres);

        imageEntradas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEntradas = new Intent(MainActivity.this, MainEntradas.class);
                startActivity(intentEntradas);
            }
        });

        imageCarnes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCarnes = new Intent(MainActivity.this, MainCarnes.class);
                startActivity(intentCarnes);
            }
        });

        imageGuarniciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGuarniciones = new Intent(MainActivity.this, MainGuarniciones.class);
                startActivity(intentGuarniciones);
            }
        });

        imageEnsaladas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEnsaladas = new Intent(MainActivity.this, MainEnsaladas.class);
                startActivity(intentEnsaladas);
            }
        });

        imagePastas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPastas = new Intent(MainActivity.this, MainPastas.class);
                startActivity(intentPastas);
            }
        });

        imageDesayunos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDesayunos = new Intent(MainActivity.this, MainDesayunos.class);
                startActivity(intentDesayunos);
            }
        });

        imageSopas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSopas = new Intent(MainActivity.this, MainSopas.class);
                startActivity(intentSopas);
            }
        });

        imagePescados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPescados = new Intent(MainActivity.this, MainPescados.class);
                startActivity(intentPescados);
            }
        });

        imagePostres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPostres = new Intent(MainActivity.this, MainPostres.class);
                startActivity(intentPostres);
            }
        });
    }
}
