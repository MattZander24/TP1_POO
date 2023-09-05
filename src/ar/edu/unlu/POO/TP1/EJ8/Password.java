package ar.edu.unlu.POO.TP1.EJ8;

import java.util.Random;

public class Password {
    private int longitud;
    private String contraseña;

    public Password() {
        this.longitud = 8; // Longitud por defecto
        generarContraseña();
    }

    public Password(int longitud) {
        this.longitud = longitud;
        generarContraseña();
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int nuevaLongitud) {
        if (nuevaLongitud < 1) {
            throw new IllegalArgumentException("La longitud debe ser al menos 1");
        }
        this.longitud = nuevaLongitud;
        generarContraseña();
    }

    private void generarContraseña() {
        Random rand = new Random();
        StringBuilder builder = new StringBuilder(longitud);

        for (int i = 0; i < longitud; i++) {
            int tipoCaracter = rand.nextInt(3); // 0: mayúscula, 1: minúscula, 2: número
            char caracter;

            if (tipoCaracter == 0) {
                caracter = (char) (rand.nextInt(26) + 'A'); // Mayúscula aleatoria
            } else if (tipoCaracter == 1) {
                caracter = (char) (rand.nextInt(26) + 'a'); // Minúscula aleatoria
            } else {
                caracter = (char) (rand.nextInt(10) + '0'); // Número aleatorio
            }

            builder.append(caracter);
        }

        contraseña = builder.toString();
    }

    public boolean esFuerte() {
        int mayusculas = 0;
        int minusculas = 0;
        int numeros = 0;

        for (char c : contraseña.toCharArray()) {
            if (Character.isUpperCase(c)) {
                mayusculas++;
            } else if (Character.isLowerCase(c)) {
                minusculas++;
            } else if (Character.isDigit(c)) {
                numeros++;
            }
        }

        return mayusculas > 2 && minusculas > 1 && numeros > 1;
    }

    public void arreglarDebil () {
        Random rand = new Random();

        int mayusculas = 0;
        int minusculas = 0;
        int numeros = 0;

        for (char c : contraseña.toCharArray()) {
            if (Character.isUpperCase(c)) {
                mayusculas++;
            } else if (Character.isLowerCase(c)) {
                minusculas++;
            } else if (Character.isDigit(c)) {
                numeros++;
            }
        }


        while (mayusculas <= 2) {
            this.contraseña += (char) (rand.nextInt(26) + 'A');
            mayusculas++;
        }
        while (minusculas <= 1) {
            this.contraseña += (char) (rand.nextInt(26) + 'a');
            minusculas++;
        }
        while (numeros <= 1) {
            this.contraseña += (char) (rand.nextInt(10) + '0');
            numeros++;
        }
    }
}
