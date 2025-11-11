package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Pais;

public class AdaptadorPais {
	
	private Pais pais;
	private Estado estado;
	
	
	
	public AdaptadorPais(Pais pais, Estado estado) {
		super();
		this.pais = pais;
		this.estado = estado;
		estado.cambiarContexto(this);
	}
	
	

	public AdaptadorPais(Pais pais) {
		super();
		this.pais = pais;
	}


	public String cambiarEstado (Estado estado) {
		System.out.println(this.estado.cambiarEstado(estado));
		if(this.estado.cambiarEstado(estado).equals("estado actualizado con exito")) {
			this.estado = estado;
			estado.cambiarContexto(this);
			return "estado actualizado con exito";
			
		}else {
			return "cambio de estado no valido";
			
		}
	
		
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "AdaptadorPais [pais=" + pais + "]";
	}
	

}
