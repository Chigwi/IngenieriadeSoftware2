package co.edu.poli.actividad1.Servicios;

public class Fachada {
	
	private VerificarId verificarId;
	private VerificarAnt verificarAnt;
	private GeneracionP generacionP;
	
	
	
	public Fachada() {
		super();
		this.verificarId = new VerificarId();
		this.verificarAnt = new VerificarAnt();
		this.generacionP = new GeneracionP();
	}



	public String confirmarPasaporte(int id) {
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
