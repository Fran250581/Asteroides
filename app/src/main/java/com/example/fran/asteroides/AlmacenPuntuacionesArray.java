package com.example.fran.asteroides;

import java.util.Vector;

public class AlmacenPuntuacionesArray implements AlmacenPuntuaciones  {

    private static Vector<String> puntuaciones;
    private static AlmacenPuntuacionesArray instancia = null;

    @Override
    public void guardarPuntuacion(int puntos, String nombre, long fecha) {
        puntuaciones.add(0, puntos + " "+ nombre);
    }

    @Override
    public Vector<String> listaPuntuaciones(int cantidad) {
        return  puntuaciones;
    }

    @Override
    public boolean hayPuntuaciones() {
        return (!puntuaciones.isEmpty());
    }

    // Costructor privado para patrón singleton
    private AlmacenPuntuacionesArray() {
    }

    // Contrucción singleton
    static AlmacenPuntuacionesArray getInstance() {
        if (instancia == null) {
            synchronized (AlmacenPuntuacionesArray.class) {
                if (instancia == null) {
                    instancia = new AlmacenPuntuacionesArray();
                    puntuaciones= new Vector<>();
                    String s;
                    // De momento añadimos unos datos de prueba
                    for (int i = 1; i <= 100; i++) {
                        s = Integer.toString(Math.round((float)Math.random()*10000)) +
                                " Usuario " + Integer.toString(i);
                        puntuaciones.add(s);
                    }
                }
            }
        }
        return instancia;
    }

}

