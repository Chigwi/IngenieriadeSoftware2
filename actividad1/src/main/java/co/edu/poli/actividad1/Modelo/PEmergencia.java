package co.edu.poli.actividad1.Modelo;

public class PEmergencia extends Pasaporte {
	
	private String fechaExpiracionEmergenica;

	public PEmergencia(String numeroId, Pais paisEmisor, String fechaEmision, String fechaExpiracion, Titular titular,
			Ciudad ciudadEmision, ElementoSeguridad es, String fechaExpiracionEmergenica) {
		super(numeroId, paisEmisor, fechaEmision, fechaExpiracion, titular, ciudadEmision, es);
		this.fechaExpiracionEmergenica = fechaExpiracionEmergenica;
	}

	public String getFechaExpiracionEmergenica() {
		return fechaExpiracionEmergenica;
	}

	public void setFechaExpiracionEmergenica(String fechaExpiracionEmergenica) {
		this.fechaExpiracionEmergenica = fechaExpiracionEmergenica;
	}

	@Override
	public String toString() {
		return "PEmergencia [fechaExpiracionEmergenica=" + fechaExpiracionEmergenica + "]";
	}
	
	

}
