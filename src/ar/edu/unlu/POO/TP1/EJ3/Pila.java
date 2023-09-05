package ar.edu.unlu.POO.TP1.EJ3;

import ar.edu.unlu.POO.TP1.EJ1.Nodo;

public class Pila {
    private Nodo tope;
    private int longitud;

    public Pila() {
        this.tope = null;
        this.longitud = 0;
    }

    public boolean esVacia () {
        return longitud == 0;
    }

    public int longitudPila () {
        return longitud;
    }

    public void apilar (int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (tope == null) {
            tope = nuevoNodo;
        } else {
            Nodo backup = tope;
            tope = nuevoNodo;
            tope.setSiguiente(backup);
        }
        longitud++;

    }

    public void desapilar () {
        if (tope == null) {
            return;
        } else {
            tope = tope.getSiguiente();
            longitud--;
        }
    }

    public Nodo recuperar () {
        return tope;
    }
}
