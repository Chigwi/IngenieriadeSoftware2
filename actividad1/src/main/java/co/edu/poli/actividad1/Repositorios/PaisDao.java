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
			
			return "Insercion exitosa";
			
		}catch (SQLException e) {
			System.out.println("Error de insercion " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Pais select(String id) {
		String sql = "SELECT * FROM \"Pais\" WHERE \"idPais\" = ?";
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			
			 ResultSet rs = pstmt.executeQuery();
			 
	            if (rs.next()) {
	            	List <Ciudad> c = new ArrayList<Ciudad>();
	            	Pais p = new Pais (rs.getInt("idPais"),rs.getString("nombre"),rs.getString("idioma"),c);
	            	return p;
	            }
		}catch( SQLException e) {
			System.out.println("Error de lectura " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Pais> selectAll() {
		List <Pais> paises = new ArrayList<>();
		String sql = "SELECT * FROM \"Pais\"";
		try (Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(sql); {
            while (rs.next()) {
               paises.add(mapRStoPais(rs));
            }
       }
       return paises;
     
	}catch (SQLException e) {
		System.out.println("Error de lectura " + e.getMessage());
	}
		return null;
	}

	@Override
	public String Update(Pais t) {
		String sql= "UPDATE \"Pais\" SET \"nombre\" = ?, \"idioma\" = ?, WHERE \"idPais\" = ?";
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setString(1, t.getNombre());
			
			pstmt.setString(2, t.getIdioma());
			
			pstmt.executeUpdate();
			
			return "Actualizacion exitosa!";
			
		}catch(SQLException e) {
			
			System.out.println("Error de actualizacion " + e.getMessage());
			e.printStackTrace();
			
		}
		return "Error de actualizacion";
	}

	@Override
	public String Delete(Pais t) {
		String sql = "DELETE FROM \"Pais\" WHERE \"idPais\" = ?" ;
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, t.getIdPais());
            pstmt.executeUpdate();
            
            return "eliminacion exitosa";
        }catch(SQLException e) {
			
			System.out.println("Error de eliminacion " + e.getMessage());
			e.printStackTrace();
			
        }
		return "Error de eliminacion ";
	}
	private Pais mapRStoPais (ResultSet rs)throws SQLException{
		List <Ciudad> c = new ArrayList<Ciudad>();
    	Pais p = new Pais (rs.getInt("idPais"),rs.getString("nombre"),rs.getString("idioma"),c);
    	return p;
	}

}
