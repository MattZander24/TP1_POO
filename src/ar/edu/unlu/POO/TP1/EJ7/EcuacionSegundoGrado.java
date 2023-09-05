package ar.edu.unlu.POO.TP1.EJ7;

public class EcuacionSegundoGrado {
    private final double a;
    private final double b;
    private final double c;

    public EcuacionSegundoGrado(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calcularDiscriminante() {
        return (b * b) - (4 * a * c);
    }

    public double[] calcularRaices() {
        double discriminante = calcularDiscriminante();

        if (discriminante > 0) {
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            return new double[]{raiz1, raiz2};
        } else if (discriminante == 0) {
            double raizUnica = -b / (2 * a);
            return new double[]{raizUnica};
        } else {
            return new double[0]; // No hay raíces reales
        }
    }

    public double calcularValorY(double x) {
        return a * x * x + b * x + c;
    }
}
