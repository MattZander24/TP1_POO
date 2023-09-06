package ar.edu.unlu.POO.TP1.EJ13;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorTareasEJ13 {
    public static void testEjercicio13() {

        // Crear las tareas
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaManana = LocalDate.now().plusDays(1);
        LocalDate fechaAyer = LocalDate.now().minusDays(1);
        LocalDate fechaPasadoManana = LocalDate.now().plusDays(2);
        LocalDate fechaAnteayer = LocalDate.now().minusDays(2);

        ToDoList listaPrueba = new ToDoList();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("ToDoList");
            System.out.println("\nSelecicone la accion a ejecutar:");
            System.out.println("1- Agregar una tarea a la lista");
            System.out.println("2- Marcar una tarea como realizada");
            System.out.println("3- Agregar un colaborador a la lista");
            System.out.println("4- Ver lista de tareas pendientes");
            System.out.println("5- Ver lista de tareas realizadas por un colaborador");
            System.out.println("0- Salir");

            System.out.print("Ingrese el número de la opción deseada: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listaPrueba.agregarTareaTeclado();
                    GestionarVencimiento(listaPrueba);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la tarea que quiere completar: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese el nombre del colaborador que la completó: ");
                    String colaborador = scanner.nextLine();
                    listaPrueba.MarcarComoRealizada(descripcion, colaborador);

                    break;
                case 3:
                    System.out.println("Ejercicio 1...");
                    break;
                case 4:
                    ArrayList<Tarea> listaAMostrar = listaPrueba.mostrarTareasPendientes();

                    System.out.println("\n-------------------------------------------------------");
                    System.out.println("Tareas Pendientes:");
                    System.out.println("-------------------------------------------------------");
                    for (Tarea tarea : listaAMostrar) {
                        System.out.println(tarea.mostrarTarea());
                        System.out.println("-------------------------------------------------------");
                    }
                    break;
                case 5:
                    System.out.println("Ejercicio 1...");
                    break;
                case 0:
                    scanner.close();
                default:
                    System.out.println("Opción no válida. Ingrese un número válido.");
                    break;
            }
        }
    }

    public static void GestionarVencimiento (ToDoList lista) {
        //controlamos que las fechas no esten vencidas o por vencer. Si lo están actualizamos su estado
        for (Tarea tarea : lista.mostrarTareasPendientes()) {
            tarea.VerificarEstado();
        }
    }
}
