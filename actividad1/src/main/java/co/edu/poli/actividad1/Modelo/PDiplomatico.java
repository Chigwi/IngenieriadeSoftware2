package co.edu.poli.actividad1.Modelo;

public class PDiplomatico extends Pasaporte{
	
	private String misionDiplomatica;

	public PDiplomatico(String numeroId, Pais paisEmisor, String fechaEmision, String fechaExpiracion, Titular titular,
			Ciudad ciudadEmision, String misionDiplomatica) {
		super(numeroId, paisEmisor, fechaEmision, fechaExpiracion, titular, ciudadEmision);
		this.misionDiplomatica = misionDiplomatica;
	}

	public String getMisionDiplomatica() {
		return misionDiplomatica;
	}

	public void setMisionDiplomatica(String misionDiplomatica) {
		this.misionDiplomatica = misionDiplomatica;
	}

	@Override
	public String toString() {
		return "PDiplomatico [misionDiplomatica=" + misionDiplomatica + ", getNumeroId()=" + getNumeroId()
				+ ", getPaisEmisor()=" + getPaisEmisor() + ", getFechaEmision()=" + getFechaEmision()
				+ ", getFechaExpiracion()=" + getFechaExpiracion() + ", getTitular()=" + getTitular()
				+ ", getCiudadEmision()=" + getCiudadEmision() + "]";
	}

	
	
}
