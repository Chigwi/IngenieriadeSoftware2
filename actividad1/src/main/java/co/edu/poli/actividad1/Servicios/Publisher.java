package co.edu.poli.actividad1.Servicios;

import java.util.ArrayList;

public class Publisher {

	private ArrayList<EntidadGubernamental> subscriptores;
	
	public String notificar(String id) {
		return "";
	}
	
	public String subscribir(EntidadGubernamental subscriptor) {
		
		subscriptores.add(subscriptor);
		
		return "Insertado con exito: "+ subscriptor.toString();
	}
	
	public String desubscribir(EntidadGubernamental subscriptor) {
		
		subscriptores.remove(subscriptor);
		
		return "subcriptor " + subscriptor.toString() + " fue eliminado con exito";
	}

	public Publisher() {
		super();
		this.subscriptores = new ArrayList<EntidadGubernamental>();
	}

	public ArrayList<EntidadGubernamental> getSubscriptores() {
		return subscriptores;
	}

	public void setSubscriptores(ArrayList<EntidadGubernamental> subscriptores) {
		this.subscriptores = subscriptores;
	}

	@Override
	public String toString() {
		return "Publisher [subscriptores=" + subscriptores + "]";
	}
	
}
