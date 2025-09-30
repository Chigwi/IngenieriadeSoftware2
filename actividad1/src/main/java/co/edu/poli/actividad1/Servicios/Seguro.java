package co.edu.poli.actividad1.Servicios;

public class Seguro extends DecoradorTitular{

	private String tipoSeguro;
	
	
	public Seguro(IntTitular wrapee, String tipoSeguro) {
		super(wrapee);
		this.tipoSeguro = tipoSeguro;
	}


	@Override
	public String toString() {
		return "Seguro [tipoSeguro=" + tipoSeguro + "]";
	}


	public String getTipoSeguro() {
		return tipoSeguro;
	}


	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}


	@Override
	public String getTitularDetallado() {
		// TODO Auto-generated method stub
		return null;
	}

}
