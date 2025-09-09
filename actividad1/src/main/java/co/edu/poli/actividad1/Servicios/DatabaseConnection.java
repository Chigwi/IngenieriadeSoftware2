package co.edu.poli.actividad1.Servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static DatabaseConnection instance;
    
    private Connection connection;
    
    private DatabaseConnection() {
    	try {
    		
    		String URL = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres";
    		
    		String USER = "postgres.wndblehjsvhczsicivyf";
    	    
    		String PASSWORD = "Servidor123";
    		
    		connection = DriverManager.getConnection(URL, USER, PASSWORD);
    		
    	}catch(SQLException e){
    		System.out.println("Error de conexion " + e.getMessage());
    	}
    }
    
    public static DatabaseConnection getInstance() {
    	if (instance == null) {
    		instance = new DatabaseConnection();
    	}
    	return instance;	
    }

    public Connection getConnection() {
        return connection;
    }
	
}
