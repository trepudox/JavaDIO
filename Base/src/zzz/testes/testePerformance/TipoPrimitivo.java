package zzz.testes.testePerformance;

public class TipoPrimitivo {

    private static PessoaPrimitivo pessoa = new PessoaPrimitivo();

    public static void teste1() {
        long inicio = System.currentTimeMillis();

        int soma = 0;
        for (int i = 0; i < 10000000; i++)
            soma += i;
        System.out.println(soma);

        long fim = System.currentTimeMillis();
        System.out.println("Tempo necessário: " + (fim - inicio));
    }

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();

        teste1();

        long fim = System.currentTimeMillis();
        System.out.println("Tempo necessário: " + (fim - inicio));
    }

}
