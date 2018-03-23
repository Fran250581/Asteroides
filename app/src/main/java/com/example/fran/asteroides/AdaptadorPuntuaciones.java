package com.example.fran.asteroides;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

public class AdaptadorPuntuaciones extends BaseAdapter {

    private final Activity activity;
    private final Vector<String> lista;

    public AdaptadorPuntuaciones(Activity activity, Vector<String> lista) {
        super();
        this.activity = activity;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.elemento_lista, null, true);
        TextView textView = view.findViewById(R.id.titulo);
        textView.setText(lista.elementAt(position));
        ImageView imageView = view.findViewById(R.id.icono);

        switch (Math.round((float)Math.random()*3)){
            case 0:
                imageView.setImageResource(R.drawable.asteroide1);
                break;
            case 1:
                imageView.setImageResource(R.drawable.asteroide2);
                break;
            default:
                imageView.setImageResource(R.drawable.asteroide3);
                break;
        }
        return view;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int arg0) {
        return lista.elementAt(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
