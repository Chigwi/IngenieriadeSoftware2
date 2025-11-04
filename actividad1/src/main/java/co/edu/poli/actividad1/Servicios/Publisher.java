package co.edu.poli.actividad1.Servicios;

import java.util.ArrayList;

public class Publisher {

	private ArrayList<EntidadGubernamental> subscriptores;
	
	public String notificar(String id) {
		
		StringBuilder mensaje = new StringBuilder();
		mensaje.append("los cambios realizados al pasaporte identificado con numero de identificacion: ");
		mensaje.append(id);
		mensaje.append("\n");
		mensaje.append("fueron notificados a la siguientes entidades: " + "\n");
		for (EntidadGubernamental entidadGubernamental : subscriptores) {
			mensaje.append(entidadGubernamental.recibirNotificacion()+ "\n");
				
		}
		return mensaje.toString();
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
