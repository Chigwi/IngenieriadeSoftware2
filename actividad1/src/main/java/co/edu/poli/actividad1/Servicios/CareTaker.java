package co.edu.poli.actividad1.Servicios;

import java.util.HashMap;

public class CareTaker{
	
	private HashMap<Integer, Memento> Historial;

	public CareTaker() {
		this.Historial = new HashMap<Integer, Memento>();
	}
	
	public String addMemento(Integer key ,ConcreteMemento mm) {

		this.Historial.put(key, mm);
		
		return "Insertado con llave " + key.toString();
	}
	
	public Memento getMemento(Integer key) {
		
		return this.Historial.get(key);
		
	}
}
