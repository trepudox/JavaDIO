package collections.classeQueue;

import java.util.LinkedList;
import java.util.Queue;

public class AppQueue {
    public static void main(String[] args) {
        
        Queue<String> filaBanco = new LinkedList<>();

        filaBanco.add("Ronaldo");
        filaBanco.add("Marco");
        filaBanco.add("César");
        filaBanco.add("Nicole");
        filaBanco.add("Jorge");
        filaBanco.add("Alberto");

        for (String cliente : filaBanco) {
            System.out.println(cliente);
        }

        System.out.println(filaBanco.peek());

        System.out.println(filaBanco);

        System.out.println(filaBanco.poll());

        System.out.println(filaBanco);

        filaBanco.add("Daniel");

        System.out.println(filaBanco + " TAMANHO -> " + filaBanco.size());

        System.out.println("A fila está vazia? " + filaBanco.isEmpty());
        System.out.println("Marco está na fila? " + filaBanco.contains("Marco"));
        
        filaBanco.clear();
        System.out.println("A fila está vazia? " + filaBanco.isEmpty());


    }
}
