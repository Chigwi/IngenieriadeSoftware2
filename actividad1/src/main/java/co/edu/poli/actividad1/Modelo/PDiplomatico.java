package co.edu.poli.actividad1.Modelo;

public class PDiplomatico extends Pasaporte{
	
	private String misionDiplomatica;

	public PDiplomatico(String numeroId, Pais paisEmisor, String fechaEmision, String fechaExpiracion, Titular titular,
			Ciudad ciudadEmision, String misionDiplomatica, ElementoSeguridad es) {
		super(numeroId, paisEmisor, fechaEmision, fechaExpiracion, titular, ciudadEmision, es);
		this.misionDiplomatica = misionDiplomatica;
	}
	
	public PDiplomatico (PDiplomatico pasaporte) {
		super(
		        pasaporte.getNumeroId(),
		        pasaporte.getPaisEmisor(),
		        pasaporte.getFechaEmision(),
		        pasaporte.getFechaExpiracion(),
		        pasaporte.getTitular(),
		        pasaporte.getCiudadEmision(),
		        pasaporte.getEs()
		    );
		this.misionDiplomatica = pasaporte.getMisionDiplomatica();
	}

	public String getMisionDiplomatica() {
		return misionDiplomatica;
	}

	public void setMisionDiplomatica(String misionDiplomatica) {
		this.misionDiplomatica = misionDiplomatica;
	}

	@Override
	public String toString() {
		return "PDiplomatico [misionDiplomatica=" + misionDiplomatica + "\n" + ", NumeroId=" + getNumeroId()+ "\n"
				+ ", PaisEmisor=" + getPaisEmisor().getNombre()+ "\n" + ", FechaEmision=" + getFechaEmision()+ "\n"
				+ ", FechaExpiracion=" + getFechaExpiracion()+ "\n" + ", Titular=" + getTitular().getNombre()+ "\n"
				+ ", CiudadEmision=" + getCiudadEmision().getNombre()+"\n"+getEs() + "]";
	}
//holi
	
	
}
