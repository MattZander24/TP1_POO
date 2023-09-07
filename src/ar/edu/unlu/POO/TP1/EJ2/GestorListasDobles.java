package ar.edu.unlu.POO.TP1.EJ2;

import ar.edu.unlu.POO.TP1.EJ1.ListaEnlazada;

public class GestorListasDobles {
    public static void testEjercicio2 () {

        ListaDoblementeEnlazada l = new ListaDoblementeEnlazada();
        if (l.esVacia()) System.out.println("La lista esta vacia");
        else System.out.println("La lista no esta vacia");
        l.agregarElemento(4);
        l.agregarElemento(8);
        l.agregarElemento(5);
        if (l.esVacia()) System.out.println("La lista esta vacia");
        else System.out.println("La lista no esta vacia");

        l.insertarElemento(0,9);
        l.eliminarElemento(5);

        System.out.println("Se muestra la lista:");
        for (int i = 0; i < l.longitudLista(); i++) {
            System.out.println(l.recuperarElemento(i).getValor() + " - ");
        }
    }
}
