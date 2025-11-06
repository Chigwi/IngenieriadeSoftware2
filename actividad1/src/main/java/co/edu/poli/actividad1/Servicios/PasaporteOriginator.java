package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Pasaporte;

public class PasaporteOriginator {
	
	private Pasaporte state;
	
	
	//metodos memento
	public ConcreteMemento createMemento () {
		Pasaporte p = state;
		AdaptadorPasaporte r = new AdaptadorPasaporte(p);
		ConcreteMemento m = new ConcreteMemento (r);
		return m;
	}
	
	public PasaporteOriginator restore(ConcreteMemento m) {
		AdaptadorPasaporte r = m.getMemento();
		this.state = r.getAdaptada();
		return this;
	}
}
