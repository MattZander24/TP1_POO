package ar.edu.unlu.POO.TP1.EJ5;

import java.time.LocalDate;
public class GestorTareas {
    public static void testEjercicio5() {
        // Crear las tareas
        LocalDate fechaManana = LocalDate.now().plusDays(1);
        LocalDate fechaAyer = LocalDate.now().minusDays(1);

        Tarea[] toDoList = new Tarea[3];

        toDoList[0] = new Tarea("Ir al supermercado mañana", 0, fechaManana);
        toDoList[1] = new Tarea("Consultar repuesto del auto", 0, fechaAyer);
        toDoList[2] = new Tarea("Ir al cine a ver la nueva película de Marvel", 0, fechaAyer);

        // Configurar los estados de las tareas
        toDoList[1].marcarComoCompletada();

        GestionarVencimiento(toDoList);

        for (int i = 0; i < toDoList.length; i++) {
            // Mostrar los estados de las tareas
            System.out.println("Tarea " + i +": " + toDoList[i].mostrarTarea());
            if (toDoList[i].estaCompleta()) {
                System.out.println("La Tarea " + i +" está COMPLETA\n");
            } else {
                System.out.println("La Tarea " + i +" está INCOMPLETA\n");
            }
        }
    }

    public static void GestionarVencimiento (Tarea[] toDoList) {
        //controlamos que las fechas no esten vencidas y si lo estan las actualizamos
        for (int i = 0; i < toDoList.length; i++) {
            if (toDoList[i].getFechaLimite().isBefore(LocalDate.now()) && !toDoList[i].estaCompleta()){
                toDoList[i].setEstado(Tarea.Estado.VENCIDA);
            }
        }
    }
}
