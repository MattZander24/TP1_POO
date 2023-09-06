package ar.edu.unlu.POO.TP1.EJ13;

import java.time.LocalDate;

public class Tarea {

    private String descripcion;
    private int prioridad;
    public enum Estado {COMPLETA, INCOMPLETA, VENCIDA, POR_VENCER;}
    private Estado estado;
    private LocalDate fechaLimite;
    private LocalDate fechaRecordatorio;
    private LocalDate fechaFinalizacion;
    private Persona colaborador;

    public Tarea(String descripcion, int prioridad, LocalDate fechaLimite, LocalDate fechaRecordatorio) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = Estado.INCOMPLETA;
        this.fechaLimite = fechaLimite;
        this.fechaRecordatorio = fechaRecordatorio;
    }

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

    public LocalDate getFechaRecordatorio() {
        return fechaRecordatorio;
    }

    public void setFechaRecordatorio(LocalDate fechaRecordatorio) {
        this.fechaRecordatorio = fechaRecordatorio;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void modificarDescripcion(String nuevaDescripcion) {
        this.setDescripcion(nuevaDescripcion);
    }
    public void cambiarPrioridad(int nuevaPrioridad) {
        this.setPrioridad(nuevaPrioridad);
    }
    public void marcarComoCompletada(Persona colaborador) {
        this.setEstado(Estado.COMPLETA);

        this.fechaFinalizacion = LocalDate.now();
        this.colaborador = colaborador;
    }
    public String mostrarTarea() {
        if (estaPorVencer()) {
            return "\t+ (Por vencer) " + descripcion;
        } else if (estaVencida()) {
            return "\t+ (Vencida) " + descripcion;
        } else {
            return "\t+ " + descripcion;
        }
    }
    public boolean estaVencida(){
        return estado == Estado.VENCIDA;
    }
    public boolean estaPorVencer(){
        return estado == Estado.POR_VENCER;
    }
    public boolean estaCompleta() {
        return estado == Estado.COMPLETA;
    }

    public void VerificarEstado () {
        if (!this.estaCompleta()) {
            if (this.getFechaRecordatorio() != null) {
                if (this.getFechaRecordatorio().isBefore(LocalDate.now()) || this.getFechaRecordatorio().isEqual(LocalDate.now())) {
                    this.setEstado(Estado.POR_VENCER);
                    this.cambiarPrioridad(10);
                }
            }
            if (this.getFechaLimite().isBefore(LocalDate.now()) && !this.estaCompleta()) {
                this.setEstado(Estado.VENCIDA);
            }
        }
    }
}
