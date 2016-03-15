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
		if(e.getSource() == contacto.getBtnGuardar())
		{			
			String nombre = contacto.getTxtNombre().getText();			
            String telefono = this.contacto.getTxtTelefono().getText();
			String email = this.contacto.getTxtEmail().getText();
			String calle = this.contacto.getTxtDireccion().getText();			
            String altura = this.contacto.getTxtNumero().getText();
            String piso = this.contacto.getTxtPiso().getText();
            String depto = this.contacto.getTxtDpto().getText();           
            DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
            String cumpleaños = fecha.format(contacto.getFechaCumpleaños().getDate());        
            LocalidadDTO localidad= (LocalidadDTO) this.contacto.getListaLocalidades().getSelectedItem();
            TipoContactoDTO tipo = (TipoContactoDTO) this.contacto.getListaTipoContactos().getSelectedItem();
        
            if(validarCampoVacios(nombre, telefono, calle, email) && validarObjetos(localidad, tipo) && validarNumeros(altura, piso, depto))
            {            	
            	 PersonaDTO persona = new PersonaDTO(0,nombre,telefono,calle,Integer.parseInt(altura),Integer.parseInt(piso),Integer.parseInt(depto),localidad,email,cumpleaños,tipo);
            	 this.agenda.agregarPersona(persona);
                 this.vaciarCampos();
                 this.control.llenarTabla();
            }
		}
        
	}
	
	public	boolean validarCampoVacios(String nombre,String telefono,String calle,String email)
	{
		if (nombre.length()<= 0 ||telefono.length()<=0 || calle.length()<=0 || email.length()<=0 )
		{
			JOptionPane.showMessageDialog(null, "No deben haber campos vacios", "Datos Incompletos", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}
	
	public boolean validarObjetos(LocalidadDTO localidad,TipoContactoDTO tipo){
		if(localidad == null || tipo == null)
		{
			JOptionPane.showMessageDialog(null, "Debe ingreser una Localidad y/o Tipo De Contacto", "Datos Incompletos", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}
	
	public boolean validarNumeros(String altura,String piso,String depto)
	{
		if( !esNumero(altura) || !esNumero(piso) || !esNumero(depto))
		{
			JOptionPane.showMessageDialog(null, "Debe ingreser valores numericos donde corresponda", "Datos Erroneos", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
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
		this.contacto.getTxtDpto().setText("");
	}

}
