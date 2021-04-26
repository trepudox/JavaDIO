package datas.classeDate;

import java.time.Instant;
import java.util.Date;

public class App2 {
    public static void main(String[] args) {
        // Meu Aniversário e hora de nascimento em epoch timestamp (unix timestamp)

        long agora = 1619208012245L;

        long menos = (long) ((((365 * 18.8 + 9) * 24 + 12) * 60) * 60) * 1000L;

        long aniversario = agora - menos;

        Date dataAniversario = new Date(aniversario);

        /*
        System.out.println(aniversario);
        System.out.println(data);
        */

        Instant teste = dataAniversario.toInstant();

        System.out.println(aniversario);

        //System.out.println(data);

        System.out.println(teste.toEpochMilli());

    }
}
