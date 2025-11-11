package co.edu.poli.actividad1.vista;

import java.util.ArrayList;

import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Servicios.AdaptadorPais;
import co.edu.poli.actividad1.Servicios.Cancilleria;
import co.edu.poli.actividad1.Servicios.ComponenteP;
import co.edu.poli.actividad1.Servicios.ConcreteMediador;
import co.edu.poli.actividad1.Servicios.EstadoNormal;
import co.edu.poli.actividad1.Servicios.EstadoRevision;
import co.edu.poli.actividad1.Servicios.FronteraCerrada;
import co.edu.poli.actividad1.Servicios.Migracion;
import co.edu.poli.actividad1.Servicios.Policia;
import co.edu.poli.actividad1.Servicios.SolicitudVisa;

public class pruebasMediatorState {
	
	
	public static void main (String [] args) {
		/*
		//pruebas mediator
		
		ConcreteMediador con = new ConcreteMediador();
		
		Cancilleria can = new Cancilleria(con);
		Policia pol = new Policia(con);
		Migracion mig = new Migracion(con);
		ComponenteP com = new ComponenteP(con);
		System.out.println("cancilleria : \n "+con.notificar(can));
		System.out.println("policia : \n "+con.notificar(pol));
		System.out.println("migracion : \n "+con.notificar(mig));
		System.out.println("pasaporte : \n "+con.notificar(com));
		*/
		/*
		//pruebas state
		
		ArrayList <Ciudad> ciudades = new ArrayList <Ciudad>();

    	Ciudad Bogotá = new Ciudad("0571", "Bogotá", true, "1");
		
		ciudades.add(Bogotá);
    	
    	Pais colombia = new Pais ("1","colombia","espaniol", ciudades);
    	
    	EstadoNormal norm = new EstadoNormal();
    	
    	EstadoRevision rev = new EstadoRevision();
    	
    	SolicitudVisa sol = new SolicitudVisa();
    	
    	FronteraCerrada fron = new FronteraCerrada();
    	
    	AdaptadorPais adapais = new AdaptadorPais(colombia, norm);
    	
    	System.out.println("Cambio de normal a revision \n Debe ser exitoso: " + adapais.cambiarEstado(rev));
    	
    	System.out.println("Cambio de revision a solicitud \n Debe ser exitoso: " + adapais.cambiarEstado(sol));
    	
    	System.out.println("Cambio de solicitud a frontera \n Debe ser exitoso: " + adapais.cambiarEstado(fron));
    	
    	System.out.println("Cambio de frontera a normal \n Debe ser exitoso: " + adapais.cambiarEstado(norm));
		 */

    	
	}
	

}
