package com.imse.team015.api.dao;

import java.sql.*;

public class MySQLUtils {
    private static final String base_url = "dbc:mysql://localhost:3306/";
    private static final String url = base_url + "bankapp" ;
    private static final String username = "root";
    private static final String password = "";

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

    public static void createDB() {
        try (Connection conn = DriverManager.getConnection(base_url, username, password)){
            Statement session = conn.createStatement();
            session.executeUpdate("CREATE DATABASE bankapp;");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
