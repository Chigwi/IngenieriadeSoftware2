package co.edu.poli.actividad1.Servicios;

public class CommandValidarFecha /*implements Command*/{

	private Validacion validacion;
	
	private String fecha;

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
	
	public String validate(String fecha) {

		boolean val = validacion.fechaActual(fecha);
		
		if (val) {
			return "Fecha de emision valida.";
		}else {
			return "La fecha de emision no puede ser despues de el dia de hoy.";
		}
		
		
	}
	
	public String validarFecha(Validacion validacion, String fecha ) {
		
		this.validacion = validacion;
		
		validate(fecha);
		
		return null;
	}
	
}
