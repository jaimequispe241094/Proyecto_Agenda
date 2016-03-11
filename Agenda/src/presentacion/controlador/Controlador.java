package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.LocalidadPanel;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.PersonaDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personas_en_tabla;
		private VentanaPersona ventanaPersona; 
		private Agenda agenda;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(this);
			this.vista.getBtnBorrar().addActionListener(this);
			this.vista.getBtnReporte().addActionListener(this);
			this.vista.getLocalidadPanel().getBtnAgregar().addActionListener(this);
			this.vista.getTipoContactoPanel().getBtnAgregar().addActionListener(this);
			this.agenda = agenda;
			this.personas_en_tabla = null;
		}
		
		public void inicializar()
		{
			this.llenarTabla();
		}
		
		private void llenarTabla()
		{
			this.vista.getModelPersonas().setRowCount(0); //Para vaciar la tabla
			this.vista.getModelPersonas().setColumnCount(0);
			this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());
			
			this.personas_en_tabla = agenda.obtenerPersonas();
			for (int i = 0; i < this.personas_en_tabla.size(); i ++)
			{
				Object[] fila = {this.personas_en_tabla.get(i).getNombre(), this.personas_en_tabla.get(i).getTelefono()};
				this.vista.getModelPersonas().addRow(fila);
			}
			this.vista.show();
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			
			LocalidadPanel localPanel = this.vista.getLocalidadPanel();
			
			if(e.getSource() == this.vista.getBtnAgregar())
			{
				this.ventanaPersona = new VentanaPersona(this);
			}
			else if(e.getSource() == this.vista.getBtnBorrar())
			{
				int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
				for (int fila:filas_seleccionadas)
				{
					this.agenda.borrarPersona(this.personas_en_tabla.get(fila));
				}
				
				this.llenarTabla();
				
			}
			else if(e.getSource() == this.vista.getBtnReporte())
			{				
				ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
				reporte.mostrar();				
			}
			
			else if(e.getSource() == localPanel.getBtnAgregar())
			{
				if(localPanel.getTxtNombreLocalidad().getText().length() > 0)
				{
					localPanel.getListaLocalidad().add(localPanel.getTxtNombreLocalidad().getText());
					localPanel.getTxtNombreLocalidad().setText("");
				}
			}
			
			
			else if(e.getSource() == this.ventanaPersona.getBtnAgregarPersona())
			{
				String nombre = this.ventanaPersona.getTxtNombre().getText();
				String telefono = this.ventanaPersona.getTxtTelefono().getText();
				if(nombre.length()>0 && telefono.length()>0)
				{
					PersonaDTO nuevaPersona = new PersonaDTO(0,nombre, telefono);
					this.agenda.agregarPersona(nuevaPersona);
					this.llenarTabla();
					this.ventanaPersona.dispose();
				}
			}
			
			
		
		}
		
		
		
		/*public void actionPanelLocalidad(ActionEvent e)
		{
			LocalidadPanel localPanel = this.vista.getLocalidadPanel();
			
			if(e.getSource() == localPanel.getBtnAgregar())
			{
				if(localPanel.getTxtNombreLocalidad().getText().length() > 0)
				{
					localPanel.getListaLocalidad().add(localPanel.getTxtNombreLocalidad().getText());
					localPanel.getTxtNombreLocalidad().setText("");
				}
			}
			
		}	
		*/	
		

}
