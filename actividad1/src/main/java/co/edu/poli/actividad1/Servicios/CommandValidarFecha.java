package co.edu.poli.actividad1.Servicios;

public class CommandValidarFecha implements Command{

	private Validacion validacion;
	
	private String fecha;

	public CommandValidarFecha(Validacion validacion, String fecha) {
		this.validacion = validacion;
		this.fecha = fecha;
	}

	public Validacion getValidacion() {
		return validacion;
	}

	public void setValidacion(Validacion validacion) {
		this.validacion = validacion;
	}

	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "CommandValidarFecha [validacion=" + validacion + "]";
	}
	
	@Override
	public String validate() {

		boolean val = validacion.fechaActual(fecha);
		
		if (val) {
			return "Fecha de emision invalida.";
		}else {
			return "Validacion exitosa!";
		}
		
		
	}	
}
