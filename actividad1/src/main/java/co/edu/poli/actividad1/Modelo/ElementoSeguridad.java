package co.edu.poli.actividad1.Modelo;

public class ElementoSeguridad {
	
	
	 private String idL;

	    /**
	     * 
	     */
	    private String tipo;

	    /**
	     * 
	     */
	    private String descripcion;

		public ElementoSeguridad(String idL, String tipo, String fdescripcion) {
			super();
			this.idL = idL;
			this.tipo = tipo;
			this.descripcion = fdescripcion;
		}

		public String getIdL() {
			return idL;
		}

		public void setIdL(String idL) {
			this.idL = idL;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getFdescripcion() {
			return descripcion;
		}

		public void setFdescripcion(String fdescripcion) {
			this.descripcion = fdescripcion;
		}

		@Override
		public String toString() {
			return "ElementoSeguridad [idL=" + idL + ", tipo=" + tipo + ", descripcion=" + descripcion + "]";
		}
	    
	    


}
