package co.edu.poli.actividad1.Servicios;

import java.util.ArrayList;
import java.util.HashMap;

public class CertificarBlockChain implements CertificarSeguridad{

	@Override
	public HashMap<String,String> certificar(ArrayList<String> paises) {
		
		HashMap<String, String> auth = new HashMap<String, String>();
		
		for (String pais : paises) {
			if(pais.equals("Colombia") || pais.equals("EstadosUnidos")) {
				auth.put(pais, "Diplomatico");
			}else {
				auth.put(pais, "Bloqueado");
			}
		}
		return auth;
	}


}
