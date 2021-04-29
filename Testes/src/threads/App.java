package threads;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int num = 0;

        while (num < 5 || num > 100) {
            try {
                System.out.print("Escolha um número de 5 a 100: ");
                num = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nInsira dados válidos");
                System.out.println(e);
            }
        }

        scanner.close();

        System.out.println(String.format("Corrida de Threads, a primeira Thread que atingir o número %d ganha", num));
        Thread.sleep(2000);

        System.out.println("*** COMEÇOU ***");
        Thread.sleep(100);

        String t1nome = "Marco";
        String t2nome = "fFaker";
        String t3nome = "pipas";
        String t4nome = "Ricardo";
        String t5nome = "Kamada";

        Thread thread1 = new Thread(new Thread2(t1nome, num));
        Thread thread2 = new Thread(new Thread2(t2nome, num));
        Thread thread3 = new Thread(new Thread2(t3nome, num));
        Thread thread4 = new Thread(new Thread2(t4nome, num));
        Thread thread5 = new Thread(new Thread2(t5nome, num));
        
        Map<String, Thread> mapThreads = new HashMap<>();

        mapThreads.put(t1nome, thread1);
        mapThreads.put(t2nome, thread2);
        mapThreads.put(t3nome, thread3);
        mapThreads.put(t4nome, thread4);
        mapThreads.put(t5nome, thread5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        System.out.println();

        while (true) {
            for (Map.Entry<String, Thread> entry : mapThreads.entrySet()) {
                if (!entry.getValue().isAlive()) {
                    System.out.println();
                    System.out.println(entry.getKey() + " venceu a corrida de Threads!");
                    
                    for (Map.Entry<String, Thread> entry2 : mapThreads.entrySet()) {
                        if (!entry2.getValue().isInterrupted()) {
                            entry2.getValue().interrupt();
                        }
                    }

                    System.exit(0);

                }
            }
        }
    }
}
