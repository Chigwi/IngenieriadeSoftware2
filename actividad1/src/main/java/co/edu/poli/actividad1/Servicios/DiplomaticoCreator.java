package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.PDiplomatico;
import co.edu.poli.actividad1.Modelo.Pasaporte;

public class DiplomaticoCreator implements PCreator<Pasaporte>{

	@Override
	public Pasaporte createPasaporte() {
		
		PDiplomatico p = new PDiplomatico(null, null, null, null, null, null, null);
		
		return p;
	}

}
