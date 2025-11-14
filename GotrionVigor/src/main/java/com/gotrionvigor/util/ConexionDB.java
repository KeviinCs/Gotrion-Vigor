package com.gotrionvigor.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/gotrionvigor_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "7009";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver de MySQL: " + e.getMessage());
            return null;

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        if (getConnection() != null) {
            System.out.println("Conexión exitosa!");
        } else {
            System.out.println("No se pudo conectar");
        }
    }
}

