package funcoesELambdas.lambdas;

import java.util.Arrays;

import collectionsEMap.classeArrayList.Pessoa;



public class ParametroComEllipsis {
    public static void main(String[] args) {
        
        Calculo soma = numeros -> Arrays.stream(numeros).reduce(0, (resultado, num) -> resultado + num);
        Calculo multiplicacao = numeros -> Arrays.stream(numeros).reduce(1, (resultado, num) -> resultado * num);
        Calculo media = numeros -> Arrays.stream(numeros).reduce(0, (resultado, num) -> resultado + num) / numeros.length;

        System.out.println("Soma -----------> " + soma.calcular(1, 2, -3, -4));
        System.out.println("Multiplicacao --> " + multiplicacao.calcular(2, 2, 3));
        System.out.println("Media ----------> " + media.calcular(10, 20, 30));



        Instanciador instPessoa = Pessoa::new;
        System.out.println(instPessoa.instanciar("Marco", 18));

    }

}

@FunctionalInterface
interface Calculo {
    int calcular(int... numeros);
}


@FunctionalInterface
interface Instanciador {
    Pessoa instanciar(String nome, int idade);
}
