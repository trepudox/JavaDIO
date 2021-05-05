package zzz.desafios.ordenacaoEFiltros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Desafio4 {
    /*
    O banco que você trabalha sempre tem problemas para organizar as filas de atendimento dos clientes.

    Após uma reunião com a gerência ficou decidido que os clientes ao chegar na agência receberão uma senha numérica em seu aparelho de 
    celular via sms e que a ordem da fila será dada não pela ordem de chegada, mas sim pelo número recebido via sms. A ordem de
    atendimento será decrescente: aqueles que receberam número maior deverão ser atendidos primeiro. 

    Então, dada a ordem de chegada dos clientes reordene a fila de acordo com o número recebido via sms, e diga quantos clientes não 
    precisaram trocar de lugar nessa reordenação

    Para cada caso de teste imprima uma linha, contendo um inteiro, indicando o número de clientes que não precisaram trocar de lugar 
    mesmo após a fila ser reordenada.
    */
    public static void main(String[] args) {
        List<List<Integer>> listaFila = new ArrayList<>();
        List<List<Integer>> listaOriginal = new ArrayList<>();

        listaFila.add(Arrays.asList(100, 80, 90));
        listaFila.add(Arrays.asList(100, 120, 30, 50));
        listaFila.add(Arrays.asList(100, 90, 30, 25));
        
        listaOriginal.add(Arrays.asList(100, 80, 90));
        listaOriginal.add(Arrays.asList(100, 120, 30, 50));
        listaOriginal.add(Arrays.asList(100, 90, 30, 25));
        
        for (List<Integer> l : listaFila) {
            l.sort((e1, e2) -> e2 - e1);
        }
        
        //System.out.println(listaFila);
        //System.out.println(listaOriginal);

        for (int i = 0; i < listaOriginal.size(); i++) {
            
            int cont = 0;
            for (int j = 0; j < listaFila.get(i).size(); j++) {
                if (listaOriginal.get(i).get(j) == listaFila.get(i).get(j)) 
                    cont++;
                
            }
            System.out.println(cont);

        }
    }
}
