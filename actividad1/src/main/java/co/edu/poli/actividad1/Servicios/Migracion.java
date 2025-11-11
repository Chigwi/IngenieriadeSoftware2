package co.edu.poli.actividad1.Servicios;

public class Migracion extends Componente implements EntidadGubernamental{
	
	private Mediador mediador;
	
	

	public Migracion(Mediador mediador) {
		super();
		this.mediador = mediador;
	}


	public Migracion() {
		super();
	}




	@Override
	public String recibirNotificacion() {
		
		return "La agencia de migracion colombiana ha sifo notificada";
	}

}
