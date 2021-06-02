package optionalEStream.streamAPI;

import java.text.Collator;
import java.util.Objects;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;

    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    @Override
    public String toString() {
        return this.nome + ":" + this.idade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), nome, idade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        if (this.hashCode() != o.hashCode())
            return false;

        return true;
    }

    @Override
    public int compareTo(Pessoa p) {
        //usando Collator podemos comparar ordem alfabética
        return Collator.getInstance().compare(this.getNome(), p.getNome());
    }
}
