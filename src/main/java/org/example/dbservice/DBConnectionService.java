package org.example.dbservice;

import java.sql.*;

public class DBConnectionService {

    final String jdbcUrl = "jdbc:postgresql://localhost:5432/companyDB";
    final String username = "postgres";
    final String password = "stud";

    Connection connection;

    private static DBConnectionService instance;

    private DBConnectionService() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        }
    }

    public static DBConnectionService getInstance() {
        if (instance == null)
            instance = new DBConnectionService();
        return instance;
    }

    public Statement createStatement() {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
