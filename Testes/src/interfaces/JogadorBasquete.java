package interfaces;

public class JogadorBasquete extends Atleta implements AtletaUsaMao {
    
    public JogadorBasquete(String nome, int idade, String time, int contrato) {
        super(nome, idade, time, contrato);
    }

    @Override
    public void jogar() {
        System.out.println(String.format("%s está jogando basquete", this.getNome()));
        this.arremessar(this.getNome());
    }

}
