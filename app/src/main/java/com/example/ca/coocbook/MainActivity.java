package com.example.ca.coocbook;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton imageEntradas, imageCarnes, imageGuarniciones, imageEnsaladas, imagePastas, imageDesayunos, imageSopas, imagePescados, imagePostres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();


        if (id == R.id.nav_libro) {
            fragmentManager.beginTransaction().replace(R.id.content_main2, new MainPrincipal()).commit();

        } else if (id == R.id.nav_favoritos) {
            fragmentManager.beginTransaction().replace(R.id.content_main2, new MainFavoritos()).commit();

        } else if (id == R.id.nav_misrecetas) {
            fragmentManager.beginTransaction().replace(R.id.content_main2, new MainMisRecetas()).commit();

        } else if (id == R.id.nav_buscar) {
            fragmentManager.beginTransaction().replace(R.id.content_main2, new MainBuscar()).commit();

        } else if (id == R.id.nav_glosario) {
            fragmentManager.beginTransaction().replace(R.id.content_main2, new MainGlosario()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
