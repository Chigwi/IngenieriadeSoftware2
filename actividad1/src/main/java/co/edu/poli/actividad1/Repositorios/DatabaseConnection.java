package co.edu.poli.actividad1.Repositorios;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://postgres:Servidor123@db.wndblehjsvhczsicivyf.supabase.co:5432/postgres";
        String user = "postgres";
        String password = "Servidor123";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
