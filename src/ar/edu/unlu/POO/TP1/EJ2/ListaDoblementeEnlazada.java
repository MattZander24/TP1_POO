package ar.edu.unlu.POO.TP1.EJ2;

public class ListaDoblementeEnlazada {
    private NodoDoble inicio;
    private int longitud;

    public ListaDoblementeEnlazada() {
        this.inicio = null;
        this.longitud = 0;
    }

    public boolean estaVacia() {
        return longitud == 0;
    }

    public int obtenerLongitud() {
        return longitud;
    }

    public void agregarElemento (int valor) {
        NodoDoble nuevoNodo = new NodoDoble(valor);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            NodoDoble actual = inicio;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(actual);
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
        NodoDoble actual = inicio;
        while (actual.getSiguiente() != null && actual.getSiguiente().getValor() != valor) {
            actual = actual.getSiguiente();
        }
        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            actual.getSiguiente().setAnterior(actual.getAnterior());
            longitud--;
        }
    }

    public NodoDoble recuperarElemento (int pos) {
        if (pos < 0 || pos >= longitud) {
            return null;
        }
        NodoDoble actual = inicio;
        for (int i = 0; i < pos; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public void insertarElemento (int pos,int valor) {
        if (pos < 0 || pos > longitud) {
            return;
        }
        NodoDoble nuevoNodo = new NodoDoble(valor);
        if (pos == 0) {
            nuevoNodo.setSiguiente(inicio);
            inicio = nuevoNodo;
        } else {
            NodoDoble actual = inicio;
            for (int i = 0; i < pos - 1; i++) {
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(actual);
            if (actual.getSiguiente() != null) {
                actual.getSiguiente().setAnterior(nuevoNodo);
            }
        }
        longitud++;
    }

}
