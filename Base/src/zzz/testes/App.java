package zzz.testes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {

    private static LocalDateTime dataPostagem = LocalDateTime.now();
    public static void main(String[] args) throws Exception {

        System.out.println(dataPostagem.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

    }
}
