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
    
    /**
     * 
     */
    private String codigoPais;

	public Ciudad(String codigoPostal, String nombre, boolean esCapital,String codigoPais) {
		super();
		this.codigoPostal = codigoPostal;
		this.nombre = nombre;
		this.esCapital = esCapital;
		this.codigoPais = codigoPais;
	}
	
	public Ciudad (Ciudad ciudad) {
		this.codigoPostal = ciudad.getCodigoPostal();
		this.nombre = ciudad.getNombre();
		this.esCapital = ciudad.isEsCapital();
		this.codigoPais = ciudad.getCodigoPais();
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

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	@Override
	public String toString() {
		return "Ciudad [codigoPostal=" + codigoPostal + ", nombre=" + nombre + ", esCapital=" + esCapital
				+ ", codigoPais=" + codigoPais + "]";
	}
	




    
}