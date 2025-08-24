package co.edu.poli.actividad1.Repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    	private static final String URL = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres";
	    private static final String USER = "postgres.wndblehjsvhczsicivyf";
	    private static final String PASSWORD = "Servidor123";

	    public static Connection getConnection() {
	        Connection conn = null;
	        try {
	            // Cargar driver PostgreSQL
	            Class.forName("org.postgresql.Driver");

	            // Conexión a Supabase
	            conn = DriverManager.getConnection(URL, USER, PASSWORD);
	            System.out.println("Conexion exitosa!");
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println("Error de conexion: " + e.getMessage());
	        }
	        return conn;
	    }
	    public static void main(String[] args) {
	        DatabaseConnection.getConnection();
	    }

		
}
