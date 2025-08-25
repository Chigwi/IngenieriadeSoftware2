package co.edu.poli.actividad1.Repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	 private static DatabaseConnection instance;
	 
	private static final String URL = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres";
	
    private static final String USER = "postgres.wndblehjsvhczsicivyf";
    
    private static final String PASSWORD = "Servidor123";
    
    private Connection connection;
    
    private DatabaseConnection() {
    	try {
    		connection = DriverManager.getConnection(URL, USER, PASSWORD);
    	}catch(SQLException e){
    		System.out.println("Error de conexion " + e.getMessage());
    	}
    }
    
    public static DatabaseConnection getInstance() {
    	if (instance == null) {
    		instance = new DatabaseConnection();
    		//return instance;
    	}
    	return instance;	
    }

    public Connection getConnection() {
        return connection;
    }
	
}
