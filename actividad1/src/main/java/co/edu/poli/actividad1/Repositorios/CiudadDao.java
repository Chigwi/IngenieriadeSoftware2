package co.edu.poli.actividad1.Repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Modelo.Pasaporte;
import co.edu.poli.actividad1.Modelo.Titular;

public class CiudadDao implements Dao <Ciudad> {
	
private Connection connection;
	
	public CiudadDao (Connection connection) {
		this.connection = connection;
	}

	@Override
	public String insert(Ciudad t) {
		String sql = "INSERT INTO \"Cuidad\" (\"codigoPostal\", \"nombre\", \"esCapital\") VALUES (?, ?, ?)";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setString(1, t.getCodigoPostal());
			
			pstmt.setString(2, t.getNombre());
			
			pstmt.setBoolean(3, t.isEsCapital());
			
			pstmt.executeUpdate();
			
			return "Insercion exitosa";
			
			
		}catch(SQLException e) {
			System.out.println("Error de insercion " + e.getMessage());
			e.printStackTrace();
				
		}
		return "";
	}

	@Override
	public Ciudad select(String id) {
String sql = "SELECT * FROM \"Cuidad\" WHERE \"codigoPostal\" = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			
			 ResultSet rs = pstmt.executeQuery();
			 
			 if (rs.next()) {
	            	
	            	Ciudad selectCiudad = new Ciudad(rs.getString("codigoPostal"), rs.getString("nombre"),rs.getBoolean("esCapital"));
	            	
	            	return selectCiudad;
	            }
			 
			 
		}catch(SQLException e) {
			System.out.println("Error de insercion " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Ciudad> selectAll() {
		List<Ciudad> ciudades = new ArrayList<>();
        String sql = "SELECT * FROM \"Cuidad\"";
        try (Statement stmt = connection.createStatement()){
             ResultSet rs = stmt.executeQuery(sql); {
             while (rs.next()) {
                ciudades.add(mapRStoCiudad(rs));
             }
        }
        return ciudades;
      
	}catch (SQLException e) {
		System.out.println("Error de lectura " + e.getMessage());
			}
        return null;
        
        }

	@Override
	public String Update(Ciudad t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Delete(Ciudad t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Ciudad mapRStoCiudad (ResultSet rs) throws SQLException{
		Ciudad selectCiudad = new Ciudad(rs.getString("codigoPostal"), rs.getString("nombre"),rs.getBoolean("esCapital"));
		
		return selectCiudad;
	}

}
