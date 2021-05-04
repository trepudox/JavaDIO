package zzz.desafios.ordenacaoEFiltros;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Desafio1 {
    public static void main(String[] args) {
        /* 
        Crie um programa onde você receberá valores inteiros não negativos como entrada.

        Ordene estes valores de acordo com o seguinte critério:

        - Primeiro os Pares
        - Depois os Ímpares

        Você deve exibir os pares em ordem crescente e na sequência os ímpares em ordem decrescente.
        */
        
        Random random = new Random();
        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lista.add(random.nextInt(1000));
        }   
        
        List<Integer> listaFinal = lista.stream().filter(n -> n % 2 == 0).sorted((n1, n2) -> n1 - n2).collect(Collectors.toList());
        listaFinal.addAll(lista.stream().filter(n -> n % 2 == 1).sorted((n1, n2) -> n2 - n1).collect(Collectors.toList()));

        listaFinal.stream().forEach(System.out::println);
    }
}
