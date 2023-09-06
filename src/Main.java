import ar.edu.unlu.POO.TP1.EJ12.GestorTareasEJ12;
import ar.edu.unlu.POO.TP1.EJ13.GestorTareasEJ13;
import ar.edu.unlu.POO.TP1.EJ5.GestorTareas;
import ar.edu.unlu.POO.TP1.EJ6.GestorBiblioteca;
import ar.edu.unlu.POO.TP1.EJ7.GestorEcuacionesSG;
import ar.edu.unlu.POO.TP1.EJ8.GestorPasswords;
import ar.edu.unlu.POO.TP1.EJ9.GestorFechas;
import ar.edu.unlu.POO.TP1.EJ10.GestorTareasEJ10;
import ar.edu.unlu.POO.TP1.EJ11.Juego;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Trabajo practico N°1");
            System.out.println("Programacion Orientada a Objetos");
            System.out.println("\nSelecicone el ejercicio quiera probar:");
            System.out.println("1- Ejercicio 1");
            System.out.println("2- Ejercicio 2");
            System.out.println("3- Ejercicio 3");
            System.out.println("4- Ejercicio 4");
            System.out.println("5- Ejercicio 5");
            System.out.println("6- Ejercicio 6");
            System.out.println("7- Ejercicio 7");
            System.out.println("8- Ejercicio 8");
            System.out.println("9- Ejercicio 9");
            System.out.println("10- Ejercicio 10");
            System.out.println("11- Ejercicio 11");
            System.out.println("12- Ejercicio 12");
            System.out.println("13- Ejercicio 13");
            System.out.println("0- Salir");

            System.out.print("Ingrese el número de la opción deseada: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ejercicio 1...");
                    break;
                case 2:
                    System.out.println("Ejercicio 2...");
                    break;
                case 3:
                    System.out.println("Ejercicio 3...");
                    break;
                case 4:
                    System.out.println("Ejercicio 4...");
                    break;
                case 5:
                    System.out.println("Ejercicio 5...");
                    GestorTareas.testEjercicio5();
                    PulseEnter();
                    break;
                case 6:
                    System.out.println("Ejercicio 6...");
                    GestorBiblioteca.testEjercicio6();
                    PulseEnter();
                    break;
                case 7:
                    System.out.println("Ejercicio 7...");
                    GestorEcuacionesSG.testEjercicio7();
                    PulseEnter();
                    break;
                case 8:
                    System.out.println("Ejercicio 8...");
                    GestorPasswords.testEjercicio8();
                    PulseEnter();
                    break;
                case 9:
                    System.out.println("Ejercicio 9...");
                    GestorFechas.testEjercicio9();
                    PulseEnter();
                    break;
                case 10:
                    System.out.println("Ejercicio 10...");
                    GestorTareasEJ10.testEjercicio10();
                    PulseEnter();
                    break;
                case 11:
                    System.out.println("Ejercicio 11...");
                    Juego.testEjercicio11();
                    PulseEnter();
                    break;
                case 12:
                    System.out.println("Ejercicio 12...");
                    GestorTareasEJ12.testEjercicio12();
                    PulseEnter();
                    break;
                case 13:
                    System.out.println("Ejercicio 13...");;
                    GestorTareasEJ13.testEjercicio13();
                    PulseEnter();
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Ingrese un número válido.");
                    break;
            }
        }
    }

    public static void PulseEnter () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pulse ENTER para continuar");
        scanner.nextLine();
        System.out.println("Volviendo al menu...\n");
        scanner.close();
    }
}