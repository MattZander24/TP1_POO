package ar.edu.unlu.POO.TP1.EJ6;

public class GestorBiblioteca {
    public static void testEjercicio6() {
        /*
        Crear una clase que utilice a las anteriores y que cree 2 objetos Libro (los valores que se quieran), mostrarlos por pantalla e indique cuál de los 2 tiene más páginas.
        Intentar prestar un libro con 10 ejemplares y uno con 1 solo ejemplar.
        Mostrar cantidad total hecha de préstamos.
        */

        Biblioteca biblioTest = new Biblioteca();

        Libro libro1 = new Libro("9789873952050", "Moby Dick", new String[]{"Melville Herman"}, 10, 752);
        Libro libro2 = new Libro("9788498382662","Harry Potter y la piedra filosofal", new String[]{"J.K.Rowling"},1,264);

        biblioTest.addLibro(libro1);
        biblioTest.addLibro(libro2);

        System.out.println("Libro 1:\n " + libro1.toString());
        System.out.println("Libro 2:\n " + libro2.toString());

        System.out.println("\n");

        if (libro1.getPaginas() > libro2.getPaginas()) {
            System.out.println("El libro '" + libro1.getNombre() + "' tiene mas paginas que '" + libro2.getNombre() + "'");
        } else if (libro1.getPaginas() == libro2.getPaginas()) {
            System.out.println("El libro '" + libro1.getNombre() + "' tiene las mismas paginas que '" + libro2.getNombre() + "'");
        } else {
            System.out.println("El libro '" + libro2.getNombre() + "' tiene mas paginas que '" + libro1.getNombre() + "'");
        }

        libro1.prestarEjemplar();
        libro2.prestarEjemplar();

        System.out.println("\n");

        System.out.println("\nEn esta biblioteca se han hecho " + biblioTest.countPrestados() + " prestamos en total");

    }
}
