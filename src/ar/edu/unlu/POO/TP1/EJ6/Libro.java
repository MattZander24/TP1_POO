package ar.edu.unlu.POO.TP1.EJ6;

public class Libro {
    private String nombre;
    private String[] autores = new String[5];
    private String isbn;
    private int cantidadPaginas;
    private int cantidadEjemplares;
    private int cantidadPrestados;

    public Libro(String isbn, String nombre, String[] listaDeAutores, int cantidadEjemplaresIniciales, int cantidadPaginas) {
        this.nombre = nombre;
        this.isbn = isbn;
        this.cantidadEjemplares = cantidadEjemplaresIniciales;
        this.cantidadPaginas = cantidadPaginas;
        this.cantidadPrestados = 0;

        if (listaDeAutores == null) {
            for (int x = 0; x < autores.length; x++){
                autores[x] = new String("");
            }
        } else {
            for (String autor : autores) {
                this.setAutor(autor);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getAutores() {
        return autores;
    }

    public boolean setAutor(String autor) {
        // Buscamos el primer autor vacio y lo ponemos allí
        int x = 0;
        while (x < autores.length && autores[x] != null) {
            x ++;
        }
        if (x < autores.length) {
            autores[x] = autor;
            return true;
        } else {
            return false;
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPaginas() {
        return cantidadPaginas;
    }

    public void setPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(Integer cantidadEjemplares) {
        if (cantidadEjemplares > cantidadPrestados)
            this.cantidadEjemplares = cantidadEjemplares;

    }

    public int getCantidadPrestados() {
        return cantidadPrestados;
    }

    //------------------------------------------------------------------------------------------------------------------

    public boolean esAutor(String autor){
        return (buscarAutor(autor) > -1);
    }

    public int buscarAutor(String autor) {
        int x = 0;
        autor = autor.toLowerCase();
        while (x < autores.length && !contieneIgnoreCase( autor,autores[x]))
            x++;
        if (x < autores.length) {
            return x;
        } else {
            return -1;
        }
    }

    public boolean hallar(String dato){
        return (contieneIgnoreCase(dato,getIsbn()) ||
                contieneIgnoreCase(dato,getNombre()) ||
                esAutor(dato));
    }

    public static boolean contieneIgnoreCase(String cadena1, String cadena2) {
        // Convertir ambas cadenas a minúsculas para hacer la comparación
        String cadena1Lower = cadena1.toLowerCase();
        String cadena2Lower = cadena2.toLowerCase();

        // Verificar si la cadena2 contiene la cadena1 (ignorando mayúsculas y minúsculas)
        return cadena2Lower.contains(cadena1Lower);
    }


    public boolean removeAutor(String autor) {
        // Buscamos el primer el autor y si está lo vaciamos
        int x = this.buscarAutor(autor);
        if (x >= 0) {
            autores[x] = "";
            return true;
        } else {
            return false;
        }
    }

    public boolean prestarEjemplar() {
        if (this.cantidadPrestados + 1 < this.cantidadEjemplares) {
            cantidadPrestados++;
            System.out.println("Se ha prestado un ejemplar de '" + this.nombre +"'");
            return true;
        } else {
            System.out.println("El libro '" + this.nombre + "' no se puede prestar porque es el ultimo ejemplar, el cual debe quedar para consulta dentro de la biblioteca");
            return false;
        }
    }

    public boolean devolverEjemplar() {
        if (this.cantidadPrestados > 0) {
            cantidadPrestados--;
            return true;
        } else
            return false;
    }

    public int getCantidadDisponible() {
        return this.cantidadEjemplares - this.getCantidadPrestados();
    }

    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", autores=" + mostrarAutores() +
                ", isbn='" + isbn + '\'' +
                ", paginas=" + cantidadPaginas +
                ", cantidadEjemplares=" + cantidadEjemplares +
                ", cantidadPrestados=" + cantidadPrestados +
                '}';
    }

    private String mostrarAutores(){
        String respuesta = "";
        for (int x = 0; x < autores.length; x ++) {
            if (autores[x] != null) {
                if (respuesta.length() > 0)
                    respuesta += " - " + autores[x];
                else respuesta += autores[x];
            }
        }
        return respuesta;
    }
}
