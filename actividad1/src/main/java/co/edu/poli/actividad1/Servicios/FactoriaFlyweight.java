package co.edu.poli.actividad1.Servicios;

import java.util.HashMap;

public class FactoriaFlyweight {

	private HashMap<String, PasaporteTipo> mapaTipos;

	public FactoriaFlyweight(HashMap<String, PasaporteTipo> mapaTipos) {
		super();
		this.mapaTipos = mapaTipos;
	}

	public HashMap<String, PasaporteTipo> getMapaTipos() {
		return mapaTipos;
	}

	public void setMapaTipos(HashMap<String, PasaporteTipo> mapaTipos) {
		this.mapaTipos = mapaTipos;
	}

	@Override
	public String toString() {
		return "FactoriaFlyweight [mapaTipos=" + mapaTipos + "]";
	}
	
	
}
