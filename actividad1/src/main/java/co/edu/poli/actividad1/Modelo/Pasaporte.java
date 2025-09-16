package co.edu.poli.actividad1.Modelo;

import java.util.*;

/**
 * 
 */
public abstract class Pasaporte {

  

    /**
     * 
     */
    private String numeroId;

    /**
     * 
     */
    private Pais paisEmisor;

    /**
     * 
     */
    private String fechaEmision;

    /**
     * 
     */
    private String fechaExpiracion;

    /**
     * 
     */
    private Titular titular;

    /**
     * 
     */
    private Ciudad ciudadEmision;
    
    private ElementoSeguridad es;

	
	public Pasaporte(String numeroId, Pais paisEmisor, String fechaEmision, String fechaExpiracion, Titular titular,
			Ciudad ciudadEmision, ElementoSeguridad es) {
		super();
		this.numeroId = numeroId;
		this.paisEmisor = paisEmisor;
		this.fechaEmision = fechaEmision;
		this.fechaExpiracion = fechaExpiracion;
		this.titular = titular;
		this.ciudadEmision = ciudadEmision;
		this.es = es;
	}

	public String getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(String numeroId) {
		this.numeroId = numeroId;
	}

	public Pais getPaisEmisor() {
		return paisEmisor;
	}

	public void setPaisEmisor(Pais paisEmisor) {
		this.paisEmisor = paisEmisor;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}

	public Ciudad getCiudadEmision() {
		return ciudadEmision;
	}

	public void setCiudadEmision(Ciudad ciudadEmision) {
		this.ciudadEmision = ciudadEmision;
	}
	

	public ElementoSeguridad getEs() {
		return es;
	}

	public void setEs(ElementoSeguridad es) {
		this.es = es;
	}

	@Override
	public String toString() {
		return "Pasaporte [numeroId=" + numeroId + ", paisEmisor=" + paisEmisor + ", fechaEmision=" + fechaEmision
				+ ", fechaExpiracion=" + fechaExpiracion + ", titular=" + titular + ", ciudadEmision=" + ciudadEmision
				+ ", es=" + es + "]";
	}


    
    

}