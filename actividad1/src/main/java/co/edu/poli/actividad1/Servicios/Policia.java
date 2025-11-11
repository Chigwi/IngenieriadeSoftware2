package co.edu.poli.actividad1.Servicios;

public class Policia extends Componente implements EntidadGubernamental{

	@Override
	public String recibirNotificacion() {
		
		return "La policia nacional ha sido notificada";
	}

}
