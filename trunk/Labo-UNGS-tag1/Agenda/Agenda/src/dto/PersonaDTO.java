package dto;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String calle;
	private int altura;
	private int piso;
	private int depto;
	private LocalidadDTO localidad;
	private String email;
	private String cumpleaños;
	private TipoContactoDTO tipoContacto;

	public PersonaDTO(int idPersona, String nombre, String telefono)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
	}	
		
	public PersonaDTO(int idPersona, String nombre, String telefono,String calle, int altura, int piso, int depto,LocalidadDTO localidad, String email, String cumpleaños,
			TipoContactoDTO tipoContacto) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.depto = depto;
		this.localidad = localidad;
		this.email = email;
		this.cumpleaños = cumpleaños;
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

	public String getCalle() 
	{
		return calle;
	}

	public void setCalle(String calle) 
	{
		this.calle = calle;
	}

	public int getAltura() 
	{
		return altura;
	}

	public void setAltura(int altura) 
	{
		this.altura = altura;
	}

	public int getPiso() 
	{
		return piso;
	}

	public void setPiso(int piso) 
	{
		this.piso = piso;
	}

	public int getDepto() 
	{
		return depto;
	}

	public void setDepto(int depto) 
	{
		this.depto = depto;
	}

	public LocalidadDTO getLocalidad() 
	{
		return localidad;
	}

	public void setLocalidad(LocalidadDTO localidad) 
	{
		this.localidad = localidad;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getCumpleaños() 
	{
		return cumpleaños;
	}

	public void setCumpleaños(String cumpleaños) 
	{
		this.cumpleaños = cumpleaños;
	}

	public TipoContactoDTO getTipoContacto() 
	{
		return tipoContacto;
	}

	public void setTipoContacto(TipoContactoDTO tipoContacto) 
	{
		this.tipoContacto = tipoContacto;
	}	
	
}
