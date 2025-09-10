package co.edu.poli.actividad1.Modelo;

public class POrdinario extends Pasaporte {
	
	private String razonViaje;

	public POrdinario(String numeroId, Pais paisEmisor, String fechaEmision, String fechaExpiracion, Titular titular,
			Ciudad ciudadEmision, String razonViaje) {
		super(numeroId, paisEmisor, fechaEmision, fechaExpiracion, titular, ciudadEmision);
		this.razonViaje = razonViaje;
	}

	public String getRazonViaje() {
		return razonViaje;
	}

	public void setRazonViaje(String razonViaje) {
		this.razonViaje = razonViaje;
	}

	@Override
	public String toString() {
		return "POrdinario [razonViaje=" + razonViaje + "\n" + ", NumeroId=" + getNumeroId()+ "\n"
				+ ", PaisEmisor=" + getPaisEmisor().getNombre()+ "\n" + ", FechaEmision=" + getFechaEmision()+ "\n"
				+ ", FechaExpiracion=" + getFechaExpiracion()+ "\n" + ", Titular=" + getTitular().getNombre()+ "\n"
				+ ", CiudadEmision=" + getCiudadEmision().getNombre() + "]";
	}
	
	

}
