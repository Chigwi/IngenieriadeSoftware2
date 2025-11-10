package co.edu.poli.actividad1.Servicios;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	public HashMap<String,String> certificar(ArrayList<String> paises) {
		return estrategiaCertificacion.certificar(paises);
	}
	
}
