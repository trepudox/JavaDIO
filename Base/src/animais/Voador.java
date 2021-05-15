package animais;

public interface Voador {
    default void voar() {
        System.out.println("estou voando");
    }
}
