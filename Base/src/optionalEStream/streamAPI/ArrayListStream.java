package optionalEStream.streamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayListStream {

    private static int contador = 0;
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();

        lista.add("Andre");
        lista.add("Marco");
        lista.add("Fred");
        lista.add("Roberta");
        lista.add("Roberta");
        lista.add("Mauricio");
        lista.add("Roberta");
        lista.add("Alice");
        lista.add("Joao");
        lista.add("Flavio");
        lista.add("Otavio");
        lista.add("Carol");
        lista.add("Dino");

        System.out.println("LISTA DEFAULT: " + lista + " - size() " + lista.stream().count());



        // max e min - retorna o valor maximo e valor minimo (usa o metodo compareTo() !!!)
        System.out.println( "\n" + lista.stream().max((o1, o2) -> o1.length() - o2.length()) );
        System.out.println( lista.stream().min(Comparator.comparingInt(String::length)) );



        // filter - retorna uma nova stream de acordo com o filtro passado
        // filter sempre terá uma condição booleana que implicará na inclusão ou exclusão dos elementos da lista
        List<String> listaFiltrada = lista.stream().filter((resp) -> resp.length() > 5).collect(Collectors.toList());
        Set<String> setFiltrado = lista.stream().filter((resp) -> resp.length() > 5).collect(Collectors.toSet());
        System.out.println("\nLISTA FILTRADA: " + listaFiltrada);
        System.out.println("SET FILTRADO: " + setFiltrado);



        // map - retorna uma nova stream (do mesmo tamanho) de acordo com o algoritmo passado dentro dele
        // map aplica uma função a todos os elementos passados por ele, retornando o resultado dos mesmos
        List<String> listaMapeada = lista.stream().map((resp) -> resp.concat(":" + resp.length())).collect(Collectors.toList());
        System.out.println("\nLISTA MAPEADA: " + listaMapeada);
        
        Set<String> setMapeado = lista.stream().map((resp) -> {
            resp = String.valueOf(contador);
            contador++;
            return resp;
        }).collect(Collectors.toSet());
        System.out.println("SET MAPEADO: " + setMapeado + "\n");



        // peek e forEach - iteram sobre os elementos da lista
        // a diferença entre o peek e o forEach é que o forEach por padrão não retorna nada, o peek retorna a lista inicial
        lista.stream().map((e) -> e.concat(" ")).forEach(System.out::print);
        
        List<String> listaPeek = lista.stream().map((e) -> e.concat(" ")).peek(System.out::print).collect(Collectors.toList());
        System.out.println("\nLISTA PEEK: " + listaPeek);
        
        
        
        // Match - retornam true ou false se todos/qualquer/nenhum elemento(s) bater a condição exigida
        boolean allPossuemLetraA = lista.stream().allMatch((e) -> e.toLowerCase().contains("a"));
        System.out.println("\nTodos na lista possuem letra a 'A' ? " + allPossuemLetraA);

        boolean anyPossuiLetraW = lista.stream().anyMatch((e) -> e.toLowerCase().contains("w"));
        System.out.println("Qualquer um na lista possui a letra 'W' ? " + anyPossuiLetraW);

        boolean noneTemMaisDe10DeLength = lista.stream().noneMatch((e) -> e.length() > 10);
        System.out.println("Nenhum na lista tem mais de 10 de length ? " + noneTemMaisDe10DeLength);



        // OUTRAS FUNÇÕES IMPORTANTES

        // Collectors
        // Collectors.toList(), Collectors.toSet() - transforma a Stream atual em uma Collection do tipo escolhido
        // Collectors.joining() - trasnforma toda a Stream em uma String só
        
        // distinct - remove duplicados da lista
        System.out.println("\nLISTA COM DUPLICADOS: " + lista);
        System.out.println("LISTA SEM DUPLICADOS: " + lista.stream().distinct().collect(Collectors.toList()));

        // findFirst e findAny - findFirst retorna o primeiro da lista, 
        // findAny retorna "qualquer um", é mais performático mas menos consistente.
        System.out.print("\n" + lista.stream().findFirst().get());
        System.out.print(" ");
        System.out.println(lista.stream().findAny().get());

        // sorted - ordena os itens (usa o metodo compareTo() !!!)
        System.out.println("\nLISTA COM ITENS ORDENADOS: " + lista.stream().sorted().collect(Collectors.toList()));

        // groupingBy - semelhante ao do SQL, agrupa de acordo com uma característica em comum com outros elementos
        System.out.println("\nLISTA AGRUPADA POR TAMANHO: " + lista.stream().map((e) -> e.concat(":" + e.length()))
                .collect(Collectors.groupingBy((e) -> e.length() - 2)));

        // limit - limita o numero de elementos
        System.out.println("\nRETORNO DE APENAS 3 ITENS: " + lista.stream().limit(3).collect(Collectors.toList()));

        // skip - pula a quantidade especificada de elementos da lista
        System.out.println("\nPULANDO OS PRIMEIROS 3 ELEMENTOS: " + lista.stream().skip(3).collect(Collectors.toList()));

        // reduce - reduz a lista a um elemento só
        // código que soma o tamanho de todos os nomes
        System.out.println("\nSOMA DO TAMANHO DOS NOMES: " + lista.stream().reduce(0, (result, e) -> result + e.length(), Integer::sum));

        // código que calcula a media do tamanho dos nomes
        System.out.println(String.format("MEDIA DO TAMANHO DOS NOMES: %.2f", lista.stream().reduce(0, (resultado, o) -> resultado + o.length(), Integer::sum) / (double) lista.size()));

        // collect - usado desta maneira transforma a stream em uma lista ou um set por exemplo
        lista.stream().collect(Collectors.toList());
        
        // close - fecha a stream
        lista.stream().close();

    }
}