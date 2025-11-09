package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Pasaporte;

public class CommandValidarTipo implements Command{

	private String tipo;
	
	private Validacion validacion;
	
	private AdaptadorPasaporte adaptada;
	
	@Override
	public String toString() {
		return "CommandValidarTipo [tipo=" + tipo + ", validacion=" + validacion + ", adaptada=" + adaptada + "]";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Validacion getValidacion() {
		return validacion;
	}

	public void setValidacion(Validacion validacion) {
		this.validacion = validacion;
	}

	public AdaptadorPasaporte getAdaptada() {
		return adaptada;
	}

	public void setAdaptada(AdaptadorPasaporte adaptada) {
		this.adaptada = adaptada;
	}

	public CommandValidarTipo(String tipo, Validacion validacion, AdaptadorPasaporte adaptada) {
		super();
		this.tipo = tipo;
		this.validacion = validacion;
		this.adaptada = adaptada;
	}

	@Override
	public String validate() {
		
		Pasaporte in = adaptada.getAdaptada();
		
		boolean val = validacion.modificacionTipo(in, tipo);
		
		if(val) {
			return "NO se puede cambiar el tipo del pasaporte.";
		}else {
			return "Validacion Exitosa!";
		}
			
	}

}
