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
	private JButton btnBorrar;
	private JButton btnReporte;
	private JButton btnEditar;
	private DefaultTableModel modelPersonas;
	private  String[] nombreColumnas = {"Nombre", "Telefono","Cumplea�os","Email","Localidad","Direccion","Numero","Piso","Dpto","Tipo Contacto"};
	private ContactoPanel contactoPanel;
	private LocalidadPanel localidadPanel;
	private TipoContactoPanel tipoContactoPanel;
	private JTabbedPane tabbedPane;
	
	public Vista() 
	{
		super();
		initialize();
	}

	@SuppressWarnings("serial")
	private void initialize() 
	{
		this.cargarLookAndFeel();
		frmAgenda = new JFrame();
		frmAgenda.setResizable(false);
		frmAgenda.setTitle("Agenda");
		frmAgenda.setBounds(65, 16, 1250, 691);
		frmAgenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgenda.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1235, 652);
		frmAgenda.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(319, 55, 905, 504);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablaPersonas = new JTable(modelPersonas);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(200);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(2).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(3).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(3).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(4).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(4).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(5).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(5).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(6).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(6).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(7).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(7).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(8).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(8).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(9).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(9).setResizable(false);
		spPersonas.setViewportView(tablaPersonas);
		
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 33, 290, 526);
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
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(468, 584, 111, 51);
		btnEditar.setToolTipText("Seleccione un contacto de la lista");
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(758, 584, 111, 51);
		btnBorrar.setToolTipText("Seleccione un contacto de la lista");
		panel.add(btnBorrar);
		
		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(1046, 584, 111, 51);
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
	
	public JTabbedPane getTabbedPane()
	{
		return tabbedPane;
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

