package ar.edu.unlu.POO.TP1.EJ11;

import java.util.ArrayList;

public class Diccionario {
    private ArrayList<String> palabras = new ArrayList<String>();

    public void agregarPalabra(String palabra) {
        palabras.add(palabra);
    }

    public boolean esPalabraValida(String palabra) {
        return palabras.contains(palabra);
    }
}
