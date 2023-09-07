package ar.edu.unlu.POO.TP1.EJ3;

import ar.edu.unlu.POO.TP1.EJ1.Nodo;

public class GestorPilas {
    public static void testEjercicio3() {

        Pila p = new Pila();
        if (p.esVacia()) System.out.println("La pila esta vacia");
        else System.out.println("La pila no esta vacia");
        p.apilar(3);
        p.apilar(4);
        p.apilar(5);
        p.apilar(1);
        p.apilar(7);
        p.apilar(9);
        if (p.esVacia()) System.out.println("La pila esta vacia");
        else System.out.println("La pila no esta vacia");
        p.desapilar();
        p.desapilar();

        System.out.println("Se muestra la pila:");
        Pila pAux = new Pila();
        int repeticiones = p.longitudPila();
        for (int i = 0; i < repeticiones; i++) {
            System.out.println(p.recuperar().getValor() + " - ");
            Nodo n = p.recuperar();
            pAux.apilar(n.getValor());
            p.desapilar();
        }
        intercambiar(p, pAux);
    }
    public static void intercambiar(Pila pilaOriginal, Pila pilaAux){
        while (!pilaAux.esVacia()){
            Nodo n = pilaAux.recuperar();
            pilaAux.desapilar();
            pilaOriginal.apilar(n.getValor());
        }
    }
}
