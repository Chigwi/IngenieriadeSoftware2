package co.edu.poli.actividad1.Servicios;

public class Cancilleria extends Componente implements EntidadGubernamental{

	@Override
	public String recibirNotificacion() {
		
		return "La cancilleria ha sido notificada";
	}

}
