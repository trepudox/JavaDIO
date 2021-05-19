package com.trepudox.jpaEhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("trepudox-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("Objeto original: ");
        System.out.println(entityManager.find(PessoaModel.class, 1));

        System.out.println("\n*** COMEÇO DA TRANSACTION ***\n");
        entityManager.getTransaction().begin();

        System.out.println("Alterando os dados do objeto: ");
        PessoaModel p = entityManager.find(PessoaModel.class, 1);
        p.setNome("NÃO É O MARCO"); p.setCidade("SÃO PAULO");
        System.out.println(p);

        System.out.println("Excluindo o objeto printado e tentando printá-lo de novo: ");
        entityManager.remove(p);
        System.out.println(entityManager.find(PessoaModel.class, 1));

        entityManager.getTransaction().rollback();
        System.out.println("\n*** FIM DA TRANSACTION, EXECUTANDO ROLLBACK ***\n");

        System.out.println(entityManager.find(PessoaModel.class, 1));

    }
}
