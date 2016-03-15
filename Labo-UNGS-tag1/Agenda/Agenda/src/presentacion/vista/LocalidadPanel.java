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
	private JButton btnGuardar;	
	private JButton btnCancelar;
	
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
		txtNombreLocalidad.setBounds(77, 37, 186, 30);
		this.add(txtNombreLocalidad);
		txtNombreLocalidad.setColumns(10);
		
		listaLocalidad = new List();
		listaLocalidad.setBounds(21, 94, 242, 301);
		this.add(listaLocalidad);
		
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

	public JButton getBtnGuardar() 
	{
		return btnGuardar;
	}

	public JButton getBtnCancelar() 
	{
		return btnCancelar;
	}	
}
