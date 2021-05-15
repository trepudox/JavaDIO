package zzz.desafios.desafiosBootcampEveris;

import java.util.Locale;
import java.util.Scanner;

public class Desafio2 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
		Scanner scanner = new Scanner(System.in);
		
        String cpfInicial = scanner.next();
        String noveDig = cpfInicial.split("-")[0];
        String ultimosDig = cpfInicial.split("-")[1];

        for (Character c : noveDig.toCharArray()) {
            if (!c.equals('.'))
                System.out.print(c);
            else {
                System.out.println();
            }
        }

        System.out.println();
        System.out.println(ultimosDig);

		scanner.close();
    }
}
