package ar.edu.unlu.POO.TP1.EJ13;

public class Persona {
    private int id;
    private static int idActual = 0;
    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido) {
        this.id = idActual;
        idActual++;
        this.nombre = nombre;
        this.apellido = apellido;
    }

public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
