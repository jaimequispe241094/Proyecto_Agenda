package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import dto.TipoContactoDTO;
import modelo.Agenda;
import presentacion.vista.TipoContactoPanel;
import util.AgendaUtil;

public class ControladorTipoContacto implements ActionListener
{
	private TipoContactoPanel tipoContacto;
	private Controlador control;
	private int indiceModificar ;
	private Agenda agenda;
	private List<TipoContactoDTO> tipoContactosGuardados;
	
	public ControladorTipoContacto(Controlador controlador)
	{
		this.control = controlador;
		this.tipoContacto = control.getVista().getTipoContactoPanel();
		this.agenda = control.getAgenda();
		this.tipoContacto.getBtnAgregar().addActionListener(this);
		this.tipoContacto.getBtnModificar().addActionListener(this);
		this.tipoContacto.getBtnBorrar().addActionListener(this);
		this.tipoContacto.getBtnGuardar().addActionListener(this);
		this.tipoContacto.getBtnCancelar().addActionListener(this);
		this.indiceModificar = -1;
	}
	
	public void cargarTiposContactos()
	{
		this.tipoContacto.getListaTipoContactos().removeAll();
		tipoContactosGuardados = agenda.obtenerTipoContactos();
		for(int i=0; i<tipoContactosGuardados.size(); i++)
		{
			String values = tipoContactosGuardados.get(i).getNombre();
			tipoContacto.getListaTipoContactos().add(values);		
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{		
		if(e.getSource() == this.tipoContacto.getBtnAgregar())
		{
			String tipoContacto_a_agregar = this.tipoContacto.getTxtTipoContacto().getText();
			if(tipoContacto_a_agregar.length() > 0)
			{
				if(!existeTipoContacto(tipoContacto_a_agregar))
				{
					this.agenda.agregarTipoContacto(new TipoContactoDTO(0, tipoContacto_a_agregar));					
					this.control.actualizarDatosTipoContactos();
				} else {
					JOptionPane.showMessageDialog(null, "¡El tipo de contacto ya existe!","Mensaje de Aviso",JOptionPane.INFORMATION_MESSAGE);
				}
				this.tipoContacto.getTxtTipoContacto().setText("");
			}
		}	
		
		else if(e.getSource() == this.tipoContacto.getBtnBorrar())
		{
			if(this.tipoContacto.getListaTipoContactos().getSelectedIndex() != -1)
			{
				TipoContactoDTO tipo = tipoContactosGuardados.get(tipoContacto.getListaTipoContactos().getSelectedIndex());
				if(this.agenda.borrarTipoContacto(tipo))
				{
					this.control.actualizarDatosTipoContactos();
				} else{
					JOptionPane.showMessageDialog(null, "¡Usted no puede borrar este elemento porque esta en uso!", "ERROR AL INTENTAR ELIMINAR ELEMENTO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		
		else if (e.getSource() == this.tipoContacto.getBtnModificar())
		{
			if(this.tipoContacto.getListaTipoContactos().getSelectedIndex() != -1)
			{
				this.mostrarUnGrupoDeBotones(false, true);
				this.tipoContacto.getTxtTipoContacto().setText(tipoContacto.getListaTipoContactos().getSelectedItem());
				indiceModificar = this.tipoContacto.getListaTipoContactos().getSelectedIndex();
			}
		}
		
		else if(e.getSource() == this.tipoContacto.getBtnCancelar())
		{
			this.mostrarUnGrupoDeBotones(true, false);
			tipoContacto.getTxtTipoContacto().setText("");
			this.indiceModificar = -1;
		}
		
		else if(e.getSource() == this.tipoContacto.getBtnGuardar())
		{
			String tipo = this.tipoContacto.getTxtTipoContacto().getText();
			if(tipo.length() > 0 && !tipo.equals(tipoContacto.getListaTipoContactos().getItem(indiceModificar)))
			{
				if(!existeTipoContacto(tipo))
				{
					this.agenda.editarTipoContacto((new TipoContactoDTO(tipoContactosGuardados.get(indiceModificar).getIdTipoContacto(), tipo)));
					this.control.actualizarDatosTipoContactos();
					this.control.llenarTabla();
				} else {
					JOptionPane.showMessageDialog(null, "¡El tipo de contacto ya existe!","Mensaje de Aviso",JOptionPane.INFORMATION_MESSAGE);
				}	
			}
			this.mostrarUnGrupoDeBotones(true, false);
			tipoContacto.getTxtTipoContacto().setText("");
			this.indiceModificar = -1;
		}
	}
	
	public boolean existeTipoContacto(String tipo)
	{
		boolean ret = false;
		String tipoContacto_a_agregar = AgendaUtil.limpiarCadena(tipo);
		String tipoContacto_guardado;
		
		for (int i=0; i<tipoContactosGuardados.size();i++)
		{
			   if(indiceModificar != i)
			   {
				   tipoContacto_guardado = AgendaUtil.limpiarCadena(tipoContactosGuardados.get(i).getNombre());
				   ret = ret || (tipoContacto_guardado.equals(tipoContacto_a_agregar));				
			   }
		}
		return ret;
	} 
		
	public void mostrarUnGrupoDeBotones(boolean verABM,boolean verEdicion)
	{
		tipoContacto.getBtnAgregar().setVisible(verABM);
		tipoContacto.getBtnBorrar().setVisible(verABM);
		tipoContacto.getBtnModificar().setVisible(verABM);
		tipoContacto.getBtnGuardar().setVisible(verEdicion);
		tipoContacto.getBtnCancelar().setVisible(verEdicion);	
	}
}
