package co.edu.poli.actividad1.Modelo;

/**
 * 
 */
public class Titular {
    /**
     * 
     */
	private String identificacion;

    /**
     * 
     */
    private String fechaNacimiento;

    /**
     * 
     */
    private String nombre;

	public Titular(String identificacion, String fechaNacimiento, String nombre) {
		super();
		this.identificacion = identificacion;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	@Override
	public String toString() {
		return "Titular [identificacion=" + identificacion + ", fechaNacimiento=" + fechaNacimiento + ", nombre="
				+ nombre + "]";
	}


//tt
    
}