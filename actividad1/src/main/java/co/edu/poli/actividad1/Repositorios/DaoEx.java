package co.edu.poli.actividad1.Repositorios;

import java.util.List;


public interface DaoEx<T> extends Dao <T>{
	
	public List<T> selectIdFiltered(String condicion);

}
