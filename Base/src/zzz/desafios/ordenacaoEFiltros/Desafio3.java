package zzz.desafios.ordenacaoEFiltros;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;

public class Desafio3 {
    /*
    
    O professor Girafales organizou a confecção de um uniforme para as turmas da escola para comemorar o final do ano. Após algumas 
    conversas, ficou decidido com os alunos que eles poderiam escolher a cor do uniforme entre branco ou vermelho. Assim sendo, 
    Girafales precisa de sua ajuda para organizar as listas de quem quer o uniforme em cada uma das turmas, relacionando estas 
    camisetas pela cor, tamanho (P, M ou G) e por último pelo nome.

    Para cada caso de entrada deverão ser impressas as informações ordenadas pela cor em ordem ascendente, seguido pelos tamanhos em 
    ordem descendente e por último por ordem ascendente de nome.

    */
    public static void main(String[] args) {
        List<AlunoPedeRoupa> lista = new ArrayList<>();

        lista.add(new AlunoPedeRoupa("Maria Jose", "branco", "P"));
        lista.add(new AlunoPedeRoupa("Cezar Torres Mo", "branco", "P"));
        lista.add(new AlunoPedeRoupa("Juju Mentina", "branco", "M"));
        lista.add(new AlunoPedeRoupa("Adabi Finho", "branco", "G"));
        lista.add(new AlunoPedeRoupa("Amaro Dinha", "vermelho", "M"));
        lista.add(new AlunoPedeRoupa("Baka Lhau", "vermelho", "P"));

        lista.stream().sorted().forEach(System.out::println);
    }
}

class AlunoPedeRoupa implements Comparable<AlunoPedeRoupa> {
    private String nome;
    private String cor;
    private String tamanho;

    public AlunoPedeRoupa(String nome, String cor, String tamanho) {
        this.nome = nome;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return this.cor + " " + this.tamanho + " " + this.nome;
    }

    @Override
    public int compareTo(AlunoPedeRoupa other) {
        int cor = Collator.getInstance().compare(this.cor, other.cor);
        if (cor > 0)
            return 1;

        if (cor < 0)
            return -1;

        int tamanho = Collator.getInstance().compare(this.tamanho, other.tamanho);
        if (tamanho < 0)
            return 1;

        if (tamanho > 0)
            return -1;

        int nome = Collator.getInstance().compare(this.nome, other.nome);
        if (nome > 0)
            return 1;

        if (nome < 0)
            return -1;

        return 0;
    }
    
}