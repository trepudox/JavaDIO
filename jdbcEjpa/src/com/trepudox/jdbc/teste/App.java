package com.trepudox.jdbc.teste;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        // igual ao application.properties

        String url = "jdbc:mysql://localhost:3306/dio_teste?serverTimezone=UTC";
        String user = "root";
        String password = "SENHADOMYSQL";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("***CONECTADO AO BANCO DE DADOS***\n");

            PreparedStatement selectWhereId = connection.prepareStatement("SELECT * FROM pessoa");
            ResultSet resposta1 = selectWhereId.executeQuery();

            while(resposta1.next()) {
                System.out.println(resposta1.getString("nome"));
            }


        } catch(SQLException e) {
            e.printStackTrace();
        }


        //    System.out.println("Hello World!");
    }
}
