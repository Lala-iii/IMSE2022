package com.imse.team015.api.dao;

import java.sql.*;

public class MYSQLUtils {
    private static final String url = "dbc:mysql://localhost:3306/bankapp";
    private static final String username = "admin";
    private static final String password = "admin";

    public static void ExecuteUpdate(String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
}
