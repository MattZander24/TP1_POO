package ar.edu.unlu.POO.TP1.EJ1;

public class GestorListasSimples {
    public static void testEjercicio1 () {

        ListaEnlazada l = new ListaEnlazada();
        if (l.esVacia()) System.out.println("La lista esta vacia");
        else System.out.println("La lista no esta vacia");
        l.agregarElemento(3);
        l.agregarElemento(7);
        l.agregarElemento(4);
        if (l.esVacia()) System.out.println("La lista esta vacia");
        else System.out.println("La lista no esta vacia");

        l.insertarElemento(0,8);
        l.eliminarElemento(4);

        System.out.println("Se muestra la lista:");
        for (int i = 0; i < l.longitudLista(); i++) {
            System.out.println(l.recuperarElemento(i).getValor() + " - ");
        }
    }
}
