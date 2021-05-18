package com.trepudox.jdbc.crudCompleto;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class App {

    private static void pulaTela() {
        for(int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    private static void fimOpcao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nINSIRA QUALQUER CARACTER PARA SAIR: ");
        scanner.next();
    }

    private static void fimETela() {
        fimOpcao();
        pulaTela();
    }

    private static void menu() {
        System.out.println();

        System.out.println("------------  MENU  ------------");
        System.out.println("0 - Sair");
        System.out.println("1 - Listar todos os elementos");
        System.out.println("2 - Listar algum elemento por ID");
        System.out.println("3 - Inserir um elemento");
        System.out.println("4 - Atualizar um elemento");
        System.out.println("5 - Excluir um elemento");
    }

    private static Pessoa instanciaPessoa() {
        Scanner scanner = new Scanner(System.in);
        String nome = "", cidade = "";
        int ano = 0, mes = 0, dia = 0;

        System.out.print("\nDIGITE O NOME DA PESSOA: ");
        nome = scanner.next();

        try{
            System.out.print("DIGITE O DIA DO ANIVERSÁIRO: ");
            dia = scanner.nextInt();

            System.out.print("DIGITE O MÊS DO ANIVERSÁRIO: ");
            mes = scanner.nextInt();

            System.out.print("DIGITE O ANO DO NASCIMENTO: ");
            ano = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("NÃO SE PODE INSERIR LETRAS OU CARACTERES ESPECIAIS EM CAMPOS NUMÉRICOS");
        }

        scanner.nextLine();
        System.out.print("DIGITE A CIDADE DA PESSOA: ");
        cidade = scanner.nextLine();

        LocalDate data = null;

        try {
            data = LocalDate.of(ano, mes, dia);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("DATA INVÁLIDA!");
        }

        if(data.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("A PESSOA NÃO PODE NASCER NO FUTURO!");

        Pessoa p = new Pessoa(nome, data, cidade);

        return p;
    }

    private static void cabecalhoPessoa() {
        System.out.printf("\nID      NOME%-12.12sDATANASC\t\tCIDADE\n", " ");
        System.out.println("—".repeat("ID      NOME%-12.12sDATANASC\t\tCIDADE".length() + 18));
    }

    public static void main(String[] args) {
        System.out.println("*** GERENCIAMENTO DO BANCO DE DADOS ***");
        Scanner scanner = new Scanner(System.in);
        Long opc = 0L;
        int escolha = 0;

        do {
            menu();
            System.out.print("ESCOLHA: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 0:
                    break;
                case 1:
                    cabecalhoPessoa();
                    for (Pessoa p : PessoaDAO.selectAll()) {
                        System.out.println(p);
                    }

                    fimETela();
                    break;

                case 2:
                    System.out.print("\nDIGITE O ID DO ELEMENTO QUE DESEJA BUSCAR: ");
                    opc = scanner.nextLong();

                    Optional<Pessoa> p = PessoaDAO.selectById(opc);
                    if(p.isEmpty()) {
                        System.err.println("\nNÃO EXISTE NENHUM ELEMENTO COM ESSE ID!\n");
                        fimETela();
                        break;
                    }

                    cabecalhoPessoa();
                    System.out.println(p.get());
                    fimETela();
                    break;

                case 3:
                    Pessoa pessoaInsert;
                    try {
                        pessoaInsert = instanciaPessoa();
                    } catch (IllegalArgumentException e) {
                        System.err.println("\n" + e.getMessage() + "\n");
                        fimETela();
                        break;
                    }

                    PessoaDAO.insert(pessoaInsert);
                    System.out.println("\nELEMENTO CADASTRADO COM SUCESSO!");
                    fimETela();
                    break;

                case 4:
                    System.out.print("\nDIGITE O ID DO ELEMENTO QUE DESEJA ATUALIZAR: ");
                    opc = scanner.nextLong();

                    Optional<Pessoa> optPessoaUpdate = PessoaDAO.selectById(opc);
                    if(optPessoaUpdate.isEmpty()) {
                        System.err.println("NÃO EXISTE NENHUM ELEMENTO COM ESSE ID.\n");
                        fimETela();
                        break;
                    }

                    Pessoa pessoaUpdate = instanciaPessoa();
                    pessoaUpdate.setId(opc);

                    PessoaDAO.update(pessoaUpdate);
                    System.out.println("\nELEMENTO ATUALIZADO COM SUCESSO!");
                    fimETela();

                    break;

                case 5:
                    System.out.print("\nDIGITE O ID DO ELEMENTO QUE DESEJA REMOVER: ");
                    opc = scanner.nextLong();

                    try{
                        PessoaDAO.delete(opc);
                    } catch (NullPointerException e) {
                        System.err.println(e.getMessage() + "\n");
                        fimETela();
                        break;
                    }


                    System.out.println("\nELEMENTO DELETADO COM SUCESSO!");
                    fimETela();
                    break;

                default:
                    System.err.println("\nOPÇÃO INVÁLIDA.\n");
                    fimETela();
            }
        } while (escolha != 0);

        pulaTela();
        System.out.println("FIM DA EXECUÇÃO DO PROGRAMA");
        fimOpcao();
    }
}
