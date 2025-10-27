package co.edu.poli.actividad1.Servicios;

import java.util.HashMap;

import co.edu.poli.actividad1.Modelo.Pasaporte;

public class FactoriaFlyweight {

	private static HashMap<String, PasaporteTipo> mapaTipos;

	public FactoriaFlyweight(HashMap<String, PasaporteTipo> mapaTipos) {
		super();
		this.mapaTipos = mapaTipos;
	}

	public static HashMap<String, PasaporteTipo> getMapaTipos() {
		return mapaTipos;
	}

	public static void setMapaTipos(HashMap<String, PasaporteTipo> mapaTipos) {
		mapaTipos = mapaTipos;
	}

	@Override
	public String toString() {
		return "FactoriaFlyweight [mapaTipos=" + mapaTipos + "]";
	}
	
	public String mostrarDetalles(Pasaporte p) {
		String message = p.toString() + "/n" + mapaTipos.get(p.getPaisEmisor().getNombre());
		return message;
	}
	
	
}
