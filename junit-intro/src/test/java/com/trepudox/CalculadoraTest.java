package com.trepudox;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Random;

class CalculadoraTest {

    private final Random random = new Random();

    @Test
    void testSoma() {
        // os Assumes testam uma condição, caso ela não atenda os requisitos, o teste é ignorado
        assumeTrue(true, "testSoma ignorado");

        int resultado = Calculadora.soma(1,2,3);

        assertEquals(6, resultado);
    }

    @RepeatedTest(value = 10, name = "Teste {currentRepetition} de {totalRepetitions}")
    void testSoma10Vezes() {
        int n1 = random.nextInt();
        int n2 = random.nextInt();
        int esperado = n1 + n2;

        int resultado = Calculadora.soma(n1, n2);

        assertEquals(esperado, resultado);
    }

    @Test
    void testDivisaoPorZero() {
        assertThrows(IllegalArgumentException.class, () -> Calculadora.divisao(1, 0));
    }

    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(5000), Calculadora::metodoDemorado);
    }

}
