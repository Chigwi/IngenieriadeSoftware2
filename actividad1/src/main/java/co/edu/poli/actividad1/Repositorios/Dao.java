package co.edu.poli.actividad1.Repositorios;

import java.util.List;

public interface Dao <T> {
	
	public String insert (T t);
	
	public T select (String id);
	
	public List <T> selectAll ();
	
	public String Update (T t);
	
	public String Delete (String id);
	
}
