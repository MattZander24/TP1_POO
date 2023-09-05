package ar.edu.unlu.POO.TP1.EJ4.TP1;

import ar.edu.unlu.POO.TP1.EJ1.Nodo;

public class Cola {
    private Nodo frente;
    private Nodo fin;
    private int longitud;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.longitud = 0;
    }

    public boolean esVacia () {
        return longitud == 0;
    }

    public int longitudPila () {
        return longitud;
    }

    public void encolar (int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (frente == null) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            Nodo actual = frente;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    longitud++;
    }

    public void desencolar () {
        if (frente == null) {
            return;
        } else {
            frente = frente.getSiguiente();
            longitud--;
        }
    }

    public Nodo recuperar () {
        return frente;
    }
}
