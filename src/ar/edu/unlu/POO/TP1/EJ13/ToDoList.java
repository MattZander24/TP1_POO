package ar.edu.unlu.POO.TP1.EJ13;

import jdk.jshell.PersistentSnippet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class ToDoList {
    private ArrayList<Tarea> toDoList;
    private ArrayList<Persona> colaboradores;

    private DateTimeFormatter DD_MM_YYYY = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public ToDoList() {
        this.toDoList = new ArrayList<Tarea>();
    }

    public void agregarTareaTeclado() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la descripción de la tarea: ");
        String descripcion = scanner.nextLine();

        int prioridad = -1;
        boolean error = false;
        while (prioridad < 0 || prioridad > 10) {
            if (error) {
                System.out.println("Ud. ha ingresado un dato incorrecto. Ingrese la prioridad de la tarea (un número entero de 0 a 10 donde 10 es la máxima prioridad): ");
            }
            else {
                System.out.print("Ingrese la prioridad de la tarea (un número entero de 0 a 10 donde 10 es la máxima prioridad): ");
            }
            prioridad = scanner.nextInt();
            error = true;
        }
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese la fecha límite de la tarea (DD-MM-YYYY): ");
        String fechaLimiteStr = scanner.nextLine();
        LocalDate fechaLimite = LocalDate.parse(fechaLimiteStr, DD_MM_YYYY);

        System.out.print("Ingrese la fecha de recordatorio de la tarea (DD-MM-YYYY): ");
        String fechaRecordatorioStr = scanner.nextLine();
        LocalDate fechaRecordatorio = LocalDate.parse(fechaRecordatorioStr, DD_MM_YYYY);

        scanner.close();

        Tarea nueva = new Tarea(descripcion, prioridad, fechaLimite, fechaRecordatorio);
        nueva.VerificarEstado();

        this.toDoList.add(nueva);
    }

    public void agregarTarea(String descripcion, int prioridad, LocalDate fechaLimite, LocalDate fechaRecordatorio) {
        Tarea nueva = new Tarea(descripcion, prioridad, fechaLimite, fechaRecordatorio);
        nueva.VerificarEstado();
        this.toDoList.add(nueva);
    }

    public ArrayList<Tarea> mostrarTareasPendientes() {

        ArrayList<Tarea> tareasPendientes = new ArrayList<Tarea>();

        LocalDate fechaActual = LocalDate.now();

        for (Tarea tarea : this.toDoList) {
            if (!tarea.estaCompleta() && !tarea.estaVencida()) {
                tareasPendientes.add(tarea);
            }
        }

        // Ordenar primero por prioridad y luego por fecha de vencimiento
        tareasPendientes.sort(new Comparator<Tarea>() {
            public int compare(Tarea tarea1, Tarea tarea2) {
                int comparacionPrioridad = Integer.compare(tarea2.getPrioridad(), tarea1.getPrioridad());
                if (comparacionPrioridad != 0) {
                    return comparacionPrioridad;
                } else {
                    return tarea1.getFechaLimite().compareTo(tarea2.getFechaLimite());
                }
            }
        });

        return tareasPendientes;
    }

    //Buscar tareas por titulo (ingresar x teclado)
    public Tarea buscarPorNombre(String nombre) {
        for (Tarea tarea : this.toDoList) {
            if (tarea.getDescripcion().equalsIgnoreCase(nombre)) {
                return tarea;
            }
        }
        System.out.println("Tarea no encontrada...");
        return null;
    }

    public Persona buscarColaboradorPorNombre(String nombre) {
        for (Persona persona : this.colaboradores) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return persona;
            }
        }
        System.out.println("Colaborador no encontrado...");
        return null;
    }

    //Marcar tarea como realiada (encontrandola a traves de buscar tareas)
    public void MarcarComoRealizada (String nombre, String colaborador) {
        Tarea t = buscarPorNombre(nombre);
        if (t != null) {
            Persona p = buscarColaboradorPorNombre(colaborador);
            if (p != null) {
                t.marcarComoCompletada(p);
            }
        } else {
            System.out.println("No se pudo marcar como completada dada que la tarea es inexistente");
        }
    }
}
