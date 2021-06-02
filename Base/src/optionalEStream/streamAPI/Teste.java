package optionalEStream.streamAPI;

import java.text.Collator;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Teste {

    public static void main(String[] args) {
        List<String> lista = List.of("asd", "10", "careca osso", "argumento", "palabvras", "PALAV", "palato", "Alegria",
                "beijo", "CEGONHA", "Dente", "Ermione", "Fagulha", "GENGIBRE", "hora", "ignacio", "marco18", "ggg1", "H14");

//        List<Integer> elementosComLengthMaiorQue5 = lista.stream().filter(str -> str.length() > 5)
//                .peek(el -> System.out.print(el + " "))
//                .flatMap(str -> Arrays.stream(str.split(" ")).map(String::length))
//                .collect(Collectors.toList());

        lista.stream().sorted((o1, o2) -> o1.length() - o2.length() != 0 ? o1.length() - o2.length()
                : Collator.getInstance().compare(o1, o2)).forEach(System.out::println);

        System.out.println(lista.stream().sorted((e1, e2) -> {
            int resultado = e1.length() - e2.length();
            return resultado != 0 ? resultado : Collator.getInstance().compare(e1, e2);
        }).reduce("", (acumulador, entrada) -> acumulador + entrada.charAt(0) + " ").trim());

//        System.out.println(lista.stream().anyMatch(e -> e.equals("asd")));


    }

}
