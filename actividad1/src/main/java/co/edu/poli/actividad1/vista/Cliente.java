package co.edu.poli.actividad1.vista;
import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Modelo.Titular;
import co.edu.poli.actividad1.Modelo.Pasaporte;
import co.edu.poli.actividad1.Repositorios.CiudadDao;
import co.edu.poli.actividad1.Repositorios.DatabaseConnection;
import co.edu.poli.actividad1.Repositorios.PaisDao;
import co.edu.poli.actividad1.Repositorios.PasaporteDao;
import co.edu.poli.actividad1.Repositorios.TitularDao;

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
			
			
			
			Ciudad medellin = new Ciudad ("0572", "Medellin", false );

			System.out.println(regCiud.select(medellin.getCodigoPostal()));
			
			ciudades.add(medellin);
			
			Pais colombia = new Pais ("1","colombia","espaniol", ciudades);
			
			//System.out.println(regPais.insert(colombia));
			
			//System.out.println(regPais.select(colombia.getIdPais()));
			

			Titular Allyson = new Titular ("1000034908","14/04/2002", "Allyson Velandia");
			//System.out.println(regtit.select(Allyson.getIdentificacion()));
			
			Pasaporte AlliePasport = new Pasaporte ("AX400", colombia, "14/08/2025", "14/08/2035", Allyson, medellin);
			
			Pasaporte AlliePasporte = new Pasaporte ("AX400", colombia, "14/08/2025", "14/08/2045", Allyson, medellin);
			
			//regPass.Delete(AlliePasport);
			
			//regPass.insert(AlliePasport);
			
			//System.out.println(AlliePasport);
			
			
			
			//System.out.println(regPass.insert(AlliePasport));
			
			System.out.println(regPass.select("AX400"));
			
			//System.out.println(regPass.Update(AlliePasporte));
			
			System.out.println(regPass.select("AX400"));
			
			//System.out.println(regPass.Delete(AlliePasporte));
			
			//System.out.println(regPass.insert(AlliePasport));
			
			Ciudad Washington = new Ciudad ("0001", "washington", true);
			
			System.out.println(regCiud.select(Washington.getCodigoPostal()));
			
			ArrayList <Ciudad> gringos = new ArrayList <Ciudad>();
			
			Pais EstadosUnidos = new Pais ("104", "EstadosUnidos", "ingles",gringos);
			
			System.out.println(regPais.select(EstadosUnidos.getIdPais()));
			
			Titular SalomeDorado = new Titular ("1023530646", "17/03/04", "SalomeDorado");
			
			System.out.println(regtit.select(SalomeDorado.getIdentificacion()));
			
			Pasaporte SalomePasport = new Pasaporte ("SD2004",EstadosUnidos,"25/08/25", "25/08/35",SalomeDorado,Washington );
			
			System.out.println(regPass.select(SalomePasport.getNumeroId()));
			
			System.out.println(regPass.selectAll());
			
			
	    }catch(SQLException e) {
	    	
	    }

		
		
	}
	

}
