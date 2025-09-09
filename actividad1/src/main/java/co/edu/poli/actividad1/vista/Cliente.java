package co.edu.poli.actividad1.vista;
import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Modelo.Titular;
import co.edu.poli.actividad1.Modelo.Visa;
import co.edu.poli.actividad1.Modelo.Pasaporte;
import co.edu.poli.actividad1.Repositorios.CiudadDao;
import co.edu.poli.actividad1.Repositorios.PaisDao;
import co.edu.poli.actividad1.Repositorios.PasaporteDao;
import co.edu.poli.actividad1.Repositorios.TitularDao;
import co.edu.poli.actividad1.Repositorios.VisaDao;
import co.edu.poli.actividad1.Servicios.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cliente {

	public static void main(String[] args) {
		
		DatabaseConnection db1 = DatabaseConnection.getInstance();
		
	    try(Connection conn = db1.getConnection()){
	    	
	    	
	    	PasaporteDao regPass = new PasaporteDao ();
	    	
	    	regPass.setConnection(conn);
	    	
	    	CiudadDao regCiud = new CiudadDao();
	    	
	    	regCiud.setConnection(conn);
	    	
	    	PaisDao regPais = new PaisDao();
	    	
	    	regPais.setConnection(conn);
	    	
	    	TitularDao regtit = new TitularDao();
	    	
	    	regtit.setConnection(conn);
	    	
			ArrayList <Ciudad> ciudades = new ArrayList <Ciudad>();
			
			VisaDao regVis = new VisaDao();
			
			regVis.setConnection(conn);
			
			
			Ciudad medellin = new Ciudad ("0572", "Medellin", false , "1");
			
			Ciudad Bogotá = new Ciudad("0571", "Bogotá", true, "1");

			
			
			ciudades.add(medellin);
			
			ciudades.add(Bogotá);
			
			Pais colombia = new Pais ("1","colombia","espaniol", ciudades);
			
		
			

			Titular Allyson = new Titular ("1000034908","14/04/2002", "Allyson Velandia");
			
			
			//Pasaporte AlliePasport = new Pasaporte ("AX400", colombia, "14/08/2025", "14/08/2035", Allyson, medellin);
			
			//Pasaporte AlliePasporte = new Pasaporte ("AX400", colombia, "14/08/2025", "14/08/2045", Allyson, medellin);
			
			
			
			
			
			
			
			Ciudad Washington = new Ciudad ("0001", "washington", true,"104");
			
			Ciudad Miami = new Ciudad ("0002", "Miami", false, "104");
			
			
			
			ArrayList <Ciudad> gringos = new ArrayList <Ciudad>();
			
			//gringos.add(Washington);
			
			gringos.add(Miami);
			
			Pais EstadosUnidos = new Pais ("104", "EstadosUnidos", "ingles",gringos);
			
			
			
			Titular SalomeDorado = new Titular ("1023530646", "17/03/04", "SalomeDorado");
			
			
			
			//Pasaporte SalomePasport = new Pasaporte ("A2004",EstadosUnidos,"25/08/25", "25/08/35",SalomeDorado,Washington );
			
			
			//Visa v1 = new Visa ("VI001", EstadosUnidos,"28/08/2025","28/11/2025",AlliePasport);
			
			
			//Visa v2 = new Visa ("VI001", EstadosUnidos,"28/08/2025","28/08/2035",AlliePasport);
			
	
			
			//Visa v3 = new Visa ("VI002", EstadosUnidos,"28/08/2025","28/08/2035",SalomePasport);
			
		
			
			//Visa v4 = new Visa ("VI003", EstadosUnidos,"28/08/2025","28/08/2035",SalomePasport);
			
			
			
			ArrayList <Ciudad> ciudades1 = new ArrayList <Ciudad>();
			
			
			Titular Cristina = new Titular ("107678654","14/07/2001", "Cristina dorado");
			
			//Pasaporte CrisPasaport = new Pasaporte ("SD1500", EstadosUnidos, "14/07/2024", "14/07/2045", Cristina, Washington);
			
			Titular Sam = new Titular ("10105413","10/20/2005", "Samuel Arce");
			
			//Pasaporte SamPasaport = new Pasaporte ("AX1500", EstadosUnidos, "14/07/2024", "14/07/2045", Sam, Washington);
			
			
		
			
			Ciudad Tunja = new Ciudad("0573", "Tunja", false, "1");
			
			regCiud.insert(Tunja);
			
			
	    }catch(SQLException e) {
	    	
	    }

		
		
	}
	

}
