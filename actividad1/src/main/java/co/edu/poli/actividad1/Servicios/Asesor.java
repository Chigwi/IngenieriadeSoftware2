package co.edu.poli.actividad1.Servicios;

public class Asesor implements Handler {

	private Handler nextHandler;
	
	@Override
	public String manejarSolicitud(Integer in, String sol) {
	
		if(nextHandler == null) {
			if (in % 2 == 0) {
				return sol + "\n solicitud aprobada por los asesores competentes";
			}else {
				return sol + "\n solicitud negada por los asesores competentes";
			}	
		}else {
			if (in % 2 == 0) {
				return sol + "\n solicitud aprobada por los asesores competentes " + nextHandler.manejarSolicitud(in, sol);
			}else {
				return sol + "\n solicitud negada por los asesores competentes";
			}	
		}
	}

}
