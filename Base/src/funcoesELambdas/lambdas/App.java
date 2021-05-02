package funcoesELambdas.lambdas;

public class App {
    public static void main(String[] args) {
        Funcao1 funcao1 = num -> num > 0;
        Funcao2 funcao2 = str -> str.toUpperCase();
        Funcao2 funcao3 = str -> str.toLowerCase();


        System.out.println(funcao1.funcaoInt(1));
        System.out.println(funcao1.funcaoInt(0));
        System.out.println(funcao1.funcaoInt(-1));

        System.out.println();

        System.out.println(funcao2.funcaoString("awwaaa"));
        System.out.println(funcao3.funcaoString("AWWAAA"));
    }   
}

interface Funcao1 {
    public boolean funcaoInt(int n);
}

interface Funcao2 {
    public String funcaoString(String s);
}