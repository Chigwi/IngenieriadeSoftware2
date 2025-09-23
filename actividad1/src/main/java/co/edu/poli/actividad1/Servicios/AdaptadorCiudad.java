package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Ciudad;

public class AdaptadorCiudad implements EspacioGeografico{

	
	private Ciudad adaptada;
	
	public AdaptadorCiudad(Ciudad adaptada) {
		super();
		this.adaptada = adaptada;
	}
	
	@Override
	public String getNombre() {
		return adaptada.getNombre()+"/n";
	}
	
}
