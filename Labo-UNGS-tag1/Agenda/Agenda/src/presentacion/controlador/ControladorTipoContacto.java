package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.vista.TipoContactoPanel;

public class ControladorTipoContacto implements ActionListener
{

	private TipoContactoPanel tipoContacto;
	
	public ControladorTipoContacto(TipoContactoPanel panel)
	{
		this.tipoContacto = panel;
		this.tipoContacto.getBtnAgregar().addActionListener(this);
		this.tipoContacto.getBtnModificar().addActionListener(this);
		this.tipoContacto.getBtnBorrar().addActionListener(this);
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
				this.tipoContacto.getTxtTipoContacto().setText(tipoContacto.getListaTipoContactos().getSelectedItem());
			}
		}
		
	}

}
