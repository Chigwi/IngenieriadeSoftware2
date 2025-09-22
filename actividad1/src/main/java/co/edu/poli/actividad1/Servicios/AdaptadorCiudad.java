package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Ciudad;

public class AdaptadorCiudad implements EspacioGeografico{

	
	private Ciudad adaptada;
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return adaptada.getNombre()+"/n";
	}
	public AdaptadorCiudad(Ciudad adaptada) {
		super();
		this.adaptada = adaptada;
	}
	
}
