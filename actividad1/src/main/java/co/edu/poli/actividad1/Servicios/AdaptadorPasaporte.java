package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Pasaporte;

public class AdaptadorPasaporte implements InterfazProxy{
	
	private Pasaporte adaptada;
	
	
	
	
	public AdaptadorPasaporte(Pasaporte adaptada) {
		super();
		this.adaptada = adaptada;
	}



	public Pasaporte getAdaptada() {
		return adaptada;
	}



	public void setAdaptada(Pasaporte adaptada) {
		this.adaptada = adaptada;
	}
	


	@Override
	public String toString() {
		return "AdaptadorPasaporte [adaptada=" + adaptada + "]";
	}



	@Override
	public String verDetalles(String rol) {
		return "Acceso denegado";
	}
	
	
}
