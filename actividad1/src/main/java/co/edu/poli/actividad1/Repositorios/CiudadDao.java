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
	
	public CiudadDao () {
	}

	
	public Connection getConnection() {
		return connection;
	}


	public void setConnection(Connection connection) {
		this.connection = connection;
	}


	@Override
	public String insert(Ciudad t) {
		String sql = "INSERT INTO \"Ciudad\" (\"codigoPostal\", \"nombre\", \"esCapital\") VALUES (?, ?, ?)";
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
String sql = "SELECT * FROM \"Ciudad\" WHERE \"codigoPostal\" = ?";
		
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
		String sql = "UPDATE \"Ciudad\" SET \"nombre\" = ?, \"esCapital\" = ?,  WHERE \"codigoPostal\" = ?";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			
			pstmt.setString(1, t.getNombre());
			
			pstmt.setBoolean(2, t.isEsCapital());
			
			pstmt.executeUpdate();
			
			return "Actualizacion exitosa!";
			
		}catch(SQLException e) {
			
			System.out.println("Error de actualizacion " + e.getMessage());
			e.printStackTrace();
			
		}
		return "Error de actualizacion";
	}

	@Override
	public String Delete(Ciudad t) {
		String sql = "DELETE FROM \"Ciudad\" WHERE \"codigoPostal\" = ?" ;
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, t.getCodigoPostal());
            pstmt.executeUpdate();
            
            return "eliminacion exitosa";
        }catch(SQLException e) {
			
			System.out.println("Error de eliminacion " + e.getMessage());
			e.printStackTrace();
			
        }
		return "Error de eliminacion ";
	}
	
	private Ciudad mapRStoCiudad (ResultSet rs) throws SQLException{
		Ciudad selectCiudad = new Ciudad(rs.getString("codigoPostal"), rs.getString("nombre"),rs.getBoolean("esCapital"));
		
		return selectCiudad;
	}

}
