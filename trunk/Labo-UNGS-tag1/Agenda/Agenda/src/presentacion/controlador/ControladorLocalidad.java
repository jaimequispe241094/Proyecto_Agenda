package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.vista.LocalidadPanel;

public class ControladorLocalidad implements ActionListener{

	private LocalidadPanel local;
	private int indiceModificar;
	
	public ControladorLocalidad(LocalidadPanel localidadPanel) 
	{
		this.local = localidadPanel;
		this.local.getBtnAgregar().addActionListener(this);
		this.local.getBtnModificar().addActionListener(this);
		this.local.getBtnBorrar().addActionListener(this);
		this.local.getBtnGuardar().addActionListener(this);
		this.local.getBtnCancelar().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.local.getBtnAgregar())
		{
			if(this.local.getTxtNombreLocalidad().getText().length() > 0)
			{
				this.local.getListaLocalidad().add(local.getTxtNombreLocalidad().getText());
				this.local.getTxtNombreLocalidad().setText("");
			}
		}	
		
		else if(e.getSource() == this.local.getBtnBorrar())
		{
			if(this.local.getListaLocalidad().getSelectedIndex() != -1)
			{
				this.local.getListaLocalidad().remove(local.getListaLocalidad().getSelectedIndex());
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
