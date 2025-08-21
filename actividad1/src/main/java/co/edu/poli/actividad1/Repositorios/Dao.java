package co.edu.poli.actividad1.Repositorios;

public interface Dao <T> {
	public String insert (T t);
	public T select (String id);

}
