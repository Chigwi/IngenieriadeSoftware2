package co.edu.poli.actividad1.Modelo;

public class POrdinario extends Pasaporte {
	
	private String razonViaje;

	private POrdinario(Builder builder) {
		super(builder.numeroId, builder.paisEmisor, builder.fechaEmision, builder.fechaExpiracion, builder.titular, builder.ciudadEmision, builder.es);
		this.razonViaje = builder.razonViaje;
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
	
	public static class Builder{
		private String numeroId;
		private Pais paisEmisor;
		private String fechaEmision;
		private String fechaExpiracion;
		private Titular titular;
		private Ciudad ciudadEmision;
		private String razonViaje;
		private ElementoSeguridad es;

		public Builder agregarNumeroId(String numeroId){
			this.numeroId = numeroId;
			return this;
		}
		public Builder agregarPaisEmisor(Pais paisEmisor) {
			this.paisEmisor= paisEmisor;
			return this;
		}
		public Builder agregarFechaEmision(String fechaEmision) {
			this.fechaEmision = fechaEmision;
			return this;
		}
		public Builder agregarFecharExpiracion(String fechaExpiracion) {
			this.fechaExpiracion = fechaExpiracion;
			return this;
		}
		public Builder agregarTitular (Titular titular) {
			this.titular = titular;
			return this;
		}
		public Builder agregarCiudadEmision (Ciudad ciudadEmision) {
			this.ciudadEmision = ciudadEmision;
			return this;
		}
		public Builder agregarRazonViaje (String razonViaje) {
			this.razonViaje = razonViaje;
			return this;
		}
		public Builder agregarElementoSeguridad (ElementoSeguridad es) {
			this.es	= es;
			return this;
		}
		
		public POrdinario build() {
			return new POrdinario(this);
		}
	}

}
