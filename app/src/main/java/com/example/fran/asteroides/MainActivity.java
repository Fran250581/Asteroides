package com.example.fran.asteroides;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button acercaDe = findViewById(R.id.botonAcercaDe);
        acercaDe.setOnClickListener(this);
        Button configurar = findViewById(R.id.botonConfigurar);
        configurar.setOnClickListener(this);
        Button jugar = findViewById(R.id.botonJugar);
        jugar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.botonJugar) {
            mostrarPreferencias();
        }
        if (v.getId()==R.id.botonConfigurar) {
            Intent i = new Intent(this, Prefs.class);
            startActivity(i);
        }
        if (v.getId()==R.id.botonAcercaDe) {
            Intent i = new Intent(this, AcercaDe.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        // this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.acercaDe:
                lanzarAcercaDe();
                break;
            case R.id.config:
                lanzarPreferencias();
                break;
        }
        return true;
    }

    public void lanzarAcercaDe(){
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }

    public void lanzarPreferencias(){
        Intent i = new Intent(this, Prefs.class);
        startActivity(i);
    }

    //Botón Jugar
    void mostrarPreferencias() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String s = "música: "+ pref.getBoolean("musica",true)
                +", gráficos: " + pref.getString("graficos","?");
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    //Botón Salir
    public void salir(View v) {
        finish();
    }

}
