package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Ciudad;

public class AdaptadorCiudad implements EspacioGeografico{

	
	private Ciudad adaptada;
	
	public AdaptadorCiudad(Ciudad adaptada) {
		super();
		this.adaptada = adaptada;
	}
	
	public Ciudad getAdaptada() {
		return adaptada;
	}
	
	@Override
	public String getNombre(int indent) {
		String indentStr = "-".repeat(indent);
		return indentStr + adaptada.getNombre()+"\n";
	}
	
}
