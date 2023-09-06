package ar.edu.unlu.POO.TP1.EJ11;

public class Juego {
    public static void testEjercicio11() {

        Diccionario diccionario = new Diccionario();
        diccionario.agregarPalabra("hola");
        diccionario.agregarPalabra("mundo");
        diccionario.agregarPalabra("zorro");
        diccionario.agregarPalabra("ratón");

        Jugador jugador1 = new Jugador(diccionario);
        Jugador jugador2 = new Jugador(diccionario);

        System.out.println("\n");

        jugador1.agregarPalabra("hola");
        jugador1.agregarPalabra("zorro");
        jugador2.agregarPalabra("perro");
        jugador2.agregarPalabra("ratón");

        int puntajeJugador1 = jugador1.getPuntaje();
        int puntajeJugador2 = jugador2.getPuntaje();

        System.out.println("\n");

        if (puntajeJugador1 > puntajeJugador2) {
            System.out.println("Jugador 1 es el ganador con un puntaje de " + puntajeJugador1);
        } else if (puntajeJugador2 > puntajeJugador1) {
            System.out.println("Jugador 2 es el ganador con un puntaje de " + puntajeJugador2);
        } else {
            System.out.println("¡Empate! Ambos jugadores tienen un puntaje de " + puntajeJugador1);
        }
    }
}
