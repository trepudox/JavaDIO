package zzz.testes.testePerformance;

public class TipoWrapper {

    private static PessoaWrapper pessoa = new PessoaWrapper();

    public static void teste1() {
        Long inicio = System.currentTimeMillis();

        Integer soma = 0;
        for (Integer i = 0; i < 10000000; i++)
            soma += i;
        System.out.println(soma);

        Long fim = System.currentTimeMillis();
        System.out.println("Tempo necessário: " + (fim - inicio));
    }



    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();

        teste1();

        long fim = System.currentTimeMillis();
        System.out.println("Tempo necessário: " + (fim - inicio));
    }

}
