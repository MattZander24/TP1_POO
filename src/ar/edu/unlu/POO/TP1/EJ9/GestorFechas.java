package ar.edu.unlu.POO.TP1.EJ9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GestorFechas {

    public static void testEjercicio9 () {

        DateTimeFormatter DD_MM_YYYY = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter MM_DD_YYYY = DateTimeFormatter.ofPattern("MM-dd-yyyy");


        Fecha fecha1 = new Fecha();
        Fecha fecha2 = new Fecha();
        Fecha fecha3 = new Fecha();

        fecha1.setFecha("15-08-2023", DD_MM_YYYY);
        fecha2.setFecha("25-08-2023", DD_MM_YYYY);
        fecha3.setFecha("20-08-2023", DD_MM_YYYY);

        System.out.println("Fecha 1: " + fecha1.getFecha());
        System.out.println("Fecha 2: " + fecha2.getFecha());
        System.out.println("Fecha 3: " + fecha3.getFecha());

        System.out.println("Fecha 1 está entre Fecha 2 y Fecha 3: " + fecha1.fechaEstaEntre(fecha2, fecha3));
        System.out.println("Fecha 2 es mayor que Fecha 3: " + fecha2.fechaEsMayor(fecha3));
        System.out.println("Fecha 3 es menor que Fecha 1: " + fecha3.fechaEsMenor(fecha1));
    }
}
