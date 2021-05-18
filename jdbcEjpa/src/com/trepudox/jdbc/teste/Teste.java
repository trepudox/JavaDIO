package com.trepudox.jdbc.teste;

import java.sql.*;
import java.time.LocalDate;

public class Teste {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/dio_teste?serverTimezone=UTC";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, user, password);

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pessoa;");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            System.out.print(rs.getLong("id") + " ");
            System.out.print(rs.getString("nome") + " ");
            System.out.print(rs.getObject("dataNasc", LocalDate.class) + " ");
            System.out.println(rs.getString("cidade"));
        }



    }
}
