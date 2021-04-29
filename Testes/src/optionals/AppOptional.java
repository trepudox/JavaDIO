package optionals;

import java.util.NoSuchElementException;
import java.util.Optional;

public class AppOptional {
    public static void main(String[] args) {
        System.out.println();

        Optional<String> teste = Optional.empty();
        teste = Optional.ofNullable("tem valor aqui!!!!!");

        System.out.println(teste);
        System.out.println(teste.get());

        teste.ifPresent(resp -> {
            resp = "dentro do ifPresent!";
            System.out.println(resp);
            System.out.println();
        });

        teste = Optional.empty();
        System.out.println(teste.orElse("vazio..."));

        System.out.println("teste.isEmpty() ? " + teste.isEmpty());
        System.out.println("teste.isPresent() ? " + teste.isPresent());

        try {
            // retorna o valor, caso o mesmo seja nulo lança essa exceção
            teste.orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("\nops");
        }

    }
}
