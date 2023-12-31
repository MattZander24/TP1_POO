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

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public LocalDate getFechaLimite() {
        return fechaLimite;
    }
    public void setFechaLimite(LocalDate fechaLimite) {
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

    public void VerificarEstado() {
        if (this.getFechaLimite().isBefore(LocalDate.now()) && !this.estaCompleta()){
            this.setEstado(Tarea.Estado.VENCIDA);
        }
    }
}
