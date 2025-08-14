package co.edu.poli.actividad1.vista;
import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Modelo.Titular;
import co.edu.poli.actividad1.Modelo.Pasaporte;
import co.edu.poli.actividad1.Modelo.Visa;
import java.util.ArrayList;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//t
		
		ArrayList <Ciudad> ciudades = new ArrayList <Ciudad>();
		Ciudad medellin = new Ciudad ("medellin", "1", false );
		ciudades.add(medellin);
		
		Pais colombia = new Pais (1,"colombia","espaniol", ciudades);
		
		Titular Allyson = new Titular ("allyson velandia","14/04/2002", "1089765678");
		
		Pasaporte AlliePasport = new Pasaporte ("AX400", colombia, "14/08/2025", "14/08/2035", Allyson, medellin);
		
		System.out.println(AlliePasport);
		
		
	}
	

}
