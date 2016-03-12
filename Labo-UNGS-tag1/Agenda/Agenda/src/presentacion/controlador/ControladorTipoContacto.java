package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.vista.TipoContactoPanel;

public class ControladorTipoContacto implements ActionListener
{

	private TipoContactoPanel tipoContacto;
	private int indiceModificar ;
	
	
	public ControladorTipoContacto(TipoContactoPanel panel)
	{
		this.tipoContacto = panel;
		this.tipoContacto.getBtnAgregar().addActionListener(this);
		this.tipoContacto.getBtnModificar().addActionListener(this);
		this.tipoContacto.getBtnBorrar().addActionListener(this);
		this.tipoContacto.getBtnGuardar().addActionListener(this);
		this.tipoContacto.getBtnCancelar().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		
		
		if(e.getSource() == this.tipoContacto.getBtnAgregar())
		{
			if(this.tipoContacto.getTxtTipoContacto().getText().length() > 0)
			{
				this.tipoContacto.getListaTipoContactos().add(tipoContacto.getTxtTipoContacto().getText());
				this.tipoContacto.getTxtTipoContacto().setText("");
			}
		}	
		
		else if(e.getSource() == this.tipoContacto.getBtnBorrar())
		{
			if(this.tipoContacto.getListaTipoContactos().getSelectedIndex() != -1)
			{
				this.tipoContacto.getListaTipoContactos().remove(tipoContacto.getListaTipoContactos().getSelectedIndex());
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
		}
		
		else if(e.getSource() == this.tipoContacto.getBtnGuardar())
		{
			String tipo = this.tipoContacto.getTxtTipoContacto().getText();
			if(tipo.length() > 0 && !tipo.equals(tipoContacto.getListaTipoContactos().getItem(indiceModificar)))
			{
				this.tipoContacto.getListaTipoContactos().remove(indiceModificar);
				this.tipoContacto.getListaTipoContactos().add(tipo,indiceModificar);
			}
			this.mostrarUnGrupoDeBotones(true, false);
			tipoContacto.getTxtTipoContacto().setText("");
		}
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
