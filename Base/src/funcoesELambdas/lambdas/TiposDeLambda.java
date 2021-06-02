package funcoesELambdas.lambdas;

import java.util.function.*;

public class TiposDeLambda {

    public TiposDeLambda() {}

    public static void main(String[] args) {
        // Consumer - não retorna nada (void), apenas recebe um argumento e executa algum algoritmo
        Consumer<String> print1 = str -> System.out.println(str);
        Consumer<String> print2 = System.out::println;  // Method Reference - apenas executa a função declarada com o argumento recebido

        print1.accept("Hello World");
        print2.accept("Adoro suco\n");



        // Predicate - recebe um valor T, pode executar algum algoritmo e retorna um boolean
        Predicate<String> lengthIgualA10 = str -> str.length() == 10;
        Predicate<String> lengthMenorQue10 = str -> str.length() < 10;

        System.out.println(lengthIgualA10.test("dez"));
        System.out.println(lengthMenorQue10.test("dez") + "\n");
        


        // Operator - os tipos precisam ser os mesmos, tanto da entrada dos dois objetos quanto de saída dos mesmos (recebe T e retorna T)
        UnaryOperator<String> upperCase = String::toUpperCase;
        BinaryOperator<String> somaString = (o1, o2) -> o1 + o2;

        System.out.println(upperCase.apply("vai se tornar uppercase"));
        System.out.println(somaString.apply("aaa", "bbb"));
        System.out.println(upperCase.apply(somaString.apply("aaa", "bbb")) + "\n");


        // Function - recebe um valor de entrada e retorna outro de saída, podem ser de tipos diferentes ou iguais
        ToIntFunction<String> tamanho = String::length; // recebe uma String e retorna um Integer
        Function<String, String> stringDuplicada = str -> str + str;

        System.out.println(tamanho.applyAsInt("cinco"));
        System.out.println(stringDuplicada.apply("Dois"));



        // Supplier - não recebe nada e retorna algum objeto de tipo explícito
        Supplier<TiposDeLambda> criaObjeto = TiposDeLambda::new;
        Supplier<String> criaString = String::new;
        IntSupplier retornaDez = () -> 10;

        System.out.println("\n" + criaObjeto.get());
        System.out.println(criaString.get()); //vazio
        System.out.println(retornaDez.getAsInt());

    }

    @Override
    public String toString() {
        return "TiposDeLambda em String!!!";
    }
}
