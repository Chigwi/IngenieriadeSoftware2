package co.edu.poli.actividad1.Modelo;

public class POrdinario extends Pasaporte {
	
	private String razonViaje;

	public POrdinario(String numeroId, Pais paisEmisor, String fechaEmision, String fechaExpiracion, Titular titular,
			Ciudad ciudadEmision, String razonViaje, ElementoSeguridad es) {
		super(numeroId, paisEmisor, fechaEmision, fechaExpiracion, titular, ciudadEmision, es);
		this.razonViaje = razonViaje;
	}
	
	public POrdinario(POrdinario pasaporte) {
		super(
		        pasaporte.getNumeroId(),
		        new Pais(pasaporte.getPaisEmisor()),
		        pasaporte.getFechaEmision(),
		        pasaporte.getFechaExpiracion(),
		        new Titular(pasaporte.getTitular()),
		        new Ciudad(pasaporte.getCiudadEmision()),
		        copyElementoSeguridad(pasaporte.getEs())
		    );
	    this.razonViaje = pasaporte.getRazonViaje();
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
				+ ", CiudadEmision=" + getCiudadEmision().getNombre() + "\n"+",Elemento seguridad="+ getEs()+"]";
	}
	private static ElementoSeguridad copyElementoSeguridad(ElementoSeguridad es) {
	    if (es instanceof Biometrico) {
	        return new Biometrico((Biometrico) es);
	    } else if (es instanceof MicroChip) {
	        return new MicroChip((MicroChip) es);
	    } else if (es instanceof Blockchain) {
	        return new Blockchain((Blockchain) es);
	    } else {
	        throw new IllegalArgumentException("Tipo de ElementoSeguridad desconocido");
	    }
	}
	

}
