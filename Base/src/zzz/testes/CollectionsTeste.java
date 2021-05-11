package zzz.testes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsTeste {
    
    public static void main(String[] args) {
        List<String> listaString = new ArrayList<>();
        
        listaString.add("add");
        listaString.add("add5");
        listaString.add("add4");
        listaString.add("add2");
        listaString.add("add3");

        System.out.println(listaString);



        Map<String, String> usuarios = new HashMap<>();

        usuarios.put("ramvp", "duende10");
        usuarios.put("trepudox", "senha");

        String senha = "duende1";

        if(usuarios.get("ramvp").equals(senha)) {
            System.out.println("logado!");
        } else {
            System.out.println("deu errado!");
        }
        



        
        System.out.println(usuarios);
        
    }

    

}
