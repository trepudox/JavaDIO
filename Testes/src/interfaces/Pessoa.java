package interfaces;

public abstract class Pessoa {
    
    private String nome;

    private int idade;

    public Pessoa() {}

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public final String getNome() {
        return this.nome;
    }

    public final void setNome(String nome) {
        this.nome = nome;
    }

    public final int getIdade() {
        return this.idade;
    }

    public final void setIdade(int idade) {
        this.idade = idade;
    }

}
