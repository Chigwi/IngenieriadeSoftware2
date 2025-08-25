package co.edu.poli.actividad1.vista;
import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Modelo.Titular;
import co.edu.poli.actividad1.Modelo.Pasaporte;
import co.edu.poli.actividad1.Repositorios.CiudadDao;
import co.edu.poli.actividad1.Repositorios.PaisDao;
import co.edu.poli.actividad1.Repositorios.PasaporteDao;
import co.edu.poli.actividad1.Repositorios.TitularDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cliente {

	public final static String  url ="jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres";
	
	public final static String user = "postgres.wndblehjsvhczsicivyf";
	
	public final static String Password = "Servidor123";
	
	public static String getUrl() {
		return url;
	}

	public static String getUser() {
		return user;
	}

	public static String getPassword() {
		return Password;
	}

	public static void main(String[] args) {
		
	    try(Connection conn = DriverManager.getConnection(Cliente.getUrl(),Cliente.getUser(),Cliente.getPassword())){
	    	
	    	
	    	PasaporteDao regPass = new PasaporteDao (conn);
	    	
	    	CiudadDao regCiud = new CiudadDao(conn);
	    	
	    	PaisDao regPais = new PaisDao(conn);
	    	
	    	TitularDao regtit = new TitularDao(conn);
	    	
			ArrayList <Ciudad> ciudades = new ArrayList <Ciudad>();
			
			Ciudad medellin = new Ciudad ("medellin", "1", false );
			
			System.out.println(regCiud.select(medellin.getCodigoPostal()));
			
			ciudades.add(medellin);
			
			Pais colombia = new Pais (1,"colombia","espaniol", ciudades);
			
			String idp = Integer.toString(colombia.getIdPais());
			
			System.out.println(regPais.select(idp));
			
			Titular Allyson = new Titular ("allyson velandia","14/04/2002", "1089765678");
			
			System.out.println(regtit.select(Allyson.getIdentificacion()));
			
			Pasaporte AlliePasport = new Pasaporte ("AX400", colombia, "14/08/2025", "14/08/2035", Allyson, medellin);
			
			Pasaporte AlliePasporte = new Pasaporte ("AX400", colombia, "14/08/2025", "14/08/2045", Allyson, medellin);
			
			//System.out.println(AlliePasport);
			
			
			
			//System.out.println(regPass.insert(AlliePasport));
			
			System.out.println(regPass.select("AX400"));
			
			System.out.println(regPass.Update(AlliePasporte));
			
			System.out.println(regPass.select("AX400"));
			
			System.out.println(regPass.Delete(AlliePasporte));
			
			System.out.println(regPass.insert(AlliePasport));
	    }catch(SQLException e) {
	    	
	    }

		
		
	}
	

}
