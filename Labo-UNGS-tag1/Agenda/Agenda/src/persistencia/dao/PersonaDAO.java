package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import dto.PersonaDTO;

public class PersonaDAO 
{
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono, calle, altura, piso, depto, localidad, email, cumpleaños, tipoContacto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM personas";
	private static final Conexion conexion = Conexion.getConexion();
	
	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			
			statement.setString(4, persona.getCalle());			
			statement.setInt(5, persona.getAltura());
			statement.setInt(6, persona.getPiso());
			statement.setInt(7, persona.getDepto());
			statement.setInt(8, persona.getLocalidad().getIdLocalidad());
			statement.setString(9, persona.getEmail());
			statement.setDate(10, persona.getCumpleaños());
			statement.setInt(11, persona.getTipoContacto().getIdTipoContacto());			
			
			if(statement.executeUpdate() > 0) //Si se ejecutï¿½ devuelvo true
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
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecutï¿½ devuelvo true
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
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				personas.add(new PersonaDTO(resultSet.getInt("idPersona"), resultSet.getString("Nombre"), resultSet.getString("Telefono"), resultSet.getString("Calle"), resultSet.getInt("Altura"), resultSet.getInt("Piso"), resultSet.getInt("Depto"),
						LocalidadDAO.getLocalidadDTO(resultSet.getInt("Localidad")),
						resultSet.getString("Email"), resultSet.getDate("Cumpleaños"),
						TipoContactoDAO.getTipoContactoDTO(resultSet.getInt("TipoContacto"))));
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
		return personas;
	}
	
	public boolean update(PersonaDTO persona)
	{
		PreparedStatement statement;
		try 
		{
			//String modUptade = "update persona set nombre='" + persona.getNombre()+ "'," + " where idLocalidad="+persona.getIdPersona();
			//calle, altura, piso, depto, localidad, email, cumpleaños, tipoContacto
			String modUptade = "update persona set nombre='" + persona.getNombre()
					+"'," +"telefono=" + persona.getTelefono()
					+"'," +"calle=" + persona.getCalle()
					+"'," +"altura=" + persona.getAltura()
					+"'," +"piso=" + persona.getPiso()
					+"'," +"depto=" + persona.getDepto()
					+"'," +"localidad=" + persona.getLocalidad()
					+"'," +"email=" + persona.getEmail()
					+"'," +"cumpleaños=" + persona.getCumpleaños()
					+"'," +"tipoContacto=" + persona.getTipoContacto()
					+"'" + " where idLocalidad="+persona.getIdPersona();
			
			
			
			statement = conexion.getSQLConexion().prepareStatement(modUptade);
			if(statement.executeUpdate() > 0) //Si se ejecutï¿½ devuelvo true
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
