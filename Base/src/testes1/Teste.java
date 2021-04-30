package testes1;

public class Teste {
    public static void main(String[] args) {
        String nome1 = "Marco";
        String nome2 = "Enzo";

        boolean nomeMaiorQue10 = nome1.length() > 10;

        String resultado = String.format("%.1f saiu ontem a noite e morreu pq o %s matou ele", 1.5, nomeMaiorQue10 ? nome1 : nome2);

        System.out.println(resultado);
    }
}
