package collections.classeArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class AppArrayList2 {
    public static void main(String[] args) {
        
        ArrayList<String> nomes = new ArrayList<>();

        nomes.add("Juliana");
        nomes.add("Pedro");
        nomes.add("Carlos");
        nomes.add("Larissa");
        nomes.add("João");
        
        System.out.println();
        for (String item : nomes) {
            System.out.println(item);
        }
        System.out.println();

        nomes.set(2, "Roberto");

        System.out.println(nomes.get(2));

        nomes.remove(4);
        nomes.remove("João");

        System.out.println(nomes.size());

        System.out.println(nomes.contains("Juliano") ? "A lista contém Juliano" : "A lista NÃO contém Juliano");

        System.out.println();

        ArrayList<String> nomes2 = new ArrayList<>();
        nomes2.add("Ismael");
        nomes2.add("Rodrigo");

        nomes.addAll(nomes2);

        Collections.sort(nomes);

        System.out.println(nomes);
        
        Collections.swap(nomes, 0, nomes.size() - 1);
        
        System.out.println(nomes);

    }
}
