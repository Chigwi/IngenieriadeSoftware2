package co.edu.poli.actividad1.Servicios;

public class Historial extends DecoradorTitular{

	private String historiaDeViajes;
	
	public Historial(IntTitular wrapee, String historiaDeViajes) {
		super(wrapee);
		this.historiaDeViajes = historiaDeViajes;
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "Historial [historiaDeViajes=" + historiaDeViajes + "]";
	}



	public String getHistoriaDeViajes() {
		return historiaDeViajes;
	}



	public void setHistoriaDeViajes(String historiaDeViajes) {
		this.historiaDeViajes = historiaDeViajes;
	}



	@Override
	public String getTitularDetallado() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
