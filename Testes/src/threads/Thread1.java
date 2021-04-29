package threads;

public class Thread1 extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("Thread1 rodando...");
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
