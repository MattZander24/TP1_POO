package ar.edu.unlu.POO.TP1.EJ2;

public class NodoDoble {
    private int valor;
    private NodoDoble siguiente;
    private NodoDoble anterior;

    public NodoDoble(int valor) {
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}
