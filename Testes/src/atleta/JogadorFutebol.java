package atleta;

import atleta.interfaces.AtletaUsaPerna;

public class JogadorFutebol extends Atleta implements AtletaUsaPerna {
    
    public JogadorFutebol(String nome, int idade, String time, int contrato) {
        super(nome, idade, time, contrato);
    }

    public void jogar() {
        System.out.println(String.format("%s está jogando futebol", this.getNome()));
        this.correr(this.getNome());
        this.chutar(this.getNome());
    }
    
    @Override
    public String toString() {
        return this.getNome() + " jogador de futebol";
    }
}
