package atleta.interfaces;

public interface AtletaUsaMao {
    
    public default void arremessar(String nome) {
        System.out.println(nome + " está arremessando a bola");
    }

    public default void arremessar(String nome, int quant) {
        System.out.println(String.format("está arremessando a bola %d vezes"));
    }

}
