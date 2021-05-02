package datas.jodaTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class AppJodaTimeFormat {
    public static void main(String[] args) {
        
        LocalDate data = LocalDate.of(2002, 7, 1);

        // declarando um ZonedDateTime - mesma coisa de LocalDateTime, mas com uma Zona declarada
        ZonedDateTime dataTempo = LocalDateTime.of(2002, 7, 1, 5, 30, 11).atZone(ZoneOffset.of("-03:00"));

        // formato de data brasileiro
        System.out.println(data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(dataTempo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss,SSSSSS")));

        // formato ISO com Offset explicito
        System.out.println(dataTempo.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));

    }
}
