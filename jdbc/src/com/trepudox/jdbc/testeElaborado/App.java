package com.trepudox.jdbc.testeElaborado;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        System.out.println(PessoaDAO.selectAll());
//        Pessoa p = new Pessoa("Ricardo", LocalDate.of(2002, 10, 07), "São Paulo");
//        PessoaDAO.insert(p);
        System.out.println(PessoaDAO.selectById(1L));
    }
}
