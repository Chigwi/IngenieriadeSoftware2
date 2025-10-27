package co.edu.poli.actividad1.Servicios;

public class Fachada {

	public String confirmarPasaporte(int id) {
		VerificarId verificarId = new VerificarId();
		VerificarAnt verificarAnt = new VerificarAnt();
		GeneracionP generacionP = new GeneracionP();
		if(verificarId.verificarIdentidad(id)) {
			if(verificarAnt.verificarAntecedentes(id)) {
				return generacionP.generarPasaporte(id);
			}else {
				return "usuario tiene problemas con sus antecedentes";
			}
		}else {
			return "no se pudo verificar la identidad del usuario";
		}
	}

}
