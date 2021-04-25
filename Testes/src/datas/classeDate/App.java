package datas.classeDate;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        long agora = 1619203467146L;

        Date data1 = new Date(agora);

        System.out.println(data1);

        long tempoadd = (((365 * 24) * 60) * 60) * 1000;

        System.out.println(tempoadd);

        System.out.println("Novo timestamp = " + (agora + tempoadd));

        Date data2 = new Date(agora + tempoadd);
        System.out.println(data2);
    }
}
