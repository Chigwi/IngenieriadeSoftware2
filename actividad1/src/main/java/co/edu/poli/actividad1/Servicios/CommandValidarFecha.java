package co.edu.poli.actividad1.Servicios;

public class CommandValidarFecha {

	private Validacion validacion;

	public CommandValidarFecha(Validacion validacion) {
		super();
		this.validacion = validacion;
	}

	public Validacion getValidacion() {
		return validacion;
	}

	public void setValidacion(Validacion validacion) {
		this.validacion = validacion;
	}

	@Override
	public String toString() {
		return "CommandValidarFecha [validacion=" + validacion + "]";
	}
	
	public String validate() {
		return null;
	}
	
	public String validateFecha(Validacion validacion) {
		return null;
	}
	
}
