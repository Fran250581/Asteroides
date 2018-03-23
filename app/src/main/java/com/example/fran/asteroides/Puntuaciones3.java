package com.example.fran.asteroides;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

public class Puntuaciones3 extends AppCompatActivity implements AdapterView.OnItemClickListener {

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
        listView.setAdapter(new AdaptadorPuntuaciones(this,
                MainActivity.getAlmacen().listaPuntuaciones(10)));

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AlmacenPuntuaciones almacen = AlmacenPuntuacionesArray.getInstance();
        String s  = almacen.listaPuntuaciones(10).elementAt(position);
        Toast.makeText(this, s , Toast.LENGTH_SHORT).show();
    }
}
