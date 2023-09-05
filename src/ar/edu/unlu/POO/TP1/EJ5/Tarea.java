package ar.edu.unlu.POO.TP1.EJ5;

import java.time.LocalDate;

public class Tarea {

    private String descripcion;
    private int prioridad;
    public enum Estado {COMPLETA, INCOMPLETA, VENCIDA;}
    private Estado estado;
    private LocalDate fechaLimite;

    public Tarea(String descripcion, int prioridad, LocalDate fechaLimite) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = Estado.INCOMPLETA;
        this.fechaLimite = fechaLimite;
    }

    private String getDescripcion() {
        return descripcion;
    }
    private void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    private int getPrioridad() {
        return prioridad;
    }
    private void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    private Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public LocalDate getFechaLimite() {
        return fechaLimite;
    }
    private void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void modificarDescripcion(String nuevaDescripcion) {
        setDescripcion(nuevaDescripcion);
    }
    public void cambiarPrioridad(int nuevaPrioridad) {
        setPrioridad(nuevaPrioridad);
    }
    public void marcarComoCompletada() {
        setEstado(Estado.COMPLETA);
    }
    public String mostrarTarea() {
        if (estaVencida()) {
            return "(Vencida) " + descripcion;
        } else {
            return descripcion;
        }
    }
    public boolean estaVencida(){
        return estado == Estado.VENCIDA;
    }
    public boolean estaCompleta() {
        return estado == Estado.COMPLETA;
    }
}
