package co.edu.poli.actividad1.Repositorios;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Modelo.Pasaporte;
import co.edu.poli.actividad1.Modelo.Titular;

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
		
		String sql = "SELECT * FROM \"Pasaporte\" WHERE \"numeroId\" = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			
			 ResultSet rs = pstmt.executeQuery();
			 
	            if (rs.next()) {
	            	
	            	Titular selectTitular = new Titular (rs.getString("titular")," ", " ");
	            	Ciudad selectCiudad = new Ciudad(rs.getString("ciudadEmision"),"",false);
	            	List <Ciudad> c = new ArrayList<Ciudad>();
	            	Pais selectPais = new Pais (rs.getInt("paisEmisor"),"","",c);
	            	Pasaporte p = new Pasaporte (rs.getString("numeroId"),selectPais,rs.getString("fechaEmision"),rs.getString("fechaExpiracion"),selectTitular,selectCiudad);
	            	return p;
	            }
		}catch( SQLException e) {
			System.out.println("Error de lectura " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Pasaporte> selectAll(){
		List<Pasaporte> pasaportes = new ArrayList<>();
        String sql = "SELECT * FROM \"Pasaporte\"";
        try (Statement stmt = connection.createStatement()){
             ResultSet rs = stmt.executeQuery(sql); {
             while (rs.next()) {
                pasaportes.add(mapRStuPasaporte(rs));
             }
        }
        return pasaportes;
      
	}catch (SQLException e) {
		System.out.println("Error de lectura " + e.getMessage());
    }
    return null;
	}
	@Override
	public String Update(Pasaporte t) {
		String sql = "UPDATE \"Pasaporte\" SET \"paisEmisor\" = ?, \"fechaEmision\" = ?, \"fechaExpiracion\" = ?, \"titular\" = ?, \"ciudadEmision\" = ? WHERE \"numeroId\" = ?";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setInt(1, t.getPaisEmisor().getIdPais());
			
			pstmt.setString(2, t.getFechaEmision());
			
			pstmt.setString(3, t.getFechaExpiracion());
			
			pstmt.setString(4, t.getTitular().getIdentificacion());
			
			pstmt.setString(5, t.getCiudadEmision().getCodigoPostal());
			
			pstmt.setString(6, t.getNumeroId());
			
			pstmt.executeUpdate();
			
			return "Actualizacion exitosa!";
			
		}catch(SQLException e) {
			
			System.out.println("Error de actualizacion " + e.getMessage());
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public String Delete(Pasaporte t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Pasaporte mapRStuPasaporte(ResultSet rs) throws SQLException{
		Titular selectTitular = new Titular (rs.getString("titular")," ", " ");
    	Ciudad selectCiudad = new Ciudad(rs.getString("ciudadEmision"),"",false);
    	List <Ciudad> c = new ArrayList<Ciudad>();
    	Pais selectPais = new Pais (rs.getInt("paisEmisor"),"","",c);
    	Pasaporte p = new Pasaporte (rs.getString("numeroId"),selectPais,rs.getString("fechaEmision"),rs.getString("fechaExpiracion"),selectTitular,selectCiudad);
    	return p;
	}
}
