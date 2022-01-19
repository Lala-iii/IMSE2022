package com.imse.team015.api.dao;

import java.sql.*;


public class MySQLUtils {
    public static final String base_url = "jdbc:mysql://db:3306/";
    public static final String url = base_url + "bankapp" ;
    public static final String username = "admin";
    public static final String password = "admin";

    public static void executeUpdate(String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();){
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try (Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();){
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public static void createDB() {
        try (Connection conn = DriverManager.getConnection(base_url, username, password);
            Statement session = conn.createStatement();){
            session.executeUpdate("CREATE DATABASE bankapp;");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
