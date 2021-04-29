package collectionsEMap.classeSet;

import java.util.HashSet;
import java.util.Set;

public class AppHashSet {
    public static void main(String[] args) {
        Set<Integer> listaNumeros = new HashSet<>();

        listaNumeros.add(3);
        listaNumeros.add(88);
        listaNumeros.add(20);
        listaNumeros.add(15);
        listaNumeros.add(44);
        listaNumeros.add(3);

        for (Integer i : listaNumeros) {
            System.out.println(i);
        }

        listaNumeros.remove(3);

        listaNumeros.add(23);

        System.out.println("Size: " + listaNumeros.size());

        listaNumeros.add(null);
        
        System.out.println(listaNumeros);

        //listaNumeros.clear();

        System.err.println(listaNumeros.isEmpty() ? "listaNumeros está vazia" : "listaNumeros NÃO está vazia");
    }
}
