package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoContactoDTO;
import modelo.Agenda;
import presentacion.vista.ContactoPanel;

public class ControladorContacto implements ActionListener{

	private ContactoPanel contacto;
	private Controlador control;
	private Agenda agenda;
	
	public ControladorContacto(Controlador control)
	{
		this.control = control;
		this.contacto = control.getVista().getContactoPanel();
		this.agenda = control.getAgenda();
		this.contacto.getBtnAgregar().addActionListener(this);
		this.contacto.getBtnGuardar().addActionListener(this);
		this.contacto.getBtnCancelar().addActionListener(this);
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
		if(e.getSource() == contacto.getBtnAgregar())
		{			
			PersonaDTO personaDTO = mapeoPersonaDTO();
     
            if(this.validacion(personaDTO))
            {                  	
            	 this.agenda.agregarPersona(personaDTO);
                 this.vaciarCampos();
                 this.control.llenarTabla();
            }
		}
		
		else if(e.getSource() == this.contacto.getBtnCancelar())
		{
			this.visualizarBotonesEdicion(false);
			this.vaciarCampos();
		}
        
		else if(e.getSource() == this.contacto.getBtnGuardar())
		{
			PersonaDTO personaDTO = mapeoPersonaDTO();
            int idSeleccionado = this.control.contactoSeleccionado().getIdPersona();
            personaDTO.setIdPersona(idSeleccionado);
            
            if(this.validacion(personaDTO))
            {                 	 
            	 this.agenda.editarPersona(personaDTO);
                 this.vaciarCampos();
                 this.visualizarBotonesEdicion(false);
                 this.control.llenarTabla();
            }
		}
	}
	
	public	boolean validacion(PersonaDTO p)
	{
		boolean ret = true;
		if (p.getNombre().length()<= 0 ||p.getTelefono().length()<=0 || p.getCalle().length()<=0 || p.getEmail().length()<=0 )
		{
			JOptionPane.showMessageDialog(null, "No deben haber campos vacios", "Datos Incompletos", JOptionPane.INFORMATION_MESSAGE);
			ret = false;
		}
	
		if(p.getLocalidad() == null || p.getTipoContacto() == null)
		{
			JOptionPane.showMessageDialog(null, "Debe ingreser una Localidad y/o Tipo De Contacto", "Datos Incompletos", JOptionPane.INFORMATION_MESSAGE);
			ret = false;
		}
	
		if( !esNumero(p.getAltura()) || !esNumero(p.getPiso()) || !esNumero(p.getDepto()) || !esNumero(p.getTelefono()))
		{
			JOptionPane.showMessageDialog(null, "Debe ingreser valores numericos donde corresponda", "Datos Erroneos", JOptionPane.INFORMATION_MESSAGE);
			ret = false;
		}
		return ret;
	}		
	
	private boolean esNumero(String valor)
	{
		try 
		{
			Integer.parseInt(valor);
			return true;
		} 
		catch (NumberFormatException e)
		{
			return false;
		}
	}
	
	public void vaciarCampos()
	{
		this.contacto.getTxtNombre().setText("");
		this.contacto.getTxtTelefono().setText("");
		this.contacto.getTxtDireccion().setText("");
		this.contacto.getTxtEmail().setText("");
		this.contacto.getTxtNumero().setText("");
		this.contacto.getTxtPiso().setText("");
		this.contacto.getTxtDepto().setText("");
	}


	
	public PersonaDTO mapeoPersonaDTO()
	{
		String nombre = contacto.getTxtNombre().getText();			
        String telefono = this.contacto.getTxtTelefono().getText();
		String email = this.contacto.getTxtEmail().getText();
		String calle = this.contacto.getTxtDireccion().getText();			
        String altura = this.contacto.getTxtNumero().getText();
        String piso = this.contacto.getTxtPiso().getText();
        String depto = this.contacto.getTxtDepto().getText();           
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        String cumpleaños = fecha.format(contacto.getFechaCumpleaños().getDate());        
        LocalidadDTO localidad= (LocalidadDTO) this.contacto.getListaLocalidades().getSelectedItem();
        TipoContactoDTO tipo = (TipoContactoDTO) this.contacto.getListaTipoContactos().getSelectedItem();
        
        return new PersonaDTO(0, nombre, telefono, calle, altura, piso, depto, localidad, email, cumpleaños, tipo);
	}	
	
	public void visualizarBotonesEdicion(boolean valor)
	{
		this.contacto.getBtnCancelar().setVisible(valor);
		this.contacto.getBtnGuardar().setVisible(valor);
		this.contacto.getBtnAgregar().setVisible(!valor);
	}

}
