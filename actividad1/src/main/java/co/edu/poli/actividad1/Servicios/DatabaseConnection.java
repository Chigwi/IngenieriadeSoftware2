package co.edu.poli.actividad1.Servicios;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class DatabaseConnection {
	
	private static DatabaseConnection instance;
    
    private Connection connection;
    
    private DatabaseConnection() {
        try {
            Properties props = new Properties();
            // Load properties file from classpath
            try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
                if (input == null) {
                    System.out.println("Sorry, unable to find database.properties");
                    return;
                }
                props.load(input);
            } catch (IOException ex) {
                System.out.println("Error loading properties file: " + ex.getMessage());
                return;
            }
            // Read properties
            String url = props.getProperty("database.url");
            // For username and password, resolve environment variables if placeholders are used
            String username = props.getProperty("database.username");
            String password = props.getProperty("database.password");
            // Optional: Replace placeholders with environment variables if needed
            username = resolveEnvVariable(username);
            password = resolveEnvVariable(password);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error de conexion " + e.getMessage());
        }
    }
    //teta
    private String resolveEnvVariable(String value) {
        if (value != null && value.startsWith("${") && value.endsWith("}")) {
            String envVar = value.substring(2, value.length() - 1);
            String envValue = System.getenv(envVar);
            if (envValue != null) {
                return envValue;
            } else {
                System.out.println("Environment variable " + envVar + " not set.");
                return "";
            }
        }
        return value;
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
