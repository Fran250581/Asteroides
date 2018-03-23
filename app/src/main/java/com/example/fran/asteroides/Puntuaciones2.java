package com.example.fran.asteroides;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Puntuaciones2 extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puntuaciones);
        setListAdapter(new ArrayAdapter<>(this,
                R.layout.elemento_lista,
                R.id.titulo,
                MainActivity.getAlmacen().listaPuntuaciones(10)));
    }

}
