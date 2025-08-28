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
import co.edu.poli.actividad1.Modelo.Visa;

public class VisaDao implements Dao <Visa>{
	
	private Connection connection;
	
	public VisaDao () {
	}
	
	public Connection getConnection() {
		return connection;
	}



	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public String insert(Visa t) {
		String sql = "INSERT INTO \"Visa\" (\"idVisa\", \"paisDestino\", \"fechaEmision\", \"fechaExpiracion\", pasaporte) VALUES(?, ?, ?, ?, ?)";
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setString(1, t.getIdVisa());
			
			pstmt.setString(2, t.getPaisDestino().getIdPais());
			
			pstmt.setString(3, t.getFechaEmision());
			
			pstmt.setString(4, t.getFechaExpiracion());
			
			pstmt.setString(5, t.getPasaporte().getNumeroId());
			
			pstmt.executeUpdate();
			
			return "Insercion exitosa!";
			
		}catch(SQLException e) {
			
			System.out.println("Error de insercion " + e.getMessage());
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public Visa select(String id) {
String sql = "SELECT * FROM \"Visa\" WHERE \"idVisa\" = ?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			
			 ResultSet rs = pstmt.executeQuery();
			 
	            if (rs.next()) {
	            	Visa v = mapRStoVisa(rs);
	            	
	            	return v;
	            }
		}catch( SQLException e) {
			System.out.println("Error de lectura " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Visa> selectAll() {
		List <Visa> Visas = new ArrayList <Visa>();
		String sql = "SELECT * FROM \"Visa\"";
		try (Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(sql); {
            while (rs.next()) {
               Visas.add(mapRStoVisa(rs));
            }
       }
       return Visas;
     
	}catch (SQLException e) {
		System.out.println("Error de lectura " + e.getMessage());
   }
   return null;
	}

	@Override
	public String Update(Visa t) {
		String sql = "UPDATE \"Visa\" SET \"paisDestino\" = ?, \"fechaEmision\" = ?, \"fechaExpiracion\" = ?, pasaporte = ? WHERE \"idVisa\" = ?";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			
			pstmt.setString(1, t.getPaisDestino().getIdPais());
			
			pstmt.setString(2, t.getFechaEmision());
			
			pstmt.setString(3, t.getFechaExpiracion());
			
			pstmt.setString(4, t.getPasaporte().getNumeroId());
			
			pstmt.setString(5, t.getIdVisa());
			
			pstmt.executeUpdate();
			
			return "Actualizacion exitosa!";
			
		}catch(SQLException e) {
			
			System.out.println("Error de actualizacion " + e.getMessage());
			e.printStackTrace();
			
		}
		return "Error de actualizacion";
	}

	@Override
	public String Delete(Visa t) {
		String sql = "DELETE FROM \"Visa\" WHERE \"idVisa\" = ?" ;
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, t.getIdVisa());
            pstmt.executeUpdate();
            
            return "eliminacion exitosa";
        }catch(SQLException e) {
			
			System.out.println("Error de eliminacion " + e.getMessage());
			e.printStackTrace();
			
        }
		return "Error de eliminacion ";
	}

	
	private Visa mapRStoVisa (ResultSet rs) throws SQLException {
		PasaporteDao regpass = new PasaporteDao();
		regpass.setConnection(connection);
		PaisDao regPais = new PaisDao();
		regPais.setConnection(connection);
		CiudadDao regCiu = new CiudadDao();
		regCiu.setConnection(connection);
		
		Pasaporte pass = regpass.select(rs.getString("pasaporte"));
		
		Ciudad ciu = regpass.select(rs.getString("pasaporte")).getCiudadEmision();
		
		List <Ciudad> c = new ArrayList<Ciudad>();
    	
    	c.add(ciu);
    	
    	Pais selectPais = regPais.select(rs.getString("paisDestino"));
    	
    	selectPais.setCiudades(c);
    	
    	Visa v = new Visa (rs.getString("idVisa"),selectPais,rs.getString("fechaEmision"),rs.getString("fechaExpiracion"),pass);
		
		return v;
	}

}
