package datas.classeDateFormat;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppDateFormat {
    public static void main(String[] args) {
        Calendar data = Calendar.getInstance();
        Date data2 = Date.from(data.toInstant());
        String dataFormatada = "";

        //System.out.println(data.getTime());

        dataFormatada = DateFormat.getDateTimeInstance().format(data2);
        System.out.println("\n" + dataFormatada + "\n");

        dataFormatada = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(data2);
        System.out.println(dataFormatada);

        dataFormatada = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(data2);
        System.out.println(dataFormatada);

        dataFormatada = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(data2);
        System.out.println(dataFormatada);

        dataFormatada = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL).format(data2);
        System.out.println(dataFormatada);
    }
}
