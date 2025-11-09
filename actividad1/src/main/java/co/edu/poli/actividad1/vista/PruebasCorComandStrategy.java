package co.edu.poli.actividad1.vista;

import java.sql.Connection;
import java.util.ArrayList;

import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.MicroChip;
import co.edu.poli.actividad1.Modelo.PDiplomatico;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Modelo.Titular;
import co.edu.poli.actividad1.Repositorios.PasaporteDao;
import co.edu.poli.actividad1.Servicios.AdaptadorPasaporte;
import co.edu.poli.actividad1.Servicios.Asesor;
import co.edu.poli.actividad1.Servicios.CertificarBiometria;
import co.edu.poli.actividad1.Servicios.CertificarBlockChain;
import co.edu.poli.actividad1.Servicios.CertificarMicroChip;
import co.edu.poli.actividad1.Servicios.CommandManager;
import co.edu.poli.actividad1.Servicios.CommandValidarFecha;
import co.edu.poli.actividad1.Servicios.CommandValidarTipo;
import co.edu.poli.actividad1.Servicios.CommandValidarTitular;
import co.edu.poli.actividad1.Servicios.DatabaseConnection;
import co.edu.poli.actividad1.Servicios.RelacionesExteriores;
import co.edu.poli.actividad1.Servicios.Supervisor;
import co.edu.poli.actividad1.Servicios.Validacion;

public class PruebasCorComandStrategy {
	
	public static void main (String[] args) {
		
		//pruebas Handler
		
		String sol = "";
		
		Integer in = 6;
		
		Asesor as = new Asesor();
		
		Asesor as1 = new Asesor();
		
		as.setNextHandler(as1);
		
		Supervisor sup = new Supervisor();
		
		as1.setNextHandler(sup);
		
		RelacionesExteriores ministro = new RelacionesExteriores();
		
		sup.setNextHandler(ministro);
		
		System.out.println(as.manejarSolicitud(in, sol));
		
		//pruebas Strategy
		
		ArrayList<String> paises = new ArrayList<String>();
		
		paises.add("Colombia");
		paises.add("EstadosUnidos");
		paises.add("Korea del Norte");
		paises.add("Mexico");
		paises.add("Peru");
		
		CertificarBiometria cert = new CertificarBiometria();
		
		CertificarBlockChain cert1 = new CertificarBlockChain();
		
		CertificarMicroChip cert2 = new CertificarMicroChip();
		
		System.out.println("Biometria \n" + cert.certificar(paises) + "\n");
		
		System.out.println("Blockchain \n" + cert1.certificar(paises) + "\n");
		
		System.out.println("Microchip \n" + cert2.certificar(paises) + "\n");
		
		//pruebas Command
		
		DatabaseConnection db1 = DatabaseConnection.getInstance();
		
	    try(Connection conn = db1.getConnection()){
	    	
	    	PasaporteDao regPass = new PasaporteDao ();
	    	regPass.setConnection(conn);
	    	
	    	Validacion val = new Validacion(regPass);
	    	
	    	String fecha ="2026-09-05";
	    	
	    	String tipo = "ordinario";
	    	
	    	ArrayList <Ciudad> ciudades = new ArrayList <Ciudad>();

	    	Ciudad Bogotá = new Ciudad("0571", "Bogotá", true, "1");
			
			ciudades.add(Bogotá);
	    	
	    	Pais colombia = new Pais ("1","colombia","espaniol", ciudades);
	    	
	    	Titular SalomeDorado = new Titular ("1023530646", "17/03/04", "SalomeDorado");
	    	
	    	MicroChip chip = new MicroChip("MQ7668", "alta seguridad", "seguridad de identidad", "huella digital");
	    	
	    	PDiplomatico AlliePasport = new PDiplomatico("MQ7668", colombia, "14/08/2025", "14/08/2035", SalomeDorado, Bogotá, "negocios", chip);
	    	
	    	AdaptadorPasaporte ad = new AdaptadorPasaporte(AlliePasport);
	    	
	    	CommandValidarFecha fech = new CommandValidarFecha(val, fecha);
	    	
	    	CommandValidarTipo tip = new CommandValidarTipo(tipo, val, ad);
	    	
	    	CommandValidarTitular tit = new CommandValidarTitular(AlliePasport, val);
	    	
	    	CommandManager man = new CommandManager(fech);
	    	
	    	System.out.println(man.execute());
	    	
	    	man.setCommand(tip);
	    	
	    	System.out.println(man.execute());
	    	
	    	man.setCommand(tit);
	    	
	    	System.out.println(man.execute());
	    	
	    	
	    }catch(Exception e) {
	    	
	    }
	}

}
