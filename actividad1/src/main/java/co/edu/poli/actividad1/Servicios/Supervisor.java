package co.edu.poli.actividad1.Servicios;

public class Supervisor extends Handler{
	
	private Handler nextHandler;
	
	

	public Supervisor() {
		this.nextHandler = null;
	}



	public Supervisor(Handler nextHandler) {
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
		return "Supervisor [nextHandler=" + nextHandler + "]";
	}



	@Override
	public String manejarSolicitud(Integer in, String sol) {
		if(nextHandler == null) {
			if(in%3 == 0) {
				return sol + "\n solicitud aprobada por el supervisor asigando";

			}else {
				return sol + "\n solicitud negada por el supervisor asigando";
			}
		}else {
			if(in%3 == 0) {
				return sol + "\n solicitud aprobada por el supervisor asigando" + nextHandler.manejarSolicitud(in, sol);

			}else {
				return sol + "\n solicitud negada por el supervisor asigando";
			}
		}
	}

}
