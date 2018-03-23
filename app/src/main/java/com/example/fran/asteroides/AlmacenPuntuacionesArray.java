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
                    // De momento añadimos unos datos de prueba
                    puntuaciones.add("123000 Pepe Domínguez");
                    puntuaciones.add("111000 Pedro Martínez");
                    puntuaciones.add("011000 Lola Pérez");
                }
            }
        }
        return instancia;
    }
}

