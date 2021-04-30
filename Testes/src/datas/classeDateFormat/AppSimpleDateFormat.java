package datas.classeDateFormat;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AppSimpleDateFormat {

    public static void main(String[] args) {
        Calendar data = Calendar.getInstance();
        Date data2 = Date.from(data.toInstant());
        String dataFormatada = "";

        //System.out.println(data.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy hh:mm:ss.SSS");

        dataFormatada = formatter.format(data2);

        System.out.println(dataFormatada);
        
    }

}
