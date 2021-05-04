package threads;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class CorridaDeThreads {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Thread> mapThreads = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int num = 0;

        while (num < 5 || num > 100) {
            try {
                System.out.print("Escolha um número de 5 a 100: ");
                num = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nInsira dados válidos");
                System.out.println(e);
            } catch (Exception e) {
                System.out.println("\nHouve um erro inesperado");
                System.out.println(e);
            }
        }

        int num2 = 0;
        while (num2 < 1 || num2 > 10) {
            try {
                System.out.print("Escolha o número de Threads, de 1 a 10: ");
                num2 = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nInsira dados válidos");
                System.out.println(e);
            } catch (Exception e) {
                System.out.println("\nHouve um erro inesperado");
                System.out.println(e);
            }
        }

        for (int i = 0; i < num2; i++) {
            try{
                System.out.print(String.format("Insira um nome para a %dª Thread: ", i + 1));
                String nome = scanner.next();
                mapThreads.put(nome, new Thread(new Thread2(nome, num)));
            } catch (Exception e) {
                System.out.println("\nHouve um erro inesperado");
                System.out.println(e);
            }
        }

        scanner.close();

        System.out.println(String.format("Corrida de Threads, a primeira Thread que chegar de %d até 0 ganha\n", num));
        Thread.sleep(2000);

        System.out.println("***** COMEÇOU *****");
        Thread.sleep(100);

        for (Map.Entry<String, Thread> entry : mapThreads.entrySet()) {
            entry.getValue().start();
        }
        System.out.println();

        while (true) {
            for (Map.Entry<String, Thread> entry : mapThreads.entrySet()) {
                if (!entry.getValue().isAlive()) {
                    System.out.println("\n" + entry.getKey() + " venceu a corrida de Threads!");

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



class Thread2 implements Runnable {
    private static Random random = new Random();
    private String nome;
    private int num;

    public Thread2(String nome, int num) {
        this.nome = nome;
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(this.nome + " começou...");

        for(int i = num; i >= 0; i--) {
            try{
                int rand = random.nextInt(5000);
                Thread.sleep(rand);
                System.out.println(String.format("%s: %d - %.3fs", this.nome, i, (float) rand / 1000));
            } catch (InterruptedException e) {}
            catch (Exception e) {
                System.out.println("\nHouve um erro inesperado");
                System.out.println("Erro: " + e);
            }
        }
    }

    public String getNome() {
        return this.getNome();
    }
}
