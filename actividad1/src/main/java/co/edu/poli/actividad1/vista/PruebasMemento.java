package co.edu.poli.actividad1.vista;

import java.util.ArrayList;

import co.edu.poli.actividad1.Modelo.Biometrico;
import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.ElementoSeguridad;
import co.edu.poli.actividad1.Modelo.PDiplomatico;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Modelo.Pasaporte;
import co.edu.poli.actividad1.Modelo.Titular;
import co.edu.poli.actividad1.Servicios.AdaptadorPasaporte;
import co.edu.poli.actividad1.Servicios.CareTaker;
import co.edu.poli.actividad1.Servicios.ConcreteMemento;
import co.edu.poli.actividad1.Servicios.PasaporteOriginator;

public class PruebasMemento {

	public static void main(String[] args) {
	
		ArrayList <Ciudad> ciudades = new ArrayList <Ciudad>();
		ArrayList <Ciudad> ciudadesKorea = new ArrayList <Ciudad>();
		
		Ciudad Bogotá = new Ciudad("0571", "Bogotá", true, "1");
		Ciudad Haeju = new Ciudad ("8503", "Haeju", false,"148");
		
		ciudades.add(Bogotá);
		ciudadesKorea.add(Haeju);
		
		Pais colombia = new Pais ("1","colombia","espaniol", ciudades);
		Pais KoreadelNorte = new Pais ("148","Korea","koreano", ciudadesKorea);
		
		Titular SalomeDorado = new Titular ("1023530646", "17/03/04", "SalomeDorado");
		Titular Allyson = new Titular ("1000034908","14/04/2002", "Allyson Velandia");

		ElementoSeguridad bio = new Biometrico("AS400", "alta seguridad", "seguridad de identidad", "huella digital");

		Pasaporte AlliePasport = new PDiplomatico("AX400", colombia, "14/08/2025", "14/08/2035", Allyson, Bogotá, "negocios", bio);	

		Titular kairi = new Titular("56468464", "13/10/1998", "Kairi");

		Pasaporte KairiPasport = new PDiplomatico("AX300", KoreadelNorte, "14/08/2025", "14/08/2035", kairi, Haeju, "negocios", bio);	
		
		
		PasaporteOriginator Allie = new PasaporteOriginator(AlliePasport);
		
		CareTaker historial = new CareTaker();
		
		ConcreteMemento meme = Allie.createMemento();
		
		historial.addMemento(1,meme);
		
		System.out.println(Allie.restore((ConcreteMemento) historial.getMemento(1)) + "debe decir Allyson");
		
		Allie.getState().setTitular(kairi);
		
		System.out.println(Allie + "\n debe decir Allyson aqui");
		
		System.out.println(historial.getMemento(1));
		
		Allie.getState().getTitular().setNombre("Allie");
		
		ConcreteMemento r2 = Allie.createMemento();
		
		historial.addMemento(2, r2);
		
		System.out.println(Allie.restore((ConcreteMemento) historial.getMemento(2)));
	}

}
