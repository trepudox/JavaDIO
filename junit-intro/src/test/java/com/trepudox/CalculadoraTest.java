package com.trepudox;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;

public class CalculadoraTest {

    @Test
    public void testSoma1() {
        Integer valor = Calculadora.soma(1,2,3);
        assertEquals(Integer.valueOf(6), valor);
        // valor = null;
        // assertNotNull(valor);
    }

    @Test
    public void testSoma2() {
        int valor = Calculadora.soma(1,2,99);
        assertEquals(102, valor);
    }

    @Test
    public void testSoma3() {
        int valor = Calculadora.soma(1,2,7);
        assertEquals(10, valor);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisaoPorZero() {


        Calculadora.divisao(1, 0);
    }

    @Test(timeout = 10000)
    public void testTimeout() throws InterruptedException {
        Calculadora.metodoDemorado();

    }
}
