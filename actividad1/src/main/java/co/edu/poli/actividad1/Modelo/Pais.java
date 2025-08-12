package co.edu.poli.actividad1.Modelo;

import java.util.*;

/**
 * 
 */
public class Pais {

 

    /**
     * 
     */
    private int idPais;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String idioma;

    /**
     * 
     */
    private List <Ciudad> ciudades;

	public Pais(int idPais, String nombre, String idioma, List<Ciudad> ciudades) {
		super();
		this.idPais = idPais;
		this.nombre = nombre;
		this.idioma = idioma;
		this.ciudades = ciudades;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	@Override
	public String toString() {
		return "Pais [idPais=" + idPais + ", nombre=" + nombre + ", idioma=" + idioma + ", ciudades=" + ciudades + "]";
	}

    
}
