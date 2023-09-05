package ar.edu.unlu.POO.TP1.EJ5;

import java.time.LocalDate;

public class Tarea {
    private String descripcion;
    private int prioridad;

    private enum Estado {COMPLETA, INCOMPLETA, VENCIDA;}
    private Estado estado;
    private LocalDate fechaLimite;

    public Tarea(String descripcion, int prioridad, LocalDate fechaLimite) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = Estado.INCOMPLETA;
        this.fechaLimite = fechaLimite;
    }



}
