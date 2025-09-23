package co.edu.poli.actividad1.Servicios;

import java.util.ArrayList;

public class Region {
	
	private ArrayList<EspacioGeografico> children = new ArrayList<>();
	private String nombre;
	
	public Region(ArrayList<EspacioGeografico> children, String nombre) {
		super();
		this.children = children;
		this.nombre = nombre;
	}

	public boolean add (EspacioGeografico lugar) {
		return true;
	}
	
	public boolean remove (EspacioGeografico lugar) {
		return true;
	}
	
	public ArrayList<EspacioGeografico> getChildren(){
		return children;
	}
}
