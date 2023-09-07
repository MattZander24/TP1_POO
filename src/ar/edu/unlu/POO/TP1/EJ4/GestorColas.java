package ar.edu.unlu.POO.TP1.EJ4;

import ar.edu.unlu.POO.TP1.EJ1.Nodo;

public class GestorColas {
    public static void testEjercicio4() {

        Cola c = new Cola();
        if (c.esVacia()) System.out.println("La cola esta vacia");
        else System.out.println("La cola no esta vacia");
        c.encolar(4);
        c.encolar(5);
        c.encolar(6);
        c.encolar(2);
        c.encolar(7);
        c.encolar(10);
        if (c.esVacia()) System.out.println("La cola esta vacia");
        else System.out.println("La cola no esta vacia");
        c.desencolar();
        c.desencolar();

        System.out.println("Se muestra la cola:");
        int repeticiones = c.longitudCola();
        for (int i = 0; i < repeticiones; i++) {
            System.out.println(c.recuperar().getValor() + " - ");
            Nodo n = c.recuperar();
            c.encolar(n.getValor());
            c.desencolar();
        }
    }
}
