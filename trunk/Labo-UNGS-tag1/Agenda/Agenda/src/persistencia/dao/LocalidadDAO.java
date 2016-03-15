package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.LocalidadDTO;
import persistencia.conexion.Conexion;

public class LocalidadDAO {
	
	
	private static final String insert = "INSERT INTO localidad(idLocalidad, nombre) VALUES(?, ?)";
	private static final String delete = "DELETE FROM localidad WHERE idLocalidad = ?";
	private static final String readall = "SELECT * FROM localidad";
	private static final Conexion conexion = Conexion.getConexion();
	
	public boolean insert(LocalidadDTO localidad)
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, localidad.getIdLocalidad());
			statement.setString(2, localidad.getNombre());
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}
	
	public boolean delete(LocalidadDTO localidad_a_eliminar)
	{
		PreparedStatement statement;
		PreparedStatement statement_dos;
		ResultSet result;
		int chequeoUpdate=0;
		try 
		{	
			int idLocalidad = localidad_a_eliminar.getIdLocalidad();
			String join = "SELECT * FROM personas p, localidad l WHERE p.localidad = " + idLocalidad;
			statement_dos = conexion.getSQLConexion().prepareStatement(join); 
			result = statement_dos.executeQuery();
			if(!result.next())
			{
				statement = conexion.getSQLConexion().prepareStatement(delete);			
				statement.setString(1, Integer.toString(idLocalidad));
				chequeoUpdate = statement.executeUpdate();
				if(chequeoUpdate > 0){ //Si se ejecut� devuelvo true
					return true;
				}
			}
			return false;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}
	
	public List<LocalidadDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<LocalidadDTO> localidades = new ArrayList<LocalidadDTO>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				localidades.add(new LocalidadDTO(resultSet.getInt("idLocalidad"), resultSet.getString("nombre")));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return localidades;
	}
	public static LocalidadDTO getLocalidadDTO(int id)
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		LocalidadDTO localidad = null;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement("SELECT * FROM localidad WHERE idLocalidad = "+Integer.toString(id));
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				localidad = new LocalidadDTO(resultSet.getInt("idLocalidad"), resultSet.getString("nombre"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return localidad;
	
	}
	
	public boolean update(LocalidadDTO localidad)
	{
		PreparedStatement statement;
		try 
		{
			String modUptade = "update localidad set nombre='" + localidad.getNombre()+ "'" + " where idLocalidad="+localidad.getIdLocalidad();
			statement = conexion.getSQLConexion().prepareStatement(modUptade);
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}

}
