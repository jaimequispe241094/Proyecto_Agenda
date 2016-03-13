package dto;

public class TipoContactoDTO {
	
	private int idTipo;
	private String nombre;
	
	public TipoContactoDTO(int idTipo, String nombre) 
	{
		this.idTipo = idTipo;
		this.nombre = nombre;
	}

	public int getIdTipoContacto() {
		return idTipo;
	}

	public void setIdTipoContacto(int idTipoContacto) {
		this.idTipo = idTipoContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
