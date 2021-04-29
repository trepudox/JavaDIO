package threads;

import java.util.InputMismatchException;
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
                System.out.println("Insira dados válidos");
                System.out.println(e);
            }
        }

        scanner.close();

        System.out.println(String.format("Corrida de Threads, a primeira Thread que atingir o número %d ganha", num));

        Thread.sleep(2000);

        System.out.println("*** COMEÇOU ***");

        Thread.sleep(100);

        String t1nome = "Marco";
        String t2nome = "Cachorro";
        String t3nome = "Navio";

        Thread2 t1 = new Thread2(t1nome, num);
        Thread2 t2 = new Thread2(t2nome, num);
        Thread2 t3 = new Thread2(t3nome, num);

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(t3);


        //Thread thread1 = new Thread(new Thread2("Marco", num));
        //Thread thread2 = new Thread(new Thread2("Cachorro", num));
        //Thread thread3 = new Thread(new Thread2("Navio", num));

        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println();

        while (true) {
            if (!thread1.isAlive() || !thread2.isAlive() || !thread3.isAlive()) {
                System.out.println((!thread1.isAlive() ? t1nome : 
                !thread2.isAlive() ? t2nome : 
                t3nome) + " venceu a corrida de Threads!");
                if (!thread1.isInterrupted()) {
                    thread1.interrupt();
                }
                if (!thread2.isInterrupted()) {
                    thread2.interrupt();
                }
                if (!thread3.isInterrupted()) {
                    thread3.interrupt();
                }
                
                System.exit(0);
            }
        }
        
    }
}
