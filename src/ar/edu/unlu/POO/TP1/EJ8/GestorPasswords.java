package ar.edu.unlu.POO.TP1.EJ8;

import java.util.Scanner;

public class GestorPasswords {

    public static void testEjercicio8 () {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de contraseñas a generar: ");
        int cantidad = scanner.nextInt();

        Password[] contraseñas = new Password[cantidad];

        for (int i = 0; i < cantidad; i++) {
            int longitud = 1;
            Password password = null;
            do {
                System.out.print("Ingrese la longitud de la contraseña n°" + (i+1));
                System.out.println("  (si desea usar la longitud estandar ingrese 0) :");
                longitud = scanner.nextInt();

                if (longitud == 0) {
                    password = new Password();
                } else if (longitud > 0) {
                    password = new Password(longitud);
                } else {
                    System.out.println("La longitud de la contraseña debe ser un numero mayor a 0");
                }
            } while (longitud < 0);

            contraseñas[i] = password;
        }

        System.out.println("Contraseñas generadas:");

        //ARREGLAR
        for (Password password : contraseñas) {
            String fuerza;
            if (password.esFuerte()) {
                fuerza = "Fuerte";
            } else {
                fuerza = "Débil";
            }
            System.out.println(password.getContraseña() + " - " + fuerza);

            if (fuerza == "Débil") {
                System.out.print("Ingrese 1 si desea mejorar esta contraseña haciendola FUERTE: ");
                int opcion = scanner.nextInt();
                if (opcion == 1) {
                    password.arreglarDebil();
                    System.out.println("Contraseña actualizada a: " + password.getContraseña());
                }
            }
        }
        scanner.close();
    }
}
