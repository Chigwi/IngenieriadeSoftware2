package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.ElementoSeguridad;
import co.edu.poli.actividad1.Modelo.POrdinario;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Modelo.Titular;


public class POrdinarioBuilder{
	private String numeroId;
	private Pais paisEmisor;
	private String fechaEmision;
	private String fechaExpiracion;
	private Titular titular;
	private Ciudad ciudadEmision;
	private String razonViaje;
	private ElementoSeguridad es;

	public POrdinarioBuilder agregarNumeroId(String numeroId){
		this.numeroId = numeroId;
		return this;
	}
	public POrdinarioBuilder agregarPaisEmisor(Pais paisEmisor) {
		this.paisEmisor= paisEmisor;
		return this;
	}
	public POrdinarioBuilder agregarFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
		return this;
	}
	public POrdinarioBuilder agregarFecharExpiracion(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
		return this;
	}
	public POrdinarioBuilder agregarTitular (Titular titular) {
		this.titular = titular;
		return this;
	}
	public POrdinarioBuilder agregarCiudadEmision (Ciudad ciudadEmision) {
		this.ciudadEmision = ciudadEmision;
		return this;
	}
	public POrdinarioBuilder agregarRazonViaje (String razonViaje) {
		this.razonViaje = razonViaje;
		return this;
	}
	public POrdinarioBuilder agregarElementoSeguridad (ElementoSeguridad es) {
		this.es	= es;
		return this;
	}
	
	public POrdinario build() {
		
		return new POrdinario(numeroId,paisEmisor,fechaEmision,fechaExpiracion,titular,ciudadEmision,razonViaje,es);
	}
}
