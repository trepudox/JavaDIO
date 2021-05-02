package funcoesELambdas.recursividade;

public class Fatorial {
    public static int fatorial(int valor) {
        if (valor > 1)
            return valor * fatorial(valor - 1);
        
        if (valor < 0)
            throw new IllegalArgumentException("Valor não pode ser negativo");

        return valor;
    }

    public static void main(String[] args) {
        System.out.println(fatorial(-5));
    }
}
