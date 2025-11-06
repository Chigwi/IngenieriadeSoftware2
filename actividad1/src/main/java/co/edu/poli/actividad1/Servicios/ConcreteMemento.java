package co.edu.poli.actividad1.Servicios;

public class ConcreteMemento implements Memento{

	private PasaporteOriginator state;

	public ConcreteMemento(PasaporteOriginator state) {
		super();
		this.state = state;
	}
	
	public PasaporteOriginator getMemento() {
		return this.state;
	}
	
}
