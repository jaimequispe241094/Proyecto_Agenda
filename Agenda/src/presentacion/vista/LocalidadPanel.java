package presentacion.vista;

import java.awt.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LocalidadPanel extends JPanel
{

	private JTextField txtNombreLocalidad;
	private List listaLocalidad;
	private JButton btnAgregar;
	private JButton btnBorrar;	
	private JButton btnModificar;
	
	
	public LocalidadPanel()
	{
		iniciar();
	}
	
	
	public void iniciar()
	{
		JLabel lblPais = new JLabel("Nombre");
		lblPais.setBounds(21, 43, 46, 14);
		this.add(lblPais);
		
		txtNombreLocalidad = new JTextField();
		txtNombreLocalidad.setBounds(77, 37, 171, 30);
		this.add(txtNombreLocalidad);
		txtNombreLocalidad.setColumns(10);
		
		listaLocalidad = new List();
		listaLocalidad.setBounds(21, 94, 227, 251);
		this.add(listaLocalidad);
		
		btnAgregar = new JButton("A");
		btnAgregar.setBounds(22, 377, 64, 40);
		this.add(btnAgregar);
		
		btnBorrar = new JButton("B");
		btnBorrar.setBounds(106, 377, 64, 40);
		this.add(btnBorrar);
		
		btnModificar = new JButton("M");
		btnModificar.setBounds(195, 377, 64, 40);
		this.add(btnModificar);
	}


	public JTextField getTxtNombreLocalidad() 
	{
		return txtNombreLocalidad;
	}

	public List getListaLocalidad() 
	{
		return listaLocalidad;
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
	
	
}
