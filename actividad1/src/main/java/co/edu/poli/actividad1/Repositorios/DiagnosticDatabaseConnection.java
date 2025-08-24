package co.edu.poli.actividad1.Repositorios;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DiagnosticDatabaseConnection {
    public static void main(String[] args) {
    	
    	
        DatabaseConnection.getConnection();
    	
        /*String host = "db.wndblehjsvhczsicivyf.supabase.co";
        String database = "postgres";
        String user = "postgres";
        String password = "Servidor123";

        try {
            // Network Diagnostics
            System.out.println("Resolving Host: " + host);
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress addr : addresses) {
                System.out.println("Resolved IP: " + addr.getHostAddress());
            }

            // Detailed Connection Properties
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            props.setProperty("ssl", "true");
            props.setProperty("sslmode", "require");
            
            // Connection URL with detailed parameters
            String url = String.format("jdbc:postgresql://%s:5432/%s", host, database);
            
            System.out.println("Attempting Connection to: " + url);
            
            // Attempt Connection
            try (Connection conn = DriverManager.getConnection(url, props)) {
                System.out.println("Successfully Connected to Database!");
                System.out.println("Connection Details:");
                System.out.println("Catalog: " + conn.getCatalog());
                System.out.println("Auto-commit: " + conn.getAutoCommit());
            }
        } catch (Exception e) {
            System.err.println("Connection Diagnostic Failed:");
            e.printStackTrace();
        }*/
    }
}