package co.edu.poli.actividad1.Servicios;

import java.util.ArrayList;
import java.util.HashMap;

public class CertificarBiometria implements CertificarSeguridad{

	@Override
	public HashMap<String,String> certificar(ArrayList<String> paises) {

		HashMap<String, String> auth = new HashMap<String, String>();
		
		for (String pais : paises) {
			if(pais.equals("Mexico") || pais.equals("Korea del Norte")) {
				auth.put(pais, "Ordinario");
			}else {
				auth.put(pais, "Bloqueado");
			}
		}
		return auth;
	}


}
