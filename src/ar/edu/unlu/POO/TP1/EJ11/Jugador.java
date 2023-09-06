package ar.edu.unlu.POO.TP1.EJ11;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<String> palabrasValidas = new ArrayList<String>();
    private Diccionario diccionarioAsociado;
    private int puntaje = 0;

    public Jugador(Diccionario diccionario) {
        this.diccionarioAsociado = diccionario;
    }

    public void agregarPalabra(String palabra) {
        palabrasValidas.add(palabra);
        calcularPuntaje(palabra);
    }

    private void calcularPuntaje(String palabra) {
        int longitud = palabra.length();
        int puntajePalabra = longitud;

        for (char letra : palabra.toCharArray()) {
            if ("kzxwq".contains(String.valueOf(letra))) {
                puntajePalabra++;
            }
        }

        if (diccionarioAsociado.esPalabraValida(palabra)) {
            puntaje += puntajePalabra;
        }
        else {
            System.out.println(palabra + " no encontrada en el diccionario.");
        }
    }

    public int getPuntaje() {
        return puntaje;
    }
}
