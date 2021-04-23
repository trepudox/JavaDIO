package atleta.enums;

public enum LadoDominante {
    DIREITO(1, "Direito"), 
    ESQUERDO(2, "Esquerdo"), 
    AMBIDESTRO(3, "Direto e Esquerdo");

    private int codigo;
    private String lado;

    private LadoDominante(int codigo, String lado){
        this.codigo = codigo;
        this.lado = lado;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getLado() {
        return this.lado;
    }

}