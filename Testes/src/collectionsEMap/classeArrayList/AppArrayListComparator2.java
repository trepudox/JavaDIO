package collectionsEMap.classeArrayList;

import java.util.ArrayList;
import java.util.List;

public class AppArrayListComparator2 {
    public static void main(String[] args) {
        
        List<Pessoa> lista = new ArrayList<>();

        lista.add(new Pessoa("C", 18));
        lista.add(new Pessoa("A", 18));
        lista.add(new Pessoa("B", 18));
        lista.add(new Pessoa("B", 20));
        lista.add(new Pessoa("A", 20));
        lista.add(new Pessoa("AA", 20));

        System.out.println(lista);

        //fazendo comparação encadeada
        lista.sort((o1, o2) -> { 
            int resp = o1.getIdade() - o2.getIdade();
            return resp != 0 ? resp : o1.compareTo(o2);
        });

        System.out.println(lista);

    }
}
