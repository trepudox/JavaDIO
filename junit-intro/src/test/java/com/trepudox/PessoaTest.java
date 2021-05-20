package com.trepudox;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PessoaTest {

    private Pessoa pessoa;

    private static List<String> listaCelularesValidos() {
        return List.of("11970155984", "11918256570", "11946723520");
    }

    private static List<String> listaCelularesInvalidos() {
        return List.of("00000000000", "a1934567891", "11 97015-5984", "970155984", "1345602840", "1591234567");
    }

    private static List<String> listaNomesValidos() {
        return List.of("Marco", "ed", "ED");
    }

    private static List<String> listaNomesInvalidos() {
        return List.of("", "a", "A");
    }

    private static List<Integer> listaIdadesValidas() {
        return List.of(0, 50, 149);
    }

    private static List<Integer> listaIdadesInvalidas() {
        return List.of(-1, 150, 500);
    }

    @BeforeAll
    private void inicio() {
        System.out.println("Iniciando testes\n");
    }

    @AfterAll
    private void fim() {
        System.out.println("\nEncerrando testes");
    }

    @BeforeEach
    private void setup() {
        pessoa = new Pessoa();
    }

    @DisplayName("numCelular invalidos")
    @ParameterizedTest
    @MethodSource("listaCelularesInvalidos")
    void testNumerosInvalidos(String numCelular) {
        assertThrows(IllegalArgumentException.class, () -> pessoa.setNumCelular(numCelular));
    }

    @DisplayName("numCelular validos")
    @ParameterizedTest
    @MethodSource("listaCelularesValidos")
    void testNumerosValidos(String numCelular) {
        assertDoesNotThrow(() -> pessoa.setNumCelular(numCelular));
    }

    @DisplayName("nomes validos")
    @ParameterizedTest
    @MethodSource("listaNomesValidos")
    void testNomesValidos(String nome) {
        assertAll("Deve salvar os nomes, sem lançar exceções",
                () -> assertDoesNotThrow(() -> pessoa.setPrimeiroNome(nome)),
                () -> assertDoesNotThrow(() -> pessoa.setSegundoNome(nome)));
    }

    @DisplayName("nomes invalidos")
    @ParameterizedTest
    @MethodSource("listaNomesInvalidos")
    void testNomesInvalidos(String nome) {
        assertAll("Deve lançar IllegalArgumentException, já que os nomes não podem ser salvos",
                () -> assertThrows(IllegalArgumentException.class, () -> pessoa.setPrimeiroNome(nome)),
                () -> assertThrows(IllegalArgumentException.class, () -> pessoa.setSegundoNome(nome)));
    }

    @DisplayName("idades validas")
    @ParameterizedTest
    @MethodSource("listaIdadesValidas")
    void testIdadesValidas(Integer idade) {
        assertDoesNotThrow(() -> pessoa.setIdade(idade));
    }

    @DisplayName("idades invalidas")
    @ParameterizedTest
    @MethodSource("listaIdadesInvalidas")
    void testIdadesInvalidas(Integer idade) {
        assertThrows(IllegalArgumentException.class, () -> pessoa.setIdade(idade));
    }

}
