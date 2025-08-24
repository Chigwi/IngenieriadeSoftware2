package co.edu.poli.actividad1.Repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        String host = "db.wndblehjsvhczsicivyf.supabase.co";
        String database = "postgres";
        String user = "postgres"; // From Supabase Database Settings
        String password = "Servidor123"; // From Supabase Database Settings

        String url = String.format("jdbc:postgresql://%s:5432/%s", host, database);

        try {
            Class.forName("org.postgresql.Driver");
            
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
