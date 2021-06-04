package zzz.testes.reduceObjetoComplexo;

import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Pessoa> listaPessoas = List.of(new Pessoa("Marco", 18), new Pessoa("Alonso", 30),
                new Pessoa("Jorge", 55), new Pessoa("Turista", 9));

        Pessoa pessoaResultado = listaPessoas.stream()
                .reduce(new Pessoa("Rato", 9), (pessoaAcumulada, pessoaRecebida) -> {
                    String nomeSomado = pessoaAcumulada.getNome() + pessoaRecebida.getNome();
                    String idadeSomada = String.valueOf(pessoaAcumulada.getIdade()) + String.valueOf(pessoaRecebida.getIdade());

                    pessoaAcumulada.setNome(nomeSomado);
                    pessoaAcumulada.setIdade(Integer.parseInt(idadeSomada));
                    return pessoaAcumulada;
                });

        System.out.println(pessoaResultado);
    }

}
