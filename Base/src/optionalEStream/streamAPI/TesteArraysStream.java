package optionalEStream.streamAPI;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class TesteArraysStream {
    public static void main(String[] args) {
        int[] arrayInt = {1, 2, 3, 4};

        System.out.println(Arrays.stream(arrayInt).sum());
        System.out.println(Arrays.stream(arrayInt).average().getAsDouble());
        System.out.println(Arrays.stream(arrayInt).max().getAsInt());
        System.out.println(Arrays.stream(arrayInt).min().getAsInt());

        double[] arrayDouble = Arrays.stream(arrayInt).asDoubleStream().toArray();   
        System.out.println(Arrays.toString(arrayDouble));

        DoubleStream x = Arrays.stream(arrayDouble).onClose(() -> System.out.print("X fechou!!! "));
        DoubleStream y = DoubleStream.of(arrayDouble).onClose(() -> System.out.print("Y fechou!!!!! "));

        System.out.print("Fechando as streams --> ");
        x.close(); y.close();
        
    }
}
