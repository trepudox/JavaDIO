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

        for(int i = num; i >= 0; i--) {
            try{
                int rand = random.nextInt(5000);
                Thread.sleep(rand);
                System.out.println(String.format("%s: %d - %.3fs", this.nome, i, (float) rand / 1000));
            } catch (InterruptedException e) {}
        }
    }

    public String getNome() {
        return this.getNome();
    }
}
