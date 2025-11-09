package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Pasaporte;

public class CommandValidarTitular implements Command{
	
	private Validacion validacion;
	
	private AdaptadorPasaporte pasaporte;

	
	public CommandValidarTitular(AdaptadorPasaporte adaptada, Validacion val) {
		
		this.pasaporte = adaptada;
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
		
		Pasaporte p = pasaporte.getAdaptada();
		
		boolean val = validacion.titularDuplicado(p);
		
		if(val) {
			return "El titular ya tiene un pasaporte registrado";
		}else {
			return "Validacion exitosa!";
		}
	}
}
