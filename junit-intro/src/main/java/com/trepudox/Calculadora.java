package com.trepudox;

import java.util.Arrays;

public class Calculadora {

    public static int soma(int... valores) {
        return Arrays.stream(valores).reduce(0, (res, e) -> res + e);
    }

    public static double divisao(double n1, double n2) {
        if (n2 == 0)
            throw new IllegalArgumentException("Não é possível fazer uma divisão por 0!");

        return n1 / n2;
    }

    public static void metodoDemorado() throws InterruptedException {
        Thread.sleep(5000);
        return;
    }

}
