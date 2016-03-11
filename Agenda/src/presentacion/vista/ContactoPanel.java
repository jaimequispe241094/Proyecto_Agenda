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
	private JComboBox<String> listaLocalidad;
	private JComboBox<String> listaTipoContacto;
	private JDateChooser fechaCumpleaños;
	
	public ContactoPanel()
	{
		iniciar();
	}
	
		
	public void iniciar()
	{
		txtNombre = new JTextField();
		txtNombre.setBounds(111, 36, 148, 28);
		this.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(111, 80, 148, 28);
		this.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(111, 123, 148, 28);
		this.add(txtEmail);
		txtEmail.setColumns(10);
		
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
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(82, 379, 116, 50);
		this.add(btnGuardar);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(111, 212, 148, 28);
		this.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(21, 219, 53, 14);
		this.add(lblDireccion);
		
		listaLocalidad = new JComboBox<String>();
		listaLocalidad.setBounds(111, 259, 148, 28);
		this.add(listaLocalidad);
		
		listaTipoContacto = new JComboBox<String>();
		listaTipoContacto.setBounds(111, 305, 148, 28);
		this.add(listaTipoContacto);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(21, 312, 46, 14);
		this.add(lblTipo);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(21, 266, 46, 14);
		this.add(lblLocalidad);
		
		fechaCumpleaños = new JDateChooser();
		fechaCumpleaños.setBounds(111, 166, 148, 28);
		this.add(fechaCumpleaños);
	}


	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public JComboBox<String> getListaLocalidad() {
		return listaLocalidad;
	}

	public JComboBox<String> getListaTipoContacto() {
		return listaTipoContacto;
	}

	public JDateChooser getFechaCumpleaños() {
		return fechaCumpleaños;
	}
	

}
