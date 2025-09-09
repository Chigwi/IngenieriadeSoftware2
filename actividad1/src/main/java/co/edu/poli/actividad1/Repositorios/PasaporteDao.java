package co.edu.poli.actividad1.Repositorios;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.actividad1.Modelo.Ciudad;
import co.edu.poli.actividad1.Modelo.PDiplomatico;
import co.edu.poli.actividad1.Modelo.POrdinario;
import co.edu.poli.actividad1.Modelo.Pais;
import co.edu.poli.actividad1.Modelo.Pasaporte;
import co.edu.poli.actividad1.Modelo.Titular;

import java.sql.*;

public class PasaporteDao implements DaoEx <Pasaporte>{

	private Connection connection;
	
	public PasaporteDao () {
	}
	
	public Connection getConnection() {
		return connection;
	}
	
//holi
	public void setConnection(Connection connection) {
		this.connection = connection;
	}



	@Override
	public String insert(Pasaporte t){
		String sql = "INSERT INTO \"Pasaporte\" (\"numeroId\", \"paisEmisor\", \"fechaEmision\", \"fechaExpiracion\", titular, \"ciudadEmision\") VALUES (?, ?, ?, ?, ?, ?)";
		String sql1 = "INSERT INTO \"POrdinario\"(\"numeroId\",\"razonViaje\")VALUES (?, ?)";
		String sql2 = "INSERT INTO \"PDiplomatico\"(\"numeroId\",\"misionDiplomatica\")VALUES (?, ?)";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setString(1, t.getNumeroId());
			
			pstmt.setString(2, t.getPaisEmisor().getIdPais());
			
			pstmt.setString(3, t.getFechaEmision());
			
			pstmt.setString(4, t.getFechaExpiracion());
			
			pstmt.setString(5, t.getTitular().getIdentificacion());
			
			pstmt.setString(6, t.getCiudadEmision().getCodigoPostal());
			
			pstmt.executeUpdate();
			
			if(t instanceof POrdinario) {
				POrdinario p = (POrdinario) t;
				try(PreparedStatement pstmt1 = connection.prepareStatement(sql1)){
					pstmt1.setString(1, p.getNumeroId());
					pstmt1.setString(2, p.getRazonViaje());
				}
				
			}
			else if(t instanceof PDiplomatico) {
				PDiplomatico p = (PDiplomatico) t;
				try(PreparedStatement pstmt2 = connection.prepareStatement(sql2)){
					pstmt2.setString(1, p.getNumeroId());
					pstmt2.setString(2, p.getMisionDiplomatica());
				}
			}
			else {
				return "Tipo de pasaporte desconocido";
			}
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
	            	
	            	Pasaporte p = mapRStuPasaporte(rs);
	            	
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
		
		String sql1 = "UPDATE \"POrdinario\" SET \"razonViaje\" = ? WHERE \"numeroId\" = ? ";
		
		String sql2 = "UPDATE \"PDiplomatico\" SET \"misionDiplomatica\" = ? WHERE \"numeroId\" = ? ";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.setString(1, t.getPaisEmisor().getIdPais());
			
			pstmt.setString(2, t.getFechaEmision());
			
			pstmt.setString(3, t.getFechaExpiracion());
			
			pstmt.setString(4, t.getTitular().getIdentificacion());
			
			pstmt.setString(5, t.getCiudadEmision().getCodigoPostal());
			
			pstmt.setString(6, t.getNumeroId());
			
			pstmt.executeUpdate();
			
			if(t instanceof POrdinario) {
				POrdinario p = (POrdinario) t;
				try(PreparedStatement pstmt1 = connection.prepareStatement(sql1)){
					pstmt1.setString(1, p.getRazonViaje() );
					pstmt1.setString(2, p.getNumeroId());
				}
				
			}
			else if(t instanceof PDiplomatico) {
				PDiplomatico p = (PDiplomatico) t;
				try(PreparedStatement pstmt2 = connection.prepareStatement(sql2)){
					pstmt2.setString(1, p.getMisionDiplomatica());
					pstmt2.setString(2, p.getNumeroId());
				}
			}
			else {
				return "Tipo de pasaporte desconocido";
			}
			
			return "Actualizacion exitosa!";
			
		}catch(SQLException e) {
			
			System.out.println("Error de actualizacion " + e.getMessage());
			e.printStackTrace();
			
		}
		return "Error de actualizacion";
	}

	@Override
	public String Delete(Pasaporte t) {
		
		String sql = "DELETE FROM \"Pasaporte\" WHERE \"numeroId\" = ?" ;
		
		String sql1 = "DELETE FROM \"POrdinario\" WHERE \"numeroId\" = ? ";
		
		String sql2 = "DELETE FROM \"PDiplomatico\" WHERE \"numeroId\" = ? ";
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, t.getNumeroId());
            pstmt.executeUpdate();
            
            if(t instanceof POrdinario) {
				POrdinario p = (POrdinario) t;
				try(PreparedStatement pstmt1 = connection.prepareStatement(sql1)){
					pstmt1.setString(1, p.getNumeroId());
				}
				
			}
			else if(t instanceof PDiplomatico) {
				PDiplomatico p = (PDiplomatico) t;
				try(PreparedStatement pstmt2 = connection.prepareStatement(sql2)){
					pstmt2.setString(1, p.getNumeroId());
				}
			}
			else {
				return "Tipo de pasaporte desconocido";
			}
            
            return "eliminacion exitosa";
        }catch(SQLException e) {
			
			System.out.println("Error de eliminacion " + e.getMessage());
			e.printStackTrace();
			
        }
		return "Error de eliminacion ";
		//comentario
	}
	
	public List<Pasaporte> selectIdFiltered(String condicion) {
	    List<Pasaporte> pasaportes = new ArrayList<>();
	    String sql = "SELECT * FROM \"Pasaporte\" WHERE \"numeroId\" LIKE ?";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, "%" + condicion + "%");
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            pasaportes.add(mapRStuPasaporte(rs));
	        }
	        return pasaportes;
	    } catch (SQLException e) {
	        System.out.println("Error de lectura " + e.getMessage());
	    }
	    return null;
	}
	
	private Pasaporte mapRStuPasaporte(ResultSet rs) throws SQLException{
		TitularDao regtit = new TitularDao();
		regtit.setConnection(connection);
		
		CiudadDao regCiu = new CiudadDao();
		regCiu.setConnection(connection);
		
		PaisDao regPais = new PaisDao();
		regPais.setConnection(connection);
		
		Titular selectTitular = regtit.select(rs.getString("Titular"));
		
    	Ciudad selectCiudad = regCiu.select(rs.getString("ciudadEmision"));
    	
    	List <Ciudad> c = new ArrayList<Ciudad>();
    	
    	c.add(selectCiudad);
    	
    	Pais selectPais = regPais.select(rs.getString("paisEmisor"));
    	
    	selectPais.setCiudades(c);
    	
    	//Pasaporte p = new Pasaporte (rs.getString("numeroId"),selectPais,rs.getString("fechaEmision"),rs.getString("fechaExpiracion"),selectTitular,selectCiudad);
    	
    	//arreglar despues de haber cambiado el crud por las herencias
    	return null;
	}
}
