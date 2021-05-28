package zzz.testes;

import java.util.Optional;

import collectionsEMap.classeArrayList.Pessoa;

public class App2 {
    public static void main(String[] args) {
        Optional<Pessoa> pessoaOpt = Optional.of(new Pessoa("Marco", 18));
        Pessoa pessoaNormal = new Pessoa("Marco", 18);

        System.out.println(pessoaOpt);
        System.out.println(pessoaNormal);

        


//        System.out.println(opt1);
 //       System.out.println(opt2);
   //     System.out.println(opt3.get());

//        System.out.println(opt3.orElse("teste"));
    }
}
