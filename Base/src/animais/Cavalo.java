package animais;

public class Cavalo extends Animal {
    public Cavalo(String nome, int idade) {
        super(nome, "cavalo", idade);
    }

    @Override
    public void correr() {
        super.correr();
        System.out.println("mas como o cavalo é muito rapido ele galopa");
    }
}
