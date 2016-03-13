package dto;

public class TipoDeContactoDTO {
	
	private int idTipoDeContacto;
	private String nombre;
	
	public TipoDeContactoDTO(int idTipoDeContacto, String nombre) 
	{
		this.idTipoDeContacto = idTipoDeContacto;
		this.nombre = nombre;
	}

	public int getIdTipoDeContacto() {
		return idTipoDeContacto;
	}

	public void setIdTipoDeContacto(int idTipoDeContacto) {
		this.idTipoDeContacto = idTipoDeContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
