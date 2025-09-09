package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.POrdinario;
import co.edu.poli.actividad1.Modelo.Pasaporte;

public class OrdinarioCreator implements PCreator<Pasaporte> {

	@Override
	public Pasaporte createPasaporte() {
		
		POrdinario p = new POrdinario(null, null, null, null, null, null, null);
		
		return p;
	}

}
