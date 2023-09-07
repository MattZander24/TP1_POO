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

        int opcion = 1;
        while (opcion != 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n-------------------------------------------------------");
            System.out.println("\n\tToDoList");
            System.out.println("\n-------------------------------------------------------");
            System.out.println("\nSelecicone la accion a ejecutar:");
            System.out.println("1- Agregar una tarea a la lista");
            System.out.println("2- Marcar una tarea como realizada");
            System.out.println("3- Agregar un colaborador a la lista");
            System.out.println("4- Ver lista de tareas pendientes");
            System.out.println("5- Ver lista de tareas realizadas por un colaborador");
            System.out.println("0- Salir");

            System.out.print("Ingrese el número de la opción deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listaPrueba.agregarTareaTeclado();
                    GestionarVencimiento(listaPrueba);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la tarea que quiere completar: ");
                    scanner.nextLine();
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese el nombre del colaborador que la completó: ");
                    String colaborador = scanner.nextLine();
                    listaPrueba.MarcarComoRealizada(descripcion, colaborador);
                    break;
                case 3:
                    listaPrueba.agregarColaborador();
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
                    ArrayList<Tarea> listaAMostrarPorPersona;
                    System.out.print("Ingrese el nombre del colaborador del que quiere ver sus tareas completadas: ");
                    scanner.nextLine();
                    String colabLista = scanner.nextLine();
                    listaAMostrarPorPersona = listaPrueba.mostrarTareasPorPersona(colabLista);

                    if (listaAMostrarPorPersona != null) {

                        System.out.println("\n-------------------------------------------------------");
                        System.out.println("Tareas Completas por " + colabLista + ":");
                        System.out.println("-------------------------------------------------------");
                        for (Tarea tarea : listaAMostrarPorPersona) {
                            System.out.println(tarea.mostrarTarea());
                            System.out.println("-------------------------------------------------------");
                        }
                        break;
                    }
                    else {
                        System.out.println("Asegurese de haber creado alguna persona antes. Pulse enter para volver");
                        break;
                    }
                case 0:
                    break;
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
