package zzz.desafios.ordenacaoEFiltros;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Desafio4pt2 {
    public static void main(String[] args) {
        Random random = new Random();
        int qntFila =  random.nextInt(5) + 1;
        System.out.println("Quantidade de filas: " + qntFila);
        
        List<List<Integer>> listaFila = new ArrayList<>(); 
        List<List<Integer>> listaOriginal = new ArrayList<>();
        
        for (int i = 0; i < qntFila; i++) {
          int qntClientes = random.nextInt(6) + 1;
          
          List<Integer> listaProv = new ArrayList<>();
          List<Integer> listaProv2 = new ArrayList<>();
          
          for (int j = 0; j < qntClientes; j++) {
            int num = (random.nextInt(20) + 1) * 10;
            listaProv.add(num);
            listaProv2.add(num);
          } 
          
          listaFila.add(listaProv);
          listaOriginal.add(listaProv2);
        }
        
      for (List<Integer> l : listaFila) {
            l.sort((e1, e2) -> e2 - e1);
        }

        System.out.println("Lista ordenada: " + listaFila);
        System.out.println("Lista original: " + listaOriginal);
        
        for (int i = 0; i < listaOriginal.size(); i++) {
            
            int cont = 0;
            for (int j = 0; j < listaFila.get(i).size(); j++) {
                if (listaOriginal.get(i).get(j).equals(listaFila.get(i).get(j))) 
                    cont++;
                
            }
            
            System.out.println(cont);
        }
        
    }
}
