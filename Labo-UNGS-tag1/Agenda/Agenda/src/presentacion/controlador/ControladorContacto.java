package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import dto.LocalidadDTO;
import dto.TipoContactoDTO;
import modelo.Agenda;
import presentacion.vista.ContactoPanel;

public class ControladorContacto implements ActionListener{

	private ContactoPanel contacto;
	private Agenda agenda;
	
	public ControladorContacto(ContactoPanel contacto, Agenda agenda)
	{
		this.contacto = contacto;
		this.agenda = agenda;
		this.contacto.getBtnGuardar().addActionListener(this);
		
	}
	
	public void actualizarLocalidades()
	{
		this.contacto.getListaLocalidades().removeAllItems();
		List<LocalidadDTO> localidades = agenda.obtenerLocalidades();
		for(int i=0; i<localidades.size(); i++)
		{
			this.contacto.getListaLocalidades().addItem(localidades.get(i));
		}
	}
	
	public void actualizarTipoContactos()
	{
		this.contacto.getListaTipoContactos().removeAllItems();
		List<TipoContactoDTO> tipos = agenda.obtenerTipoContactos();
		for(int i=0; i<tipos.size(); i++)
		{
			this.contacto.getListaTipoContactos().addItem(tipos.get(i));
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
			
	}

}
