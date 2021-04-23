package atleta;

import atleta.enums.LadoDominante;

public class App {
    public static void main(String[] args) {
        
        JogadorBasquete jogador1 = new JogadorBasquete("Marco", 18, "Sao Paulo", 2);
        JogadorBasquete jogador2 = new JogadorBasquete("Marco", 18, "Sao Paulo", 2);

        System.out.println(jogador1.hashCode() + " " + jogador1.equals(jogador2) + " " + jogador2.hashCode());
        
    }
}
