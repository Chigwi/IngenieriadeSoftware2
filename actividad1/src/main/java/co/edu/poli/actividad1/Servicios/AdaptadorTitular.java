package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Titular;

public class AdaptadorTitular implements IntTitular {
	
private Titular adaptada;
	
	public AdaptadorTitular(Titular adaptada) {
		super();
		this.adaptada = adaptada;
	}

	public Titular getAdaptada() {
		return adaptada;
	}

	public void setAdaptada(Titular adaptada) {
		this.adaptada = adaptada;
	}

	@Override
	public String toString() {
		return "AdaptadorTitular [adaptada=" + adaptada + "]";
	}



	@Override
	public String getTitularDetallado() {
		StringBuilder titularDetallado = new StringBuilder();
		titularDetallado.append("Titular:"+"\n");
		titularDetallado.append("identificacion: "+ adaptada.getIdentificacion()+"\n");
		titularDetallado.append("fecha de nacimiento: "+ adaptada.getFechaNacimiento()+"\n");
		titularDetallado.append("nombre: " + adaptada.getNombre()+"\n");
		return titularDetallado.toString();
	}
	
	
	
	

}
