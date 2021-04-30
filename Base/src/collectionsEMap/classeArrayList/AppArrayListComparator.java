package collectionsEMap.classeArrayList;

import java.util.ArrayList;
import java.util.List;

public class AppArrayListComparator {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();

        lista.add(new Pessoa("Eric", 40));
        lista.add(new Pessoa("Alice", 25));
        lista.add(new Pessoa("Dino", 67));
        lista.add(new Pessoa("Bruna", 18));
        lista.add(new Pessoa("Carlos", 51));

        System.out.println("\nNORMAL: " + lista);

        ///////////////////////
        System.out.println();//
        /// ORDEM POR IDADE ///
        
        lista.sort((o1, o2) -> o1.getIdade() - o2.getIdade());
        System.out.println("ORDENADA POR IDADE [ASC]: " + lista);
        
        lista.sort((o1, o2) -> o2.getIdade() - o1.getIdade());
        System.out.println("ORDENADA POR IDADE [DESC]: " + lista);
        
        ///////////////////////////////
        System.out.println();//////////
        // ORDEM POR TAMANHO DO NOME //
        
        lista.sort((o1, o2) -> o1.getNome().length() - o2.getNome().length());
        System.out.println("ORDENADA POR TAMANHO DO NOME [ASC]: " + lista);
        
        lista.sort((o1, o2) -> o2.getNome().length() - o1.getNome().length());
        System.out.println("ORDENADA POR TAMANHO DO NOME [DESC]: " + lista);
        
        ///////////////////////
        System.out.println();//
        // ORDEM ALFABÉTICA ///

        lista.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println("ORDEM ALFABÉTICA [ASC]: " + lista);
        
        lista.sort((o1, o2) -> o2.compareTo(o1));
        System.out.println("ORDEM ALFABÉTICA [DESC]: " + lista);

    }
}
