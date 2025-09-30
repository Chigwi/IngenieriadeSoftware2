package co.edu.poli.actividad1.Servicios;

public class Asistencia extends DecoradorTitular{
	
	private String tipoAsistencia;

	public Asistencia(IntTitular wrapee, String tipoAsistencia) {
		super(wrapee);
		this.tipoAsistencia = tipoAsistencia;
	}

	public String getTipoAsistencia() {
		return tipoAsistencia;
	}

	public void setTipoAsistencia(String tipoAsistencia) {
		this.tipoAsistencia = tipoAsistencia;
	}

	@Override
	public String toString() {
		return "Asistencia [tipoAsistencia=" + tipoAsistencia + "]";
	}

	@Override
	public String getTitularDetallado() {
StringBuilder titDetallado = new StringBuilder();
		
		titDetallado.append(this.getWrapee().getTitularDetallado());
		
		titDetallado.append("\n");
		
		titDetallado.append(tipoAsistencia);
		
		return titDetallado.toString();
	}
	
	
}
