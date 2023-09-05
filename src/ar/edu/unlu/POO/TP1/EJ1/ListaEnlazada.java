package ar.edu.unlu.POO.TP1.EJ1;

public class ListaEnlazada {
    private Nodo inicio;
    private int longitud;

    public ListaEnlazada() {
        this.inicio = null;
        this.longitud = 0;
    }

    public boolean esVacia () {
        return longitud == 0;
    }

    public int longitudLista () {
        return longitud;
    }

    public void agregarElemento (int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            Nodo actual = inicio;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        longitud++;
    }

    public void eliminarElemento (int valor) {
        if (inicio == null) {
            return;
        }
        if (inicio.getValor() == valor) {
            inicio = inicio.getSiguiente();
            longitud--;
            return;
        }
        Nodo actual = inicio;
        while (actual.getSiguiente() != null && actual.getSiguiente().getValor() != valor) {
            actual = actual.getSiguiente();
        }
        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            longitud--;
        }
    }

    public Nodo recuperarElemento (int pos) {
        if (pos < 0 || pos >= longitud) {
            return null;
        }
        Nodo actual = inicio;
        for (int i = 0; i < pos; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public void insertarElemento (int pos,int valor) {
        if (pos < 0 || pos > longitud) {
            return;
        }
        Nodo nuevoNodo = new Nodo(valor);
        if (pos == 0) {
            nuevoNodo.setSiguiente(inicio);
            inicio = nuevoNodo;
        } else {
            Nodo actual = inicio;
            for (int i = 0; i < pos - 1; i++) {
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }
        longitud++;
    }
}
