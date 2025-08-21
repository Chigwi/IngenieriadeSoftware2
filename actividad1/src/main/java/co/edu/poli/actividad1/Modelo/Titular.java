package co.edu.poli.actividad1.Modelo;

/**
 * 
 */
public class Titular {
    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String fechaNacimiento;

    /**
     * 
     */
    private String identificacion;

	public Titular(String nombre, String fechaNacimiento, String identificacion) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.identificacion = identificacion;
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
		return "Titular [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", identificacion="
				+ identificacion + "]";
	}
//tt
    
}