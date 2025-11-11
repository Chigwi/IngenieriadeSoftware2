package co.edu.poli.actividad1.Servicios;

public class Migracion extends Componente implements EntidadGubernamental{

	@Override
	public String recibirNotificacion() {
		
		return "La agencia de migracion colombiana ha sifo notificada";
	}

}
