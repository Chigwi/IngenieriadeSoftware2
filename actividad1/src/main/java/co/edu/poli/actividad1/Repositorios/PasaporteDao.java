package co.edu.poli.actividad1.Repositorios;

import java.util.List;

import co.edu.poli.actividad1.Modelo.Pasaporte;
import java.sql.*;

public class PasaporteDao implements Dao <Pasaporte>{

	private Connection connection;
	
	public PasaporteDao (Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public String insert(Pasaporte t){
		String sql = "INSERT INTO \"Pasaporte\" (\"numeroId\", \"paisEmisor\", \"fechaEmision\", \"fechaExpiracion\", titular, \"ciudadEmision\") VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setString(1, t.getNumeroId());
			
			pstmt.setInt(2, t.getPaisEmisor().getIdPais());
			
			pstmt.setString(3, t.getFechaEmision());
			
			pstmt.setString(4, t.getFechaExpiracion());
			
			pstmt.setString(5, t.getTitular().getIdentificacion());
			
			pstmt.setString(6, t.getCiudadEmision().getCodigoPostal());
			
			pstmt.executeUpdate();
			
			return "Insercion exitosa!";
			
		}catch(SQLException e) {
			
			System.out.println("Error de insercion " + e.getMessage());
			e.printStackTrace();
			
		}
		return "";
	}

	@Override
	public Pasaporte select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pasaporte> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Update(Pasaporte t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Delete(Pasaporte t) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
