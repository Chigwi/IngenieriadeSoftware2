package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Pais;

public class AdaptadorPais {
	
	private Pais pais;
	private Estado estado;
	
	public String cambiarEstado (Estado estado) {
		String resultado = estado.cambiarEstado(estado);
		
		if(resultado.equals("estado actualizado con exito")) {
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
	

}
