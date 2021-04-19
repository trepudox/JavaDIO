package interfaces;

public abstract class Atleta extends Pessoa {
    
    private String time; //ou clube ou nação ou fundação etc

    private int contrato; //em anos

    public Atleta() {}

    public Atleta(String nome, int idade, String time, int contrato) {
        super(nome, idade);
        this.time = time;
        this.contrato = contrato;
    }
    
    public final String transferir(String time) {
        String exClube = this.time;
        this.time = time;
        return exClube;
    }
    
    public abstract void jogar();

    public final String getTime() {
        return this.time;
    }

    public final void setTime(String time) {
        this.time = time;
    }

    public final int getContrato() {
        return this.contrato;
    }

    public final void setContrato(int contrato) {
        this.contrato = contrato;
    }

}
