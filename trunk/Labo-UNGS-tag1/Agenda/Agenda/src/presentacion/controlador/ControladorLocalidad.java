package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import dto.LocalidadDTO;
import modelo.Agenda;
import presentacion.vista.LocalidadPanel;
import util.AgendaUtil;

public class ControladorLocalidad implements ActionListener{

	private LocalidadPanel local;
	private Controlador control;
	private Agenda agenda;
	private List<LocalidadDTO> localidadesGuardadas;
	private int indiceModificar;
	
	public ControladorLocalidad(Controlador controlador) 
	{ 
		this.control = controlador;
		this.local = control.getVista().getLocalidadPanel();
		this.agenda = controlador.getAgenda();
		this.local.getBtnAgregar().addActionListener(this);
		this.local.getBtnModificar().addActionListener(this);
		this.local.getBtnBorrar().addActionListener(this);
		this.local.getBtnGuardar().addActionListener(this);
		this.local.getBtnCancelar().addActionListener(this);
		this.indiceModificar = -1;
	}
	
	public void cargarLocalidades()
	{
		this.local.getListaLocalidad().removeAll();
		localidadesGuardadas = agenda.obtenerLocalidades();
		for(int i=0; i<localidadesGuardadas.size(); i++)
		{
			String values = localidadesGuardadas.get(i).getNombre();
			local.getListaLocalidad().add(values);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.local.getBtnAgregar())
		{
			String localidad_a_agregar = local.getTxtNombreLocalidad().getText();
			if( localidad_a_agregar.length() > 0 )
			{
				if(!this.existeLocalidad(localidad_a_agregar))
				{
					this.agenda.agregarLocalidad( new LocalidadDTO(0,localidad_a_agregar));
					this.control.actualizarDatosLocalidades();				
				} else {
					JOptionPane.showMessageDialog(null, "¡La Localidad ya existe!","Mensaje de Aviso",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			this.local.getTxtNombreLocalidad().setText("");
		}	
		
		else if(e.getSource() == this.local.getBtnBorrar())
		{
			if(this.local.getListaLocalidad().getSelectedIndex() != -1)
			{	
				LocalidadDTO localidad = localidadesGuardadas.get(local.getListaLocalidad().getSelectedIndex());
				if(this.agenda.borrarLocalidad(localidad))
				{
					this.control.actualizarDatosLocalidades();
				} else {
					JOptionPane.showMessageDialog(null, "¡Usted no puede borrar este elemento porque esta en uso!", "ERROR AL INTENTAR ELIMINAR ELEMENTO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		
		else if (e.getSource() == this.local.getBtnModificar())
		{
			if(this.local.getListaLocalidad().getSelectedIndex() != -1)
			{
				this.mostrarUnGrupoDeBotones(false, true);
				this.local.getTxtNombreLocalidad().setText(local.getListaLocalidad().getSelectedItem());
				indiceModificar = this.local.getListaLocalidad().getSelectedIndex();
			}
		}
		
		else if(e.getSource() == this.local.getBtnCancelar())
		{
			this.mostrarUnGrupoDeBotones(true, false);
			local.getTxtNombreLocalidad().setText("");
			this.indiceModificar = -1;
		}
		
		else if(e.getSource() == this.local.getBtnGuardar())
		{
			String nombre_localidad = this.local.getTxtNombreLocalidad().getText();
			if(nombre_localidad.length() > 0 && !nombre_localidad.equals(local.getListaLocalidad().getItem(indiceModificar)))
			{	
				if(!existeLocalidad(nombre_localidad))
				{
					this.agenda.editarLocalidad(new LocalidadDTO(localidadesGuardadas.get(indiceModificar).getIdLocalidad(), nombre_localidad));
					this.control.actualizarDatosLocalidades();
					this.control.llenarTabla();
				} else {
				JOptionPane.showMessageDialog(null, "¡La localidad ya existe!","Mensaje de Aviso",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			this.mostrarUnGrupoDeBotones(true, false);
			local.getTxtNombreLocalidad().setText("");
			this.indiceModificar = -1;
		}
	}
	
	public boolean existeLocalidad(String local)
	{
		boolean ret = false;
		String localidad_a_agregar = AgendaUtil.limpiarCadena(local);
		String localidad_guardada;
		
		for (int i=0; i<localidadesGuardadas.size();i++)
		{
			   if(indiceModificar != i)
			   {
				   localidad_guardada = AgendaUtil.limpiarCadena(localidadesGuardadas.get(i).getNombre());
				   ret = ret || (localidad_guardada.equals(localidad_a_agregar));				
			   }
		}
		return ret;
	} 
	
	private void mostrarUnGrupoDeBotones(boolean verABM,boolean verEdicion)
	{
		local.getBtnAgregar().setVisible(verABM);
		local.getBtnBorrar().setVisible(verABM);
		local.getBtnModificar().setVisible(verABM);
		local.getBtnGuardar().setVisible(verEdicion);
		local.getBtnCancelar().setVisible(verEdicion);	
	}
}
