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
			ArrayList <Ciudad> ciudadesKorea = new ArrayList <Ciudad>();
			ArrayList <Ciudad> ciudadesMexico = new ArrayList <Ciudad>();
			ArrayList <Ciudad> gringos = new ArrayList <Ciudad>();
			
			VisaDao regVis = new VisaDao();
			
			regVis.setConnection(conn);
			
			
			
			//paises
			Pais colombia = new Pais ("1","colombia","espaniol", ciudades);
			
			Pais KoreadelNorte = new Pais ("148","Korea del Norte","koreano", ciudadesKorea);
			
			Pais Mexico = new Pais ("49","Mexico","Espannol", ciudadesMexico);
			
			Pais EstadosUnidos = new Pais ("104", "EstadosUnidos", "ingles",gringos);
		
			
			
			
			//estados unidos
			Ciudad Washington = new Ciudad ("0001", "washington", true,"104");
			
			Ciudad Miami = new Ciudad ("0002", "Miami", false, "104");
			
			Ciudad newYork = new Ciudad ("0003", "New York", false, "104");
			
			
			//mexico
			Ciudad CiudadDeMexico = new Ciudad ("0521", "Ciudad De mexico", true,"49");
			
			Ciudad Cancun = new Ciudad ("0522", "Cancun", false,"49");
			
			Ciudad Monterrey = new Ciudad ("0523", "Monterrey", false,"49");
			
			
			
			//colombia
			Ciudad Tunja = new Ciudad("0573", "Tunja", false, "1");
			
			Ciudad medellin = new Ciudad ("0572", "Medellin", false , "1");
			
			Ciudad Bogotá = new Ciudad("0571", "Bogotá", true, "1");
			
			ciudades.add(medellin);
			
			ciudades.add(Bogotá);
			
			//korea del norte
			
			Ciudad Pionyang = new Ciudad ("8501", "Pionyang", true,"148");
			
			Ciudad Sinuiju = new Ciudad ("8502", "Sinuiju", false,"148");
			
			Ciudad Haeju = new Ciudad ("8503", "Haeju", false,"148");
			
			regCiud.insert(Haeju);
			
		
			
			//gringos.add(Washington);
			
			//gringos.add(Miami);
			//gringos.add(newYork);
			
			
			//titulares
			
			Titular SalomeDorado = new Titular ("1023530646", "17/03/04", "SalomeDorado");
			
			Titular Allyson = new Titular ("1000034908","14/04/2002", "Allyson Velandia");
			
			
			//Pasaporte AlliePasport = new Pasaporte ("AX400", colombia, "14/08/2025", "14/08/2035", Allyson, medellin);
			
			//Pasaporte AlliePasporte = new Pasaporte ("AX400", colombia, "14/08/2025", "14/08/2045", Allyson, medellin);
			
			//Pasaporte SalomePasport = new Pasaporte ("A2004",EstadosUnidos,"25/08/25", "25/08/35",SalomeDorado,Washington );
			
			Titular Cristina = new Titular ("107678654","14/07/2001", "Cristina dorado");
			
			//Pasaporte CrisPasaport = new Pasaporte ("SD1500", EstadosUnidos, "14/07/2024", "14/07/2045", Cristina, Washington);
			
			Titular Sam = new Titular ("10105413","10/20/2005", "Samuel Arce");
			
			//Pasaporte SamPasaport = new Pasaporte ("AX1500", EstadosUnidos, "14/07/2024", "14/07/2045", Sam, Washington);
			
			//Visa v1 = new Visa ("VI001", EstadosUnidos,"28/08/2025","28/11/2025",AlliePasport);
			
			
			//Visa v2 = new Visa ("VI001", EstadosUnidos,"28/08/2025","28/08/2035",AlliePasport);
			
	
			
			//Visa v3 = new Visa ("VI002", EstadosUnidos,"28/08/2025","28/08/2035",SalomePasport);
			
		
			
			//Visa v4 = new Visa ("VI003", EstadosUnidos,"28/08/2025","28/08/2035",SalomePasport);
		
			
			
			
			//regCiud.insert(Tunja);
			
			//estado del arte
			
			
	    }catch(SQLException e) {
	    	
	    }

		
		
	}
	

}
