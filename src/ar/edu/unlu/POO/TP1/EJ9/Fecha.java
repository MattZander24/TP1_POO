package ar.edu.unlu.POO.TP1.EJ9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {

    private LocalDate fecha;

    public Fecha() {
    }
    public Fecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(String fechaStr, DateTimeFormatter formato) {
        this.fecha = LocalDate.parse(fechaStr, formato);
    }

    //-
    public boolean fechaEstaEntre(Fecha fechaInicio, Fecha fechaFin) {
        return !this.fecha.isBefore(fechaInicio.getFecha()) && !this.fecha.isAfter(fechaFin.getFecha());
    }

    public boolean fechaEsMayor(Fecha fechaMen) {
        return this.fecha.isAfter(fechaMen.getFecha());
    }

    public boolean fechaEsMenor(Fecha fechaMay) {
        return this.fecha.isBefore(fechaMay.getFecha());
    }
}
