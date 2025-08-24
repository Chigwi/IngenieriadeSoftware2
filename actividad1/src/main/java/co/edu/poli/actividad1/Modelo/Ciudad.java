package co.edu.poli.actividad1.Modelo;

import java.util.*;

/**
 * 
 */
public class Ciudad {

    /**
     * 
     */
    private String codigoPostal;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    
    private boolean esCapital;

	public Ciudad(String codigoPostal, String nombre, boolean esCapital) {
		super();
		this.codigoPostal = codigoPostal;
		this.nombre = nombre;
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
		return "Ciudad [codigoPostal=" + codigoPostal + ", nombre=" + nombre + ", esCapital=" + esCapital + "]";
	}



    
}