package cl.universidad.biblioteca.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // carga explícita
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL driver no encontrado en el classpath", e);
        }
    }

    private static final String URL  =
            "jdbc:mysql://localhost:3308/biblioteca";
    private static final String USER = "biblioteca";
    private static final String PASS = "biblioteca";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}