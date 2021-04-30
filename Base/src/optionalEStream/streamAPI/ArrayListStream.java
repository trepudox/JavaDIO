package optionalEStream.streamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        boolean todosNaListaPossuemLetraA = lista.stream().allMatch((e) -> e.toLowerCase().contains("a"));
        System.out.println("\ntodosNaListaPossuemLetraA ? " + todosNaListaPossuemLetraA);

        boolean qualquerUmNaListaPossuiLetraW = lista.stream().anyMatch((e) -> e.toLowerCase().contains("w"));
        System.out.println("qualquerUmNaListaPossuiLetraW ? " + qualquerUmNaListaPossuiLetraW);

        boolean nenhumNaListaTemMaisDe10DeLength = lista.stream().noneMatch((e) -> e.length() > 10);
        System.out.println("nenhumNaListaTemMaisDe10DeLength ? " + nenhumNaListaTemMaisDe10DeLength);



        // OUTRAS FUNÇÕES IMPORTANTES
        
        // distinct - remove duplicados da lista
        System.out.println("\nLISTA COM DUPLICADOS: " + lista);
        System.out.println("LISTA SEM DUPLICADOS: " + lista.stream().distinct().collect(Collectors.toList()));

        // findFirst e findAny - findFirst retorna o primeiro da lista, 
        // findAny retorna "qualquer um", é mais performático mas menos consistente.
        System.out.println(lista.stream().findFirst().get());
        System.out.println(lista.stream().findAny().get());

        // sorted - ordena os itens (usa o metodo compareTo() !!!)
        System.out.println(lista.stream().sorted().collect(Collectors.toList()));

        // groupingBy - semelhante ao do SQL, agrupa de acordo com uma característica em comum com outros elementos
        System.out.println(lista.stream().map((e) -> e.concat(":" + e.length()))
                .collect(Collectors.groupingBy((e) -> e.length() - 2)));

        // close - fecha a stream
        lista.stream().close();

    }
}