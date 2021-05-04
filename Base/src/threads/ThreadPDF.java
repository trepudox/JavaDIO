package threads;

public class ThreadPDF {
    public static void main(String[] args) throws Exception {
        Thread gerarPDF = new Thread(new GerarPDF(5500L));
        Thread carregamento = new Thread(new Carregamento(gerarPDF));

        gerarPDF.start();
        carregamento.start();

    }
}

class GerarPDF implements Runnable {

    private long tempo;

    public GerarPDF(long tempo) {
        this.tempo = tempo;
    }

    @Override
    public void run() {
        try {
            // codigo que estaria gerando o pdf
            Thread.sleep(this.tempo);
            
        } catch (InterruptedException e) {
            System.out.println("Ocorreu um erro inesperado");
            System.out.println("Erro: " + e);
            
            //e.printStackTrace();
        }
    }
}

class Carregamento implements Runnable {
    
    private Thread thread;

    public Carregamento(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        while (true) {
            if (!thread.isAlive())
                break;
                
            try {
                Thread.sleep(500);
                System.out.println("Carregando...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("PDF gerado com sucesso");
    }
}