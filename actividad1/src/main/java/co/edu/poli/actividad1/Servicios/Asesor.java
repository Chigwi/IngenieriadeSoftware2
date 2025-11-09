package co.edu.poli.actividad1.Servicios;

public class Asesor extends Handler {

	private Handler nextHandler;
	
	
	
	public Asesor() {
		nextHandler = null;
	}



	public Asesor(Handler nextHandler) {
		super();
		this.nextHandler = nextHandler;
	}

	

	public Handler getNextHandler() {
		return nextHandler;
	}



	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	

	@Override
	public String toString() {
		return "Asesor [nextHandler=" + nextHandler + "]";
	}



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
