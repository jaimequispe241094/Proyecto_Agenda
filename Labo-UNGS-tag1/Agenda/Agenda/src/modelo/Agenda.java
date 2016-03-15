package modelo;

import java.util.List;
import persistencia.dao.LocalidadDAO;
import persistencia.dao.PersonaDAO;
import persistencia.dao.TipoContactoDAO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoContactoDTO;

public class Agenda 
{
	private PersonaDAO persona;	
	private LocalidadDAO localidad;
	private TipoContactoDAO tipoContacto;
	
	public Agenda()
	{
		persona = new PersonaDAO();
		localidad = new LocalidadDAO();
		tipoContacto = new TipoContactoDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		persona.insert(nuevaPersona);
	}

	public void agregarLocalidad(LocalidadDTO nuevaLocalidad)
	{
		localidad.insert(nuevaLocalidad);
	}
	
	public void agregarTipoContacto(TipoContactoDTO nuevoTipo)
	{
		tipoContacto.insert(nuevoTipo);
	}
	
	public void editarPersona(PersonaDTO persona_a_editar)
	{
		persona.update(persona_a_editar);
	}
	
	public void editarLocalidad(LocalidadDTO localidad_a_editar)
	{
		localidad.update(localidad_a_editar);
	}
	
	public void editarTipoContacto(TipoContactoDTO tipo_a_editar)
	{
		tipoContacto.update(tipo_a_editar);
	}
	
	public void borrarPersona(PersonaDTO persona_a_eliminar) 
	{
		persona.delete(persona_a_eliminar);
	}
	
	public boolean borrarLocalidad(LocalidadDTO localidad_a_eliminar)
	{
		return localidad.delete(localidad_a_eliminar);
	}
	
	public boolean borrarTipoContacto(TipoContactoDTO tipo_a_eliminar)
	{
		return tipoContacto.delete(tipo_a_eliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return persona.readAll();		
	}
	
	public List<LocalidadDTO> obtenerLocalidades()
	{
		return localidad.readAll();
	}
	
	public List<TipoContactoDTO> obtenerTipoContactos()
	{
		return tipoContacto.readAll();
	}
}
