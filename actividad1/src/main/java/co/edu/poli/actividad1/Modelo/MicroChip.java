package co.edu.poli.actividad1.Modelo;

public class MicroChip extends ElementoSeguridad{
	
	private String numeroChip;

	public MicroChip(String idL, String tipo, String fdescripcion, String numeroChip) {
		super(idL, tipo, fdescripcion);
		this.numeroChip = numeroChip;
		// TODO Auto-generated constructor stub
	}
	
	public MicroChip (MicroChip micro) {
		super(micro.getIdL(),
		micro.getTipo(),
		micro.getFdescripcion());
		this.numeroChip = micro.getNumeroChip();
	}

	public String getNumeroChip() {
		return numeroChip;
	}

	public void setNumeroChip(String numeroChip) {
		this.numeroChip = numeroChip;
	}

	@Override
	public String toString() {
		return "MicroChip: "+ numeroChip;
	}
	
}
