package co.edu.poli.actividad1.Repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import co.edu.poli.actividad1.Modelo.Pais;

public class PaisDao implements Dao <Pais> {
	
	private Connection connection;
	
	public PaisDao (Connection connection) {
		this.connection = connection;
	}

	@Override
	public String insert(Pais t) {
		String sql = "INSERT INTO \"Pais\" (\"idPais\", \"nombre\", \"idioma\") VALUES (?, ?, ?)";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setInt(1, t.getIdPais());
			
			pstmt.setString(2, t.getNombre());
			
			pstmt.setString(3, t.getIdioma());
			
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("Error de insercion " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Pais select(String id) {
		
		return null;
	}

	@Override
	public List<Pais> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Update(Pais t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Delete(Pais t) {
		// TODO Auto-generated method stub
		return null;
	}

}
