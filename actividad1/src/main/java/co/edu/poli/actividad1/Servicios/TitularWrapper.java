package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Titular;

public class TitularWrapper implements Cloneable {
	

    private Titular titular;
    
    public TitularWrapper(Titular titular) {
        this.titular = titular;
    }
    public String getIdentificacion() {
        return titular.getIdentificacion();
    }
    public void setIdentificacion(String identificacion) {
        titular.setIdentificacion(identificacion);
    }
    public String getFechaNacimiento() {
        return titular.getFechaNacimiento();
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        titular.setFechaNacimiento(fechaNacimiento);
    }
    public String getNombre() {
        return titular.getNombre();
    }
    public void setNombre(String nombre) {
        titular.setNombre(nombre);
    }
    @Override
    public String toString() {
        return titular.toString();
    }
    @Override
    public Titular clone() {
    	Titular clonet = new Titular (this.getIdentificacion(),this.getFechaNacimiento(),this.getNombre());     
        return clonet;
    }
}