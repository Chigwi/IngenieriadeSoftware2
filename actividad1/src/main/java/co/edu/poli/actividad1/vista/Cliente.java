package co.edu.poli.actividad1.vista;
import co.edu.poli.actividad1.Modelo.Biometrico;
import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.ElementoSeguridad;
import co.edu.poli.actividad1.Modelo.MicroChip;
import co.edu.poli.actividad1.Modelo.PDiplomatico;
import co.edu.poli.actividad1.Modelo.PEmergencia;
import co.edu.poli.actividad1.Modelo.POrdinario;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Modelo.Titular;
import co.edu.poli.actividad1.Modelo.Visa;
import co.edu.poli.actividad1.Modelo.Pasaporte;
import co.edu.poli.actividad1.Repositorios.CiudadDao;
import co.edu.poli.actividad1.Repositorios.PaisDao;
import co.edu.poli.actividad1.Repositorios.PasaporteDao;
import co.edu.poli.actividad1.Repositorios.TitularDao;
import co.edu.poli.actividad1.Repositorios.VisaDao;
import co.edu.poli.actividad1.Servicios.AdaptadorTitular;
import co.edu.poli.actividad1.Servicios.Asistencia;
import co.edu.poli.actividad1.Servicios.DatabaseConnection;
import co.edu.poli.actividad1.Servicios.FactoriaFlyweight;
import co.edu.poli.actividad1.Servicios.Historial;
import co.edu.poli.actividad1.Servicios.POrdinarioBuilder;
import co.edu.poli.actividad1.Servicios.PasaporteTipo;
import co.edu.poli.actividad1.Servicios.Seguro;
import co.edu.poli.actividad1.Servicios.TitularWrapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Cliente {

	public static void main(String[] args) {
		
		try {
		
		/*DatabaseConnection db1 = DatabaseConnection.getInstance();
		
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
			
			*/
			
			ArrayList <Ciudad> ciudades = new ArrayList <Ciudad>();
			ArrayList <Ciudad> ciudadesKorea = new ArrayList <Ciudad>();
			
			/*
			Pais Mexico = new Pais ("49","Mexico","Espannol", ciudadesMexico);
			
			Pais EstadosUnidos = new Pais ("104", "EstadosUnidos", "ingles",gringos);
			*/
			
			
			/*
			//estados unidos
			Ciudad Washington = new Ciudad ("0001", "washington", true,"104");
			
			Ciudad Miami = new Ciudad ("0002", "Miami", false, "104");
			
			Ciudad newYork = new Ciudad ("0003", "New York", false, "104");
			
			
			//mexico
			Ciudad CiudadDeMexico = new Ciudad ("0521", "Ciudad De mexico", true,"49");
			
			Ciudad Cancun = new Ciudad ("0522", "Cancun", false,"49");
			
			Ciudad Monterrey = new Ciudad ("0523", "Monterrey", false,"49");
			*/
			
			
			//colombia
			//Ciudad Tunja = new Ciudad("0573", "Tunja", false, "1");
			
			//Ciudad medellin = new Ciudad ("0572", "Medellin", false , "1");
			
			Ciudad Bogotá = new Ciudad("0571", "Bogotá", true, "1");
			
			//ciudades.add(medellin);
			
			ciudades.add(Bogotá);
			
			//korea del norte
			
			//Ciudad Pionyang = new Ciudad ("8501", "Pionyang", true,"148");
			
			//Ciudad Sinuiju = new Ciudad ("8502", "Sinuiju", false,"148");
			
			Ciudad Haeju = new Ciudad ("8503", "Haeju", false,"148");
			
			ciudadesKorea.add(Haeju);
			
		
			
			//gringos.add(Washington);
			
			//gringos.add(Miami);
			//gringos.add(newYork);
			
			//paises
			Pais colombia = new Pais ("1","colombia","espaniol", ciudades);
			
			Pais KoreadelNorte = new Pais ("148","Korea","koreano", ciudadesKorea);
			
			//titulares
			
			Titular SalomeDorado = new Titular ("1023530646", "17/03/04", "SalomeDorado");
			
			Titular Allyson = new Titular ("1000034908","14/04/2002", "Allyson Velandia");
			
			
			//Pasaporte AlliePasport = new Pasaporte ("AX400", colombia, "14/08/2025", "14/08/2035", Allyson, medellin);
			
			
			
			//Titular Cristina = new Titular ("107678654","14/07/2001", "Cristina dorado");
			
			//Pasaporte CrisPasaport = new Pasaporte ("SD1500", EstadosUnidos, "14/07/2024", "14/07/2045", Cristina, Washington);
			
			//Titular Sam = new Titular ("10105413","10/20/2005", "Samuel Arce");
			
			//Pasaporte SamPasaport = new Pasaporte ("AX1500", EstadosUnidos, "14/07/2024", "14/07/2045", Sam, Washington);
			
			//Visa v1 = new Visa ("VI001", EstadosUnidos,"28/08/2025","28/11/2025",AlliePasport);
			
			
			//Visa v2 = new Visa ("VI001", EstadosUnidos,"28/08/2025","28/08/2035",AlliePasport);
			
	
			
			//Visa v3 = new Visa ("VI002", EstadosUnidos,"28/08/2025","28/08/2035",SalomePasport);
			
		
			
			//Visa v4 = new Visa ("VI003", EstadosUnidos,"28/08/2025","28/08/2035",SalomePasport);
		
			
			
			
			
			/*pruebas prototype y builder
			String RazonV = "Abrazar a kim";
			
			ElementoSeguridad el1 = new Biometrico("El1","alta seguridad","persona de alto riesgo","Huella Digital");
			String id = "AX400";
			Titular Sam = new Titular ("10105413","10/20/2005", "Samuel Arce");
			ArrayList <Ciudad> ciudadesKorea = new ArrayList <Ciudad>();
			Ciudad Pionyang = new Ciudad ("8501", "Pionyang", true,"148");
			Pais KoreadelNorte = new Pais ("148","Korea del Norte","koreano", ciudadesKorea);
			
			
			POrdinario p = new POrdinarioBuilder().agregarNumeroId(id)
			.agregarPaisEmisor(KoreadelNorte)
			.agregarFechaEmision("16-09-2025")
			.agregarFecharExpiracion("16-09-2035")
			.agregarTitular(Sam)
			.agregarCiudadEmision(Pionyang)
			.agregarRazonViaje(RazonV)
			.agregarElementoSeguridad(el1)
			.build();
			
			System.out.println(p);
			
		
			
			TitularWrapper t = new TitularWrapper(SalomeDorado);
			
			Titular clonSalo = t.clone();
			
			System.out.println(SalomeDorado);
			System.out.println(clonSalo);
			*/
			
			//pruebas bridge y decorator
			
			/*
			AdaptadorTitular Allie= new AdaptadorTitular(Allyson);
			Seguro alliesegura = new Seguro(Allie, "seguro de viajes");
			Asistencia allieasistida = new Asistencia(alliesegura, "apoyo emocional");
			System.out.println(allieasistida.getTitularDetallado());
			
			ArrayList <Ciudad> ciudades = new ArrayList <Ciudad>();
			
			Ciudad medellin = new Ciudad ("0572", "Medellin", false , "1");
			
			Ciudad Bogotá = new Ciudad("0571", "Bogotá", true, "1");
			
			ciudades.add(medellin);
			
			ciudades.add(Bogotá);
			
			Pais colombia = new Pais ("1","colombia","espaniol", ciudades);
			
			ElementoSeguridad bio = new Biometrico("AS400", "alta seguridad", "seguridad de identidad", "huella digital");
			
			Pasaporte AlliePasport = new PDiplomatico("AX400", colombia, "14/08/2025", "14/08/2035", Allyson, Bogotá, "negocios", bio);
			
			
			System.out.println("\n" + AlliePasport);*/
			
			/*Titular SalomeDorado = new Titular ("1023530646", "17/03/04", "SalomeDorado");
			AdaptadorTitular Salo = new AdaptadorTitular(SalomeDorado);
			Seguro saloB = new Seguro(Salo, "seguro de vida");
			Asistencia saloA = new Asistencia(saloB, "asistencia emocional");
			System.out.println(saloA.getTitularDetallado());*/
			
			/*Titular Allyson = new Titular ("1000034908","14/04/2002", "Allyson Velandia");
			AdaptadorTitular agent007 = new AdaptadorTitular(Allyson);
			Seguro saloB = new Seguro(agent007, "seguro de vida");
			Asistencia saloA = new Asistencia(saloB, "asistencia emocional");
			Historial salo1 = new Historial(saloA, "Brazil,Mexico");
			System.out.println(salo1.getTitularDetallado());
			
			ArrayList <Ciudad> ciudades = new ArrayList <Ciudad>();
			
			Ciudad medellin = new Ciudad ("0572", "Medellin", false , "1");
			
			Ciudad Bogotá = new Ciudad("0571", "Bogotá", true, "1");
			
			ciudades.add(medellin);
			
			ciudades.add(Bogotá);
			
			Pais colombia = new Pais ("1","colombia","espaniol", ciudades);
			
			ElementoSeguridad chip = new MicroChip("AS400", "alta seguridad", "seguridad de identidad", "huella digital");
			
			Pasaporte AlliePasport = new PEmergencia ("AX400", colombia, "14/08/2025", "14/08/2035", Allyson, Bogotá, chip, "17/06/25");
			
			
			System.out.println("\n" + AlliePasport);*/
			
			//regCiud.insert(Tunja);
			
			//estado del arte
			
			//spp
			
			
			
			HashMap<String, PasaporteTipo> r = new HashMap<String, PasaporteTipo>();
			FactoriaFlyweight.setMapaTipos(r);
			
			
			
			PasaporteTipo col = new PasaporteTipo("Vino tinto", "Español", "Colombia");
			PasaporteTipo arg = new PasaporteTipo("Azul oscuro", "Koreano", "Korea");
			
			//System.out.println(FactoriaFlyweight.getMapaTipos().toString()); 
			ElementoSeguridad bio = new Biometrico("AS400", "alta seguridad", "seguridad de identidad", "huella digital");
			
			Pasaporte AlliePasport = new PDiplomatico("AX400", colombia, "14/08/2025", "14/08/2035", Allyson, Bogotá, "negocios", bio);	
			
			Titular kairi = new Titular("56468464", "13/10/1998", "Kairi");
			
			Pasaporte KairiPasport = new PDiplomatico("AX300", KoreadelNorte, "14/08/2025", "14/08/2035", kairi, Haeju, "negocios", bio);	
			
			
			
			System.out.println(FactoriaFlyweight.getMapaTipos().get("Colombia"));
			System.out.println(FactoriaFlyweight.getMapaTipos().get("Korea"));
			System.out.println(FactoriaFlyweight.mostrarDetalles(KairiPasport));
			
		
			
	    }catch(Exception e) {
	    	
	    }
		
		

	}
}
	
