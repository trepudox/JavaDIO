package atleta.interfaces;

public interface AtletaUsaPerna {
    
    public default void correr(String nome) {
        System.out.println(String.format("%s está correndo", nome));
    }

    public default void correr(String nome, int minutos) {
        System.out.println(String.format("%s está correndo há %d minutos", nome, minutos));
    }

    public default void chutar(String nome) {
        System.out.println(String.format("%s está chutando", nome));
    }

}
