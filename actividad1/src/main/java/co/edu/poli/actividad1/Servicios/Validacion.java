package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Pasaporte;
import co.edu.poli.actividad1.Repositorios.PasaporteDao;

public class Validacion {

	
	private PasaporteDao dao;
	
	public boolean titularDuplicado(Pasaporte in) {
		
		return true;
	}
	
	public boolean modificacionTipo(Pasaporte in, String tipo) {
		return true;
	}
	
	public boolean fechaActual(String fecha) {
		return true;
	}
	
}
