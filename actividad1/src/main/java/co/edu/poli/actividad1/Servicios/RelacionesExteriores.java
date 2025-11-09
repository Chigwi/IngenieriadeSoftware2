package co.edu.poli.actividad1.Servicios;

public class RelacionesExteriores implements Handler {
	
	private Handler nextHandler;
	
	
	

	public RelacionesExteriores() {
		this.nextHandler = null;
	}



	public RelacionesExteriores(Handler nextHandler) {
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
		return "RelacionesExteriores [nextHandler=" + nextHandler + "]";
	}



	@Override
	public String manejarSolicitud(Integer in, String sol) {
		if(nextHandler == null) {
			if (in % 4 == 0) {
				return sol+"\n solicitud aprobada por el ministro";
			}else {
				return sol+"\n solicitud negada por el ministro";

			}
		}else {
			if (in % 4 == 0) {
				return sol+"\n solicitud aprobada por el ministro"+nextHandler.manejarSolicitud(in, sol);
			}else {
				return sol+"\n solicitud negada por el ministro";

			}
		}
	}
	
	

}
