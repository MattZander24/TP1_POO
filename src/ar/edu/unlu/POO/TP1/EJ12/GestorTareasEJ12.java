package ar.edu.unlu.POO.TP1.EJ12;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestorTareasEJ12 {
    public static void testEjercicio12() {

        // Crear las tareas
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaManana = LocalDate.now().plusDays(1);
        LocalDate fechaAyer = LocalDate.now().minusDays(1);
        LocalDate fechaPasadoManana = LocalDate.now().plusDays(2);
        LocalDate fechaAnteayer = LocalDate.now().minusDays(2);

        ToDoList listaPrueba = new ToDoList();

        listaPrueba.agregarTarea("Ir al supermercado mañana", 1, fechaManana, fechaHoy);
        listaPrueba.agregarTarea("Consultar repuesto del auto", 2, fechaHoy, fechaAnteayer);
        listaPrueba.agregarTarea("Ir al cine a ver la nueva película de Marvel", 3, fechaAyer, fechaAnteayer);
        listaPrueba.agregarTarea("Actualizar el folio teorico", 4, fechaPasadoManana, fechaManana);

        listaPrueba.agregarTareaTeclado();

        // Configurar los estados de las tareas
        GestionarVencimiento(listaPrueba);
        listaPrueba.MarcarComoRealizada("Ir al supermercado mañana");
        listaPrueba.MarcarComoRealizada("Consultar repuesto del auto");

        ArrayList<Tarea> listaAMostrar = listaPrueba.mostrarTareasPendientes();

        System.out.println("\n-------------------------------------------------------");
        System.out.println("Tareas Pendientes:");
        System.out.println("-------------------------------------------------------");
        for (Tarea tarea : listaAMostrar) {
            System.out.println(tarea.mostrarTarea());
            System.out.println("-------------------------------------------------------");
        }
    }

    public static void GestionarVencimiento (ToDoList lista) {
        //controlamos que las fechas no esten vencidas o por vencer. Si lo están actualizamos su estado
        for (Tarea tarea : lista.mostrarTareasPendientes()) {
            tarea.VerificarEstado();
        }
    }
}
