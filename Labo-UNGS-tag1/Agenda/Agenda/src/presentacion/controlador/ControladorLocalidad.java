package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dto.LocalidadDTO;
import modelo.Agenda;
import presentacion.vista.LocalidadPanel;

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
			if(this.local.getTxtNombreLocalidad().getText().length() > 0)
			{
				this.agenda.agregarLocalidad(new LocalidadDTO(0,local.getTxtNombreLocalidad().getText()));
				this.local.getTxtNombreLocalidad().setText("");
				this.control.actualizarDatosLocalidades();				
			}
		}	
		
		else if(e.getSource() == this.local.getBtnBorrar())
		{
			if(this.local.getListaLocalidad().getSelectedIndex() != -1)
			{
				this.agenda.borrarLocalidad(localidadesGuardadas.get(local.getListaLocalidad().getSelectedIndex()));
				this.control.actualizarDatosLocalidades();
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
		}
		
		else if(e.getSource() == this.local.getBtnGuardar())
		{
			String tipo = this.local.getTxtNombreLocalidad().getText();
			if(tipo.length() > 0 && !tipo.equals(local.getListaLocalidad().getItem(indiceModificar)))
			{
				this.local.getListaLocalidad().remove(indiceModificar);
				this.local.getListaLocalidad().add(tipo,indiceModificar);
			}
			this.mostrarUnGrupoDeBotones(true, false);
			local.getTxtNombreLocalidad().setText("");
		}
	}
	
	public void mostrarUnGrupoDeBotones(boolean verABM,boolean verEdicion)
	{
		local.getBtnAgregar().setVisible(verABM);
		local.getBtnBorrar().setVisible(verABM);
		local.getBtnModificar().setVisible(verABM);
		local.getBtnGuardar().setVisible(verEdicion);
		local.getBtnCancelar().setVisible(verEdicion);	
	}

}
