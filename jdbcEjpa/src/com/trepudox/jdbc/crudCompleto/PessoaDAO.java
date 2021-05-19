package com.trepudox.jdbc.crudCompleto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaDAO {

    public static List<Pessoa> selectAll() {
        List<Pessoa> lista =  new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pessoa;");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                LocalDate dataNasc = rs.getObject("dataNasc", LocalDate.class);
                String cidade =  rs.getString("cidade");

                lista.add(new Pessoa(id, nome, dataNasc, cidade));
            }
        } catch (SQLException e) {
            System.err.println("\nselectAll falhou!\n");
            e.printStackTrace();
        }

        return lista;
    }

    public static Optional<Pessoa> selectById(Long id) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pessoa WHERE id = ?");
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            rs.next();

            if(rs.getString("nome") == null)
                return Optional.empty();

            String nome = rs.getString("nome");
            LocalDate data = rs.getObject("dataNasc", LocalDate.class);
            String cidade = rs.getString("cidade");

            Pessoa p = new Pessoa(id, nome, data, cidade);
            return Optional.of(p);
        } catch (SQLException e) {
            if(!e.getMessage().equals("Illegal operation on empty result set.")) {
                System.err.println("\nselectById falhou!\n");
                e.printStackTrace();
            }

            return Optional.empty();
        }
    }

    public static Optional<Pessoa> insert(Pessoa pessoa) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO pessoa(nome, dataNasc, cidade) VALUES " +
                    "(?, ?, ?);");
            stmt.setString(1, pessoa.getNome());
            stmt.setObject(2, pessoa.getDataNasc());
            stmt.setString(3, pessoa.getCidade());

            stmt.executeUpdate();
            return Optional.of(pessoa);
        } catch (SQLException e) {
            System.err.println("\nFalha no insert!\n");
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public static Optional<Pessoa> update(Pessoa pessoa) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("UPDATE pessoa SET nome = ?, dataNasc = ?, cidade = ?" +
                    "WHERE id = ?");
            stmt.setString(1, pessoa.getNome());
            stmt.setObject(2, pessoa.getDataNasc());
            stmt.setString(3, pessoa.getCidade());
            Long idPessoa = pessoa.getId();
            stmt.setLong(4, idPessoa);

            stmt.executeUpdate();

            return selectById(idPessoa);
        } catch (SQLException e) {
            System.err.println("\nupdate falhou!\n");
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public static Optional<Pessoa> delete(Long id) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            Optional<Pessoa> p = selectById(id);
            if (p.isEmpty())
                throw new NullPointerException("Uma pessoa com esse ID não existe!");

            PreparedStatement stmt = connection.prepareStatement("DELETE FROM pessoa WHERE id = ?;");
            stmt.setLong(1, id);

            stmt.executeUpdate();

            return p;
        } catch (SQLException e) {
            System.err.println("\ndelete falhou!\n");
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
