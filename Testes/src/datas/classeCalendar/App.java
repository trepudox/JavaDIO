package datas.classeCalendar;

import java.util.Calendar;

public class App {

    public static String calculaDataFatura(Calendar d) {
        Calendar dataInalterada = (Calendar) d.clone();

        d.add(d.DAY_OF_YEAR, 10);
        if(d.get(d.DAY_OF_WEEK) == 1 || d.get(d.DAY_OF_WEEK) == 7)
            d.add(d.DAY_OF_YEAR, d.get(d.DAY_OF_WEEK) == 1 ? 1 : 2);

        int diasRestantes = d.get(d.DAY_OF_YEAR) - dataInalterada.get(dataInalterada.DAY_OF_YEAR);
        
        return String.format("Você ainda tem %d dias para pagar sem juros, após isso será cobrado um valor adicional a cada dia que passar", diasRestantes);
    }
    public static void main(String[] args) {
        Calendar data = Calendar.getInstance(); //instancia um objeto Calendar com a data atual

        System.out.println(calculaDataFatura(data));

    }
}
