package optionalEStream.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class AppOptional {
    public static void main(String[] args) {
        Optional<String> teste = Optional.empty();
        teste = Optional.ofNullable("tem valor aqui!!!!!");

        System.out.println("\n" + teste);
        System.out.println(teste.get());

        teste.ifPresentOrElse((resp) -> System.out.println("VALOR: " + resp) , () -> System.out.println("está nulo..."));
        teste.ifPresent((resp) -> {
            resp = "dentro do ifPresent!";
            System.out.println(resp + "\n");
        });

        //o método orElse retorna o valor do objeto, caso o mesmo seja nulo, retorna o parametro passado
        teste = Optional.empty();
        System.out.println(teste.orElse("vazio..."));
        
        System.out.println("teste.isEmpty() ? " + teste.isEmpty());
        System.out.println("teste.isPresent() ? " + teste.isPresent());
        
        //os dois retornam Optional.empty
        teste = Optional.empty();
        System.out.println(teste);
        teste = Optional.ofNullable(null);
        System.out.println(teste);

        try {
            // retorna o valor, caso o mesmo seja nulo lança essa exceção
            teste.orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("\nops deu erro");
        }

    }
}
