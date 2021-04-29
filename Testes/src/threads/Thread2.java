package threads;

import java.util.Random;

public class Thread2 implements Runnable {
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

        for(int i = 0; i <= num; i++) {
            try{
                Thread.sleep(random.nextInt(5000));
                System.out.println(String.format("%s: %d", this.nome, i));
            } catch (InterruptedException e) {
            }
        }

        System.out.println(this.nome + " terminou sua execução.");
    }

    public String getNome() {
        return this.getNome();
    }
}
