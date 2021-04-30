package collectionsEMap.classeMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AppHashMap {
    public static void main(String[] args) {
        Map<String, String> tbUsuarios = new HashMap<>();

        //put serve para inserir ou atualizar os dados, igual o verbo HTTP
        tbUsuarios.put("LucasPena", "paraiba2012");
        tbUsuarios.put("Ramvp", "duende10");
        tbUsuarios.put("shiriguidum", "pijama1515");
        tbUsuarios.put("leandro1100", "pipasinsano110");
        System.out.println(tbUsuarios);
        
        //insere sem atualizar
        tbUsuarios.putIfAbsent("Ramvp", "arroz");
        System.out.println(tbUsuarios);
        
        //usando um parâmetro só esse método remove a chave e seu valor,
        //já usando dois parâmetros esse metódo removerá a chave e seu valor APENAS se os valores forem iguais aos passados
        tbUsuarios.remove("Ramvp", "duende10");
        System.out.println(tbUsuarios);

        System.out.println("\nEsse map contem a chave 'leandro1100'? " + (tbUsuarios.containsKey("leandro1100") ? "Sim" : "Não"));
        System.out.println("Esse map contem o valor 'paraiba2012'? " + (tbUsuarios.containsValue("paraiba2012") ? "Sim" : "Não"));

        System.out.println("\nNAVEGAÇÃO: ");
        for (Map.Entry<String, String> valores : tbUsuarios.entrySet()) {
            System.out.println("--> " + valores.getKey() + ":" + valores.getValue());
        }

        Set<Map.Entry<String, String>> set = tbUsuarios.entrySet();

        //System.out.println(set);

        System.out.println("\nNAVEGAÇÃO 2: ");
        for (Map.Entry<String, String> entry : set) {
            System.out.println("--> " + entry.getKey() + ":" + entry.getValue());
        }

    }
}
