package optionalEStream.streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaStream {
    public static void main(String[] args) {
        List<Pessoa> listaPessoas = new ArrayList<>();

        listaPessoas.add(new Pessoa("Eric", 40));
        listaPessoas.add(new Pessoa("Alice", 25));
        listaPessoas.add(new Pessoa("Dino", 67));
        listaPessoas.add(new Pessoa("Gustavo", 15));
        listaPessoas.add(new Pessoa("Bruna", 18));
        listaPessoas.add(new Pessoa("Flavia", 30));
        listaPessoas.add(new Pessoa("Carlos", 51));

        System.out.println(listaPessoas.stream().map((e) -> {
            return String.format("%s - %d", e.getNome(), e.getIdade());
        }).collect(Collectors.toList()));

        System.out.print("\nPessoas na lista: ");
        System.out.println(listaPessoas.stream().count());

        System.out.print("\nPessoas com 18 anos ou menos: "); 
        System.out.println(listaPessoas.stream().filter((e) -> e.getIdade() <= 18).collect(Collectors.toList()));

        System.out.print("\nTodas as pessoas: ");
        listaPessoas.stream().map((e) -> e.getNome() + " ").sorted().forEach(System.out::print);

        System.out.print("\n\nPessoas na lista que possuem letra R no nome: "); 
        System.out.println(listaPessoas.stream().filter((e) -> e.getNome().toLowerCase().contains("r")).collect(Collectors.toList()));

        System.out.print("\nHá alguém na lista que possui a letra V no nome? "); 
        System.out.println(listaPessoas.stream().anyMatch((e) -> e.getNome().toLowerCase().contains("v")));

        System.out.print("\nPessoa mais velha da lista: ");
        System.out.println(listaPessoas.stream().max((o1, o2) -> o1.getIdade() - o2.getIdade()).get());

        System.out.print("\nPessoa mais nova da lista: ");
        System.out.println(listaPessoas.stream().min((o1, o2) -> o1.getIdade() - o2.getIdade()).get());

        System.out.print("\nSoma das idades: ");
        System.out.println(listaPessoas.stream().reduce(0, (result, o) -> result + o.getIdade(), Integer::sum));

        System.out.print("\nMedia das idades: ");
        System.out.println(listaPessoas.stream().reduce(0, (result, o) -> (result + o.getIdade()), Integer::sum) / listaPessoas.stream().count());

        /*        FAZ O MESMO QUE A LINHA 47!!!!! (diferença de desempenho e legibilidade gritantes)

        int cont = 0;
        for (Pessoa p : listaPessoas) {
            cont += p.getIdade();
        }
        System.out.println(cont);

        */
    }
}
