package com.trepudox.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        // igual ao application.properties

        String url = "jdbc:mysql://localhost:3306/dio_teste?serverTimezone=UTC";
        String user = "root";
        String password = "SENHADOMYSQL";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Sucesso ao se conectar ao banco de dados");
        } catch(SQLException e) {
            System.out.println("Falha ao se conectar ao banco de dados.");
            e.printStackTrace();
        }


        //    System.out.println("Hello World!");
    }
}
