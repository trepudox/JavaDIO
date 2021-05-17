package com.trepudox.jdbc.testeElaborado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String driver = "mysql";
    private static final String enedreco = "localhost";
    private static final String porta = "3306";
    private static final String database = "dio_teste?serverTimezone=UTC";

    private static final String username = "root";
    private static final String password = "SENHADOMYSQL";
    private static final String url = String.format("jdbc:%s://%s:%s/%s", driver, enedreco, porta, database);

    private ConnectionFactory() {}

    public static Connection getConnection() {
        Connection connection = null;

        try {
            System.out.println("\n*** CONECTADO AO BANCO DE DADOS ***\n");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("\n*** FALHA AO SE CONCECTAR AO BANCO DE DADOS ***\n");
            e.printStackTrace();
        }

        return connection;
    }
}
