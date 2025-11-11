package co.edu.poli.actividad1.Servicios;

public class Policia extends Componente implements EntidadGubernamental{
	
	private Mediador mediador;
	
	

	public Policia(Mediador mediador) {
		super();
		this.mediador = mediador;
	}
	
	public Policia() {
		super();
	}





	@Override
	public String recibirNotificacion() {
		
		return "La policia nacional ha sido notificada";
	}

}
