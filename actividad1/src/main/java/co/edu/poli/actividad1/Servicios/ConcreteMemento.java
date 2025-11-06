package co.edu.poli.actividad1.Servicios;

public class ConcreteMemento implements Memento{

	private AdaptadorPasaporte state;

	public ConcreteMemento(AdaptadorPasaporte state) {
		super();
		this.state = state;
	}
	
	public AdaptadorPasaporte getMemento() {
		return this.state;
	}
	
}
