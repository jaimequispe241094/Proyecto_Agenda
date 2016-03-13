package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import dto.TipoContactoDTO;



public class TipoContactoDAO 
{
	private static final String insert = "INSERT INTO personas(idTipo, nombre) VALUES(?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idTipo = ?";
	private static final String readall = "SELECT * FROM personas";
	private static final Conexion conexion = Conexion.getConexion();
	
	public boolean insert(TipoContactoDTO tipo)
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, tipo.getIdTipoContacto());
			statement.setString(2, tipo.getNombre());
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
	
	public boolean delete(TipoContactoDTO tipo_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(tipo_a_eliminar.getIdTipoContacto()));
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecut� devuelvo true
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
	
	public List<TipoContactoDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<TipoContactoDTO> tipos = new ArrayList<TipoContactoDTO>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				tipos.add(new TipoContactoDTO(resultSet.getInt("idTipo"), resultSet.getString("Nombre")));
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
		return tipos;
	}
}
