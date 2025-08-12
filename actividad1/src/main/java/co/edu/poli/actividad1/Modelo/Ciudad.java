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
    private Pais pais;

    /**
     * 
     */
    private boolean esCapital;

	public Ciudad(String nombre, String codigoPostal, Pais pais, boolean esCapital) {
		super();
		this.nombre = nombre;
		this.codigoPostal = codigoPostal;
		this.pais = pais;
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public boolean isEsCapital() {
		return esCapital;
	}

	public void setEsCapital(boolean esCapital) {
		this.esCapital = esCapital;
	}

	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + ", codigoPostal=" + codigoPostal + ", pais=" + pais + ", esCapital="
				+ esCapital + "]";
	}

    
}