package co.edu.poli.actividad1.Modelo;

import java.util.*;

/**
 * 
 */
public class Ciudad {

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String codigoPostal;

    /**
     * 
     */
    
    private boolean esCapital;

	public Ciudad(String nombre, String codigoPostal, boolean esCapital) {
		super();
		this.nombre = nombre;
		this.codigoPostal = codigoPostal;
		this.esCapital = esCapital;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public boolean isEsCapital() {
		return esCapital;
	}

	public void setEsCapital(boolean esCapital) {
		this.esCapital = esCapital;
	}

	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + ", codigoPostal=" + codigoPostal  + ", esCapital="
				+ esCapital + "]";
	}

    
}