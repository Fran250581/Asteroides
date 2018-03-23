package com.example.fran.asteroides;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class Puntuaciones2 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puntuaciones);

        // Obtener el ListView
        FrameLayout frameLayout = findViewById(R.id.frame);
        ListView listView = (ListView)frameLayout.getChildAt(0);

        // Obtener el almacen de puntuaciones
        AlmacenPuntuaciones almacen = MainActivity.getAlmacen();

        // Establecer la visibilidad en función de si hay
        // puntuaciones o no las hay
        if (!almacen.hayPuntuaciones()) {
            listView.setVisibility(View.INVISIBLE);
            frameLayout.getChildAt(1).setVisibility(View.VISIBLE);
        }
        else {
            listView.setVisibility(View.VISIBLE);
            frameLayout.getChildAt(1).setVisibility(View.INVISIBLE);
        }

        // Establecer el adaptador, el layout y los datos
        listView.setAdapter(new ArrayAdapter<>(this,
                R.layout.elemento_lista,
                R.id.titulo,
                MainActivity.getAlmacen().listaPuntuaciones(10)));
    }

}
