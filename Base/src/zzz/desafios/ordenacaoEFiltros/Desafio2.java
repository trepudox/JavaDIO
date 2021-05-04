package zzz.desafios.ordenacaoEFiltros;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Desafio2 {
    /*

    Pedro trabalha sempre até tarde todos os dias, com isso tem pouco tempo tempo para as tarefas domésticas.
    Para economizar tempo ele faz a lista de compras do supermercado em um aplicativo e costuma anotar cada
    item na mesma hora que percebe a falta dele em casa.

    O problema é que o aplicativo não exclui itens duplicados, como Pedro anota o mesmo item mais de uma vez
    e a lista acaba ficando extensa. Sua tarefa é melhorar o aplicativo de notas desenvolvendo um código que
    exclua os itens duplicados da lista de compras e que os ordene alfabeticamente.

     */

    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();



        lista.addAll(Arrays.asList("carne", "laranja", "suco", "picles", "laranja", "picles",
                        "laranja", "pera", "laranja", "pera", "pera"));

        System.out.println(lista.stream().distinct().sorted(Collator.getInstance()).collect(Collectors.toList()));
    }
}
