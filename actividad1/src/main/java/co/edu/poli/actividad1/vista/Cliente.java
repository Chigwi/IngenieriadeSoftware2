package co.edu.poli.actividad1.vista;
import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Modelo.Titular;
import co.edu.poli.actividad1.Modelo.Pasaporte;
import co.edu.poli.actividad1.Modelo.Visa;
import co.edu.poli.actividad1.Repositorios.DatabaseConnection;
import co.edu.poli.actividad1.Repositorios.PasaporteDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    	/*String URL = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres";
	    String USER = "postgres.wndblehjsvhczsicivyf";
	    String PASSWORD = "Servidor123";*/
		
	    try(Connection conn = DatabaseConnection.getConnection()){
	    	
			ArrayList <Ciudad> ciudades = new ArrayList <Ciudad>();
			
			Ciudad medellin = new Ciudad ("medellin", "1", false );
			
			ciudades.add(medellin);
			
			Pais colombia = new Pais (1,"colombia","espaniol", ciudades);
			
			Titular Allyson = new Titular ("allyson velandia","14/04/2002", "1089765678");
			
			Pasaporte AlliePasport = new Pasaporte ("AX400", colombia, "14/08/2025", "14/08/2035", Allyson, medellin);
			
			//System.out.println(AlliePasport);
			
			PasaporteDao regPass = new PasaporteDao (conn);
			
			//System.out.println(regPass.insert(AlliePasport));
			System.out.println(regPass.select("AX400"));
			System.out.println(regPass.selectAll());
			
	    }catch(SQLException e) {
	    	
	    }

		
		
	}
	

}
