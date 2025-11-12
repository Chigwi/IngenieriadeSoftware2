package co.edu.poli.actividad1.Servicios;

public class EstadoRevision implements Estado{
	
	private AdaptadorPais contexto;

	@Override
	public String cambiarEstado(Estado estado) {
		if (estado instanceof SolicitudVisa) {
			return "estado actualizado con exito";
		}else {
			return "cambio no valido para este estado";
			
		}
		
	}

	public AdaptadorPais getContexto() {
		return contexto;
	}

	public void setContexto(AdaptadorPais contexto) {
		this.contexto = contexto;
	}

	@Override
	public void cambiarContexto(AdaptadorPais contexto) {
		this.contexto= contexto;
		
	}

	@Override
	public String toString() {
		return "EstadoRevision";
	}
	

}
