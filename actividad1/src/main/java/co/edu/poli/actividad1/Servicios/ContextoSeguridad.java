package co.edu.poli.actividad1.Servicios;

public class ContextoSeguridad {

	private CertificarSeguridad estrategiaCertificacion;

	public ContextoSeguridad(CertificarSeguridad estrategiaCertificacion) {
		super();
		this.estrategiaCertificacion = estrategiaCertificacion;
	}

	public CertificarSeguridad getEstrategiaCertificacion() {
		return estrategiaCertificacion;
	}

	public void setEstrategiaCertificacion(CertificarSeguridad estrategiaCertificacion) {
		this.estrategiaCertificacion = estrategiaCertificacion;
	}

	@Override
	public String toString() {
		return "ContextoSeguridad [estrategiaCertificacion=" + estrategiaCertificacion + "]";
	}
	
	public String certificar() {
		//TODO
		return null;
		
	}
	
}
