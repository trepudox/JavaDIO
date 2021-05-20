package com.trepudox;

import java.text.Collator;
import java.util.Objects;

public class Pessoa implements Comparable<Pessoa> {

    private String primeiroNome;
    private String segundoNome;
    private int idade;
    private String numCelular;

    public Pessoa() {}

    public Pessoa(String primeiroNome, String segundoNome, int idade, String numCelular) {
        this.setPrimeiroNome(primeiroNome);
        this.setSegundoNome(segundoNome);
        this.setIdade(idade);
        this.setNumCelular(numCelular);
    }

    public String getPrimeiroNome() {
        return this.primeiroNome;
    }

    public String getSegundoNome() {
        return this.segundoNome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getNumCelular() {
        return this.numCelular;
    }

    public String getNomeCompleto() {
        return this.primeiroNome + " " + this.segundoNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        validaNome(primeiroNome);
        this.primeiroNome = primeiroNome;
    }

    public void setSegundoNome(String segundoNome) {
        validaNome(segundoNome);
        this.segundoNome = segundoNome;
    }

    public void setIdade(int idade) {
        validaIdade(idade);
        this.idade = idade;
    }

    public void setNumCelular(String numCelular) {
        validaNumCelular(numCelular);
        this.numCelular = numCelular;
    }

    private void validaNome(String nome) {
        if (nome.isBlank())
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio!");
        if (nome.length() == 1)
            throw new IllegalArgumentException("Não existem nomes com apenas uma letra!");
    }

    private void validaIdade(int idade) {
        if (idade < 0)
            throw new IllegalArgumentException("A idade de uma pessoa não pode ser negativa!");
        if (idade >= 150)
            throw new IllegalArgumentException("Idade não pode ser maior ou igual a 150!");
    }

    private void validaNumCelular(String numCelular) {
        if (!numCelular.matches("[0-9]+"))
            throw new IllegalArgumentException("Um número de celular só pode conter dígitos numéricos!");

        if (numCelular.length() == 11) {
            if (numCelular.charAt(2) != '9')
                throw new IllegalArgumentException("Esse número não é um número de celular válido, dígito 9 ausente!");
        } else if (numCelular.length() == 9) {
            throw new IllegalArgumentException("O número precisa ter um DDD!");
        } else {
            throw new IllegalArgumentException("Tamanho do número inválido!");
        }

    }

    @Override
    public String toString() {
        return this.primeiroNome + ":" + this.idade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), this.getNomeCompleto(), idade);
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
        return Collator.getInstance().compare(this.getNomeCompleto(), p.getNomeCompleto()) != 0 ?
                Collator.getInstance().compare(this.getNomeCompleto(), p.getNomeCompleto()) :
                Integer.compare(this.getIdade(), p.getIdade());
    }
}