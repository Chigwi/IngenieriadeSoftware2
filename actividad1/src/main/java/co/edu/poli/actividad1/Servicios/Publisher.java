package co.edu.poli.actividad1.Servicios;

import java.util.ArrayList;

public class Publisher {

	private ArrayList<EntidadGubernamental> subscriptores;
	
	public String notificar(String id) {
		return "";
	}
	
	public String subscribir(EntidadGubernamental subscriptor) {
		return null;
	}
	
	public String desubscribir(EntidadGubernamental subscriptor) {
		return null;
	}

	public Publisher(ArrayList<EntidadGubernamental> subscriptores) {
		super();
		this.subscriptores = subscriptores;
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
