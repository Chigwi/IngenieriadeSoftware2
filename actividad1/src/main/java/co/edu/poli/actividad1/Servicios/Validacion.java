package co.edu.poli.actividad1.Servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.actividad1.Modelo.PDiplomatico;
import co.edu.poli.actividad1.Modelo.POrdinario;
import co.edu.poli.actividad1.Modelo.Pasaporte;
import co.edu.poli.actividad1.Repositorios.PasaporteDao;

public class Validacion {

	
	private PasaporteDao dao;
	
	
	
	public Validacion(PasaporteDao dao) {
		super();
		this.dao = dao;
	}

	public boolean titularDuplicado(Pasaporte in) {
		String id = in.getTitular().getIdentificacion();
		List<Pasaporte> pasaportes = dao.selectAll();
		for (Pasaporte pasaporte : pasaportes) {
			if(pasaporte.getTitular().getIdentificacion().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean modificacionTipo(Pasaporte in, String tipo) {
		String id = in.getNumeroId();
		Pasaporte p = dao.select(id);
		Boolean val = false;
		if(tipo.equals("ordinario")) {
			if(p instanceof POrdinario) {
				val = false;
			}else {
				val = true;
			}
		}else if(tipo.equals("diplomatico")) {
			if(p instanceof PDiplomatico) {
				val = false;
			}else {
				val = true;
			}
		}
		return val;
	}
	
	public boolean fechaActual(String fecha) {
		
		LocalDate in = LocalDate.parse(fecha);
		LocalDate current = LocalDate.now();
		
		if(in.isAfter(current)) {
			return true;
		}else {
			return false;
		}
	}
	
}
