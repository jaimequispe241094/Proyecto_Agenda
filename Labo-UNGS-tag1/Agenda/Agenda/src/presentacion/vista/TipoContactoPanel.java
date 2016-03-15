package presentacion.vista;

import java.awt.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TipoContactoPanel extends JPanel
{
	private JTextField txtTipoContacto;
	private List listaTipoContactos;
	private JButton btnAgregar;
	private JButton btnBorrar;	
	private JButton btnModificar;
	private JButton btnGuardar;	
	private JButton btnCancelar;
	
	public TipoContactoPanel()
	{
		iniciar();
	}
	
	public void iniciar()
	{
		JLabel lblTipo_1 = new JLabel("Tipo");
		lblTipo_1.setBounds(22, 43, 46, 14);
		this.add(lblTipo_1);
		
		txtTipoContacto = new JTextField();
		txtTipoContacto.setBounds(77, 37, 186, 30);
		this.add(txtTipoContacto);
		txtTipoContacto.setColumns(10);
		
		listaTipoContactos = new List();
		listaTipoContactos.setBounds(21, 94, 242, 301);
		this.add(listaTipoContactos);
		
		btnAgregar = new JButton("A");
		btnAgregar.setBounds(21, 425, 64, 47);
		this.add(btnAgregar);
		
		btnBorrar = new JButton("B");
		btnBorrar.setBounds(111, 425, 64, 47);
		this.add(btnBorrar);
		
		btnModificar = new JButton("M");
		btnModificar.setBounds(199, 425, 64, 47);
		this.add(btnModificar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(21, 425, 106, 47);
		btnGuardar.setVisible(false);
		this.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(157, 425, 106, 47);
		btnCancelar.setVisible(false);
		this.add(btnCancelar);
	}

	public JTextField getTxtTipoContacto()
	{
		return txtTipoContacto;
	}

	public List getListaTipoContactos() 
	{
		return listaTipoContactos;
	}

	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}

	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}

	public JButton getBtnModificar() 
	{
		return btnModificar;
	}
	
	public JButton getBtnGuardar() 
	{
		return btnGuardar;
	}

	public JButton getBtnCancelar() 
	{
		return btnCancelar;
	}	
}
