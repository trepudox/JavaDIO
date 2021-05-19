package zzz.desafios.buscaSubstituicao;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Desafio
Crie um algoritmo para ordenar um conjunto de palavras pelo seu tamanho. Seu programa deve receber um conjunto de palavras e retornar este mesmo conjunto ordenado pelo tamanho das palavras decrescente, se o tamanho das palavras for igual, deve-se ordernar por ordem alfabética.

Entrada
A primeira linha da entrada possui um único inteiro N, que indica o número de casos de teste. Cada caso de teste poderá conter de 1 a 50 palavras inclusive, e cada uma das palavras poderá conter entre 1 e 50 caracteres inclusive. Os caracteres poderão ser espaços, letras, ou números.

Saída
A saída deve conter o conjunto de palavras da entrada ordenado pelo tamanho das palavras e caso o tamanho das palavras for igual, deve-se ordernar por ordem alfabética.. Um espaço em branco deve ser impresso entre duas palavras.
 */

public class Desafio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            List<String> lista = new ArrayList<>();

            String textoRecebido = scanner.nextLine();

            lista.addAll(Arrays.asList(textoRecebido.split(" ")));

            lista.stream().sorted((o1, o2) -> o2.length() - o1.length() == 0 ? Collator.getInstance().compare(o1, o2) :
                    o2.length() - o1.length()).forEach(e -> System.out.print(e + " "));

            System.out.println();
        }

//        lista.stream().sorted((o1, o2) -> o1.length() - o2.length() == 0 ? Collator.getInstance().compare(o1, o2) :
//                o1.length() - o2.length()).forEach(System.out::println);
    }
}
