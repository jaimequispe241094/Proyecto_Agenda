package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;

public class Vista
{
	private JFrame frmAgenda;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnReporte;
	private JButton btnEditar;
	private DefaultTableModel modelPersonas;
	private  String[] nombreColumnas = {"Nombre y apellido","Teléfono","Direccion","E-mail"};
	private ContactoPanel contactoPanel;
	private LocalidadPanel localidadPanel;
	private TipoContactoPanel tipoContactoPanel;
	
	
	public Vista() 
	{
		super();
		initialize();
	}


	private void initialize() 
	{
		this.cargarLookAndFeel();
		frmAgenda = new JFrame();
		frmAgenda.setTitle("Agenda");
		frmAgenda.setResizable(false);
		frmAgenda.setBounds(100, 80, 1107, 630);
		frmAgenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgenda.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1071, 581);
		frmAgenda.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(294, 55, 767, 446);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(2).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(3).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(3).setResizable(false);
		spPersonas.setViewportView(tablaPersonas);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 33, 274, 468);
		panel.add(tabbedPane);
		
		contactoPanel = new ContactoPanel();
		tabbedPane.addTab("Contacto", null, contactoPanel, null);
		contactoPanel.setLayout(null);
		
		localidadPanel = new LocalidadPanel();
		tabbedPane.addTab("Localidad", null, localidadPanel, null);
		localidadPanel.setLayout(null);
		
		tipoContactoPanel = new TipoContactoPanel();
		tabbedPane.addTab("TipoContacto", null, tipoContactoPanel, null);
		tipoContactoPanel.setLayout(null);
		
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(313, 519, 111, 51);
		panel.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(506, 519, 111, 51);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(717, 519, 111, 51);
		panel.add(btnBorrar);
		
		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(896, 519, 111, 51);
		panel.add(btnReporte);
		
	}
	
	private void cargarLookAndFeel() 
	{
		try 
		{
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel");
		} 
		catch (Exception e) 
		{
			System.err.println("Error: " + e.getMessage());
		}
	}

	public void show()
	{
		this.frmAgenda.setVisible(true);
	}
	
	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}

	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}
	
	public JButton getBtnEditar()
	{
		return btnEditar;
	}
	
	public JButton getBtnReporte() 
	{
		return btnReporte;
	}
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}
	
	
	public ContactoPanel getContactoPanel()
	{
		return contactoPanel;
	}
	
	public LocalidadPanel getLocalidadPanel()
	{
		return localidadPanel;
	}
	
	public TipoContactoPanel getTipoContactoPanel()
	{
		return tipoContactoPanel;
	}
	
	
}
