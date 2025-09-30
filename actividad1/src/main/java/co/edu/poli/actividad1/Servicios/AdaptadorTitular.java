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
		// Tetas
		return null;
	}
	
	
	
	

}
