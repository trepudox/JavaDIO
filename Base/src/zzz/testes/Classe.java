package zzz.testes;

import java.util.Objects;

public class Classe {
    
    private String marca;
    private String modelo;
    private int lugares;
    private int genteDentro;

    public Classe(String marca, String modelo, int lugares) {
        this.marca = marca;
        this.modelo = modelo;
        this.lugares = lugares;
        this.genteDentro = 0;
    }

    public void addGente(int g) {
        if (g <= 0) {
            System.out.println("ta de sacanagem");
            return;
        }

        if (this.lugares >= this.genteDentro + g) {
            this.genteDentro += g;
            System.out.println(String.format("Agora %s tem %d pessoas dentro", this.modelo, this.genteDentro));
            return;
        }

        System.out.println(String.format("Então meu fera, o carro já tem %d pessoas e o máximo é %d, você quer botar mais %d ainda? Não vai ter como fazer isso aí não, foi mal!", this.genteDentro, this.lugares, g));

    }

    public void tiraGente(int g) {
        if (this.lugares < g) {
            System.out.println("nem tem tudo isso de lugar kkkkk");
            return;
        }

        if (this.genteDentro < g) {
            System.out.println("tbm n tem tudo isso de gente não kkkk");
            return;
        }

        //deu preguiça

        this.genteDentro -= g;
    }

    public String getMarca() {
        return this.marca;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass(), marca, modelo, lugares, genteDentro);
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
}
