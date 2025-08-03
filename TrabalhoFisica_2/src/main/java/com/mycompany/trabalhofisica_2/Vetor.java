package com.mycompany.trabalhofisica_2;

/**
 *
 * @author gab-linux
 */
public class Vetor {
    double x, y;

    public Vetor(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vetor somar(Vetor outro) {
        return new Vetor(this.x + outro.x, this.y + outro.y);
    }

    public double modulo() {
        return Math.sqrt(x * x + y * y);
    }

    public double anguloEmGraus() {
        return Math.toDegrees(Math.atan2(y, x));
    }
}
