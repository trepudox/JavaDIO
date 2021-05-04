package zzz.testes;

public class App {
    public static void main(String[] args) throws Exception {

        Classe carro = new Classe("Volkswagen", "Fusca", 5);

        carro.addGente(10);
        carro.addGente(1);

        carro.tiraGente(10);
        carro.tiraGente(3);
        carro.tiraGente(1);
    }
}
