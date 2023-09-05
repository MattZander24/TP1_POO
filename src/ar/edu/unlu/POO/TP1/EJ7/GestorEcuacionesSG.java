package ar.edu.unlu.POO.TP1.EJ7;

public class GestorEcuacionesSG {
    public static void testEjercicio7() {
        EcuacionSegundoGrado ecuacion1 = new EcuacionSegundoGrado(1, -3, 2);
        EcuacionSegundoGrado ecuacion2 = new EcuacionSegundoGrado(1, -2, 1);
        EcuacionSegundoGrado ecuacion3 = new EcuacionSegundoGrado(1, 2, 1);

        // Calcular y mostrar las raíces de las ecuaciones
        double[] raices1 = ecuacion1.calcularRaices();
        double[] raices2 = ecuacion2.calcularRaices();
        double[] raices3 = ecuacion3.calcularRaices();

        // Calcular y mostrar el valor de y en base al valor de x
        double x = 2.0;
        double y1 = ecuacion1.calcularValorY(x);
        double y2 = ecuacion2.calcularValorY(x);
        double y3 = ecuacion3.calcularValorY(x);

        System.out.println("Ecuación 1:");
        mostrarRaices(raices1);
        System.out.println("Para x = " + x + ": y = " + y1);


        System.out.println("Ecuación 2:");
        mostrarRaices(raices2);
        System.out.println("Para x = " + x + ": y = " + y2);

        System.out.println("Ecuación 3:");
        mostrarRaices(raices3);
        System.out.println("Para x = " + x + ": y = " + y3);
    }

    private static void mostrarRaices(double[] raices) {
        if (raices.length == 0) {
            System.out.println("No hay raíces reales.");
        } else {
            System.out.println("Raíces:");
            for (double raiz : raices) {
                System.out.println(raiz);
            }
        }
    }
}
