package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Pasaporte;

public class CommandValidarTitular implements Command{
	
	private Validacion validacion;
	
	private AdaptadorPasaporte pasaporte;

	
	public CommandValidarTitular(Pasaporte in, Validacion val) {
		
		this.pasaporte = new AdaptadorPasaporte(in);
		this.validacion = val;
	}
	
	
	
	
	public Validacion getValidacion() {
		return validacion;
	}




	public void setValidacion(Validacion validacion) {
		this.validacion = validacion;
	}




	public AdaptadorPasaporte getPasaporte() {
		return pasaporte;
	}




	public void setPasaporte(AdaptadorPasaporte pasaporte) {
		this.pasaporte = pasaporte;
	}

	


	@Override
	public String toString() {
		return "CommandValidarTitular [validacion=" + validacion + ", pasaporte=" + pasaporte + "]";
	}


	@Override
	public String validate() {
		
		/*boolean val = validacion.titularDuplicado(in);*/
		
		return null;
	}
}
