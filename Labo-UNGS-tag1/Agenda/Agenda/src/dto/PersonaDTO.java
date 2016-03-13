package dto;

import java.sql.Date;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private DomicilioDTO domicilio;
	private String email;
	private Date Cumpleaños;
	private TipoContactoDTO tipoContacto;

	public PersonaDTO(int idPersona, String nombre, String telefono)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
	}	
	
	public PersonaDTO(int idPersona, String nombre, String telefono,
			DomicilioDTO domicilio, String email, Date cumpleaños,
			TipoContactoDTO tipoContacto) 
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.email = email;
		this.Cumpleaños = cumpleaños;
		this.tipoContacto = tipoContacto;
	}
	
	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}

	public DomicilioDTO getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCumpleaños() {
		return Cumpleaños;
	}

	public void setCumpleaños(Date cumpleaños) {
		Cumpleaños = cumpleaños;
	}

	public TipoContactoDTO getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContactoDTO tipoContacto) {
		this.tipoContacto = tipoContacto;
	}	
	
}
