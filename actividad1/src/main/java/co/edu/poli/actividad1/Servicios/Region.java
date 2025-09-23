package co.edu.poli.actividad1.Servicios;

import java.util.ArrayList;
import java.util.List;

public class Region implements EspacioGeografico {
	
	private List<EspacioGeografico> children = new ArrayList<>();
	private String nombre;
	
	public Region(ArrayList<EspacioGeografico> children, String nombre) {
		super();
		this.children = children;
		this.nombre = nombre;
	}

	public boolean add (EspacioGeografico lugar) {
		children.add(lugar);
		return true;
	}
	
	public boolean remove (EspacioGeografico lugar) {
		children.remove(lugar);
		return true;
	}
	
	public List<EspacioGeografico> getChildren(){
		return children;
	}

	@Override
	public String getNombre() {
		StringBuilder r = new StringBuilder();
		r.append(nombre + "\n");
		if(children.size()>0) {
			for (int i = 0; i < children.size(); i++) {
				r.append(" "+children.get(i).getNombre());
			}
		}
		return r.toString();
	}
}
