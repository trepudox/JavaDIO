package funcoesELambdas.recursividade;

public class FatorialTailCall {
    public static int fatorial(int valor) {
        return tailCall(valor, 1);
    }

    public static int tailCall(int valor, int n) {
        if (valor > 1)
            return tailCall(valor - 1, valor * n);

        if (valor < 0)
            throw new IllegalArgumentException("Valor não pode ser negativo");

        return n;
    }

    public static void main(String[] args) {
        System.out.println(fatorial(5));
    }
}
