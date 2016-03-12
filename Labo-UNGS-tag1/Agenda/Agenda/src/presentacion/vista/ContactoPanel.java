package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class ContactoPanel extends JPanel{
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtDireccion;
	private JTextField txtNumero;
	private JTextField txtPiso;
	private JTextField txtDpto;
	private JButton btnGuardar;
	private JComboBox<String> listaLocalidad;
	private JComboBox<String> listaTipoContacto;
	private JDateChooser fechaCumpleaños;
	
	public ContactoPanel()
	{
		iniciar();
	}
		
	public void iniciar()
	{
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(21, 43, 53, 14);
		this.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(21, 87, 46, 14);
		this.add(lblApellido);
		
		JLabel lblCumpleaos = new JLabel("Cumplea\u00F1os");
		lblCumpleaos.setBounds(21, 172, 65, 14);
		this.add(lblCumpleaos);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(21, 130, 46, 14);
		this.add(lblEmail);
	
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(21, 219, 53, 14);
		this.add(lblDireccion);	
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(21, 261, 46, 14);
		this.add(lblNumero);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(21, 299, 46, 14);
		this.add(lblPiso);
		
		JLabel lblDto = new JLabel("Dpto");
		lblDto.setBounds(169, 299, 46, 14);
		this.add(lblDto);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(21, 377, 46, 14);
		this.add(lblTipo);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(21, 338, 46, 14);
		this.add(lblLocalidad);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(92, 36, 183, 28);
		this.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(92, 80, 183, 28);
		this.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(92, 123, 183, 28);
		this.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(92, 212, 183, 28);
		this.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(92, 251, 183, 28);
		this.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(92, 290, 57, 28);
		this.add(txtPiso);
		txtPiso.setColumns(10);
				
		txtDpto = new JTextField();
		txtDpto.setBounds(218, 290, 57, 28);
		this.add(txtDpto);
		txtDpto.setColumns(10);
		
		fechaCumpleaños = new JDateChooser();
		fechaCumpleaños.setBounds(92, 166, 183, 28);
		this.add(fechaCumpleaños);
		
		listaLocalidad = new JComboBox<String>();
		listaLocalidad.setBounds(92, 329, 183, 28);
		this.add(listaLocalidad);
		
		listaTipoContacto = new JComboBox<String>();
		listaTipoContacto.setBounds(92, 370, 183, 28);
		this.add(listaTipoContacto);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(81, 430,120, 52);
		this.add(btnGuardar);
	}


	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtApellido() 
	{
		return txtApellido;
	}

	public JTextField getTxtEmail() 
	{
		return txtEmail;
	}

	public JTextField getTxtDireccion() 
	{
		return txtDireccion;
	}

	public JTextField getTxtNumero() 
	{
		return txtNumero;
	}

	public JTextField getTxtPiso() 
	{
		return txtPiso;
	}

	public JTextField getTxtDpto() 
	{
		return txtDpto;
	}

	public JComboBox<String> getListaLocalidad() 
	{
		return listaLocalidad;
	}

	public JComboBox<String> getListaTipoContacto() 
	{
		return listaTipoContacto;
	}

	public JDateChooser getFechaCumpleaños() 
	{
		return fechaCumpleaños;
	}

	public JButton getBtnGuardar() 
	{
		return btnGuardar;
	}
	
}
