package co.edu.poli.actividad1.Servicios;

public class Cancilleria extends Componente implements EntidadGubernamental{
	
	private Mediador mediador;
	
	

	public Cancilleria(Mediador mediador) {
		super();
		this.mediador = mediador;
	}
	

	public Cancilleria() {
		super();
	}





	@Override
	public String recibirNotificacion() {
		
		return "La cancilleria ha sido notificada";
	}

}
