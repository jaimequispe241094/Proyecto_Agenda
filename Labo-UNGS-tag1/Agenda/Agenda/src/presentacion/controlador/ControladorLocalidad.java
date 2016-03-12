package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.vista.LocalidadPanel;

public class ControladorLocalidad implements ActionListener{

	
	private LocalidadPanel local;
	
	public ControladorLocalidad(LocalidadPanel localidadPanel) 
	{
		this.local = localidadPanel;
		this.local.getBtnAgregar().addActionListener(this);
		this.local.getBtnModificar().addActionListener(this);
		this.local.getBtnBorrar().addActionListener(this);
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
				this.local.getTxtNombreLocalidad().setText(local.getListaLocalidad().getSelectedItem());
			}
		}
	}

}
