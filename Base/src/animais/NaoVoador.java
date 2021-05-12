package animais;

public interface NaoVoador {
    default void naoSeiVoar() {
        System.out.println("nao sei voar!!!!");
    }
}
