package com.gotrionvigor.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/gotrionvigor_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
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
