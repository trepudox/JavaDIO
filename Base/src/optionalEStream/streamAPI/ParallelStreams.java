package optionalEStream.streamAPI;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ParallelStreams {
    public static void main(String[] args) {
        
        // Stream serial
        long inicio = System.currentTimeMillis();
        IntStream.range(1, 150000).forEach(ParallelStreams::fatorial);
        long fim = System.currentTimeMillis();
        System.out.println(String.format("Fim da execução com Stream normal: %dms", fim - inicio));
        


        // Stream paralela - parallel()
        inicio = System.currentTimeMillis();
        IntStream.range(1, 150000).parallel().forEach(ParallelStreams::fatorial);
        fim = System.currentTimeMillis();
        System.out.println(String.format("Fim da execução com Stream paralela: %dms", fim - inicio));

        // OU

        // parallelStream()
        Arrays.asList("Marco1", "Aurélio1", "Queiroz1", "Marco2", "Aurélio2", "Queiroz2", "Marco3", "Aurélio3", "Queiroz3").parallelStream().map((e) -> e + " ").forEach(System.out::print);

    }

    public static long fatorial(long n) {
        long fat = 1;

        for (int i = 2; i <= n; i++) {
            fat *= i;
        }

        return fat;
    }
}
