package datas.jodaTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AppJodaTime {

    public static void main(String[] args) {

        System.out.println("\nDATE:");
        LocalDate date = LocalDate.now();
        System.out.println(date);

        date = LocalDate.of(2002, 7, 1);
        System.out.println(date);

        date = LocalDate.ofYearDay(2021, 182);
        System.out.println(date);

        ///////////////////////////////////////

        System.out.println("\nTIME:");
        LocalTime time = LocalTime.now();
        System.out.println(time);
        
        time = LocalTime.of(12, 24, 36);
        System.out.println(time);

        time = LocalTime.ofSecondOfDay(45001);
        System.out.println(time);

        ///////////////////////////////////////

        System.out.println("\nDATETIME:");
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        System.out.println(dateTime.plusDays(100000).withNano(0));


    }
    
}
