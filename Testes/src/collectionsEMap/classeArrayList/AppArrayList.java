package collectionsEMap.classeArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AppArrayList {
    public static void main(String[] args) {
        
        ArrayList<String> nomes = new ArrayList<>();

        nomes.add("Marco");
        nomes.add("Otavio");
        nomes.add("Ronaldo");
        nomes.add("Marcelo");
        nomes.add("Anderson");

        System.out.println("Lista inicial: " + nomes);

        Collections.shuffle(nomes);
        System.out.println("Sorteada: " + nomes);

        Collections.sort(nomes);
        System.out.println("Ordenada: " + nomes);

        String[] arrayNomes = new String[nomes.size()];
        int cont = 0;
        for (String item : nomes) {
            arrayNomes[cont] = item;
            cont++;
        }

        System.out.println(Arrays.toString(arrayNomes));
        
        String[] copia = Arrays.copyOf(arrayNomes, arrayNomes.length + 1);
        
        System.out.println(Arrays.toString(copia));

        ArrayList<String> nomes2 = new ArrayList<>();
    }
}
