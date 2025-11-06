package co.edu.poli.actividad1.Modelo;

import java.util.*;

/**
 * 
 */
public class Visa {
    /**
     * 
     */
    private String idVisa;

    /**
     * 
     */
    private Pais paisDestino;

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
    private Pasaporte pasaporte;

	public Visa(String idVisa, Pais paisDestino, String fechaEmision, String fechaExpiracion, Pasaporte pasaporte) {
		super();
		this.idVisa = idVisa;
		this.paisDestino = paisDestino;
		this.fechaEmision = fechaEmision;
		this.fechaExpiracion = fechaExpiracion;
		this.pasaporte = pasaporte;
	}
	
	public Visa(Visa visa) {
		super();
		this.idVisa = visa.getIdVisa();
		this.paisDestino = visa.getPaisDestino();
		this.fechaEmision = visa.getFechaEmision();
		this.fechaExpiracion = visa.getFechaExpiracion();
		this.pasaporte = visa.getPasaporte();
	}

	public String getIdVisa() {
		return idVisa;
	}

	public void setIdVisa(String idVisa) {
		this.idVisa = idVisa;
	}

	public Pais getPaisDestino() {
		return paisDestino;
	}

	public void setPaisDestino(Pais paisDestino) {
		this.paisDestino = paisDestino;
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

	public Pasaporte getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(Pasaporte pasaporte) {
		this.pasaporte = pasaporte;
	}

	@Override
	public String toString() {
		return "Visa [idVisa=" + idVisa + ", paisDestino=" + paisDestino + ", fechaEmision=" + fechaEmision
				+ ", fechaExpiracion=" + fechaExpiracion + ", pasaporte=" + pasaporte + "]";
	}
    
}