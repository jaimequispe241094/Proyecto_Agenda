package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.PersonaDTO;


public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personas_en_tabla;
		private VentanaPersona ventanaPersona; 
		private Agenda agenda;
		private ControladorLocalidad controladorLocalidad;
		private ControladorTipoContacto controladorTipoContacto;
		private ControladorContacto controladorContacto;
		
		public Vista getVista() {
			return vista;
		}

		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.agenda = agenda;
			this.vista.getBtnAgregar().addActionListener(this);
			this.vista.getBtnBorrar().addActionListener(this);
			this.vista.getBtnReporte().addActionListener(this);
			this.controladorLocalidad = new ControladorLocalidad(this);
			this.controladorTipoContacto = new ControladorTipoContacto(this);
			this.controladorContacto = new ControladorContacto(this);
			this.personas_en_tabla = null;
		}
		
		public Agenda getAgenda() {
			return agenda;
		}

		public void inicializar()
		{
			this.llenarTabla();
			this.actualizarDatosLocalidades();
			this.actualizarDatosTipoContactos();
		}
		
		public void actualizarDatosLocalidades()
		{
			this.controladorLocalidad.cargarLocalidades();
			this.controladorContacto.actualizarLocalidades();
		}
		
		public void actualizarDatosTipoContactos()
		{
			this.controladorTipoContacto.cargarTiposContactos();			
			this.controladorContacto.actualizarTipoContactos();
		}	
		
		public void llenarTabla()
		{
			this.vista.getModelPersonas().setRowCount(0); //Para vaciar la tabla
			this.vista.getModelPersonas().setColumnCount(0);
			this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());
			
			this.personas_en_tabla = agenda.obtenerPersonas();
			for (int i = 0; i < this.personas_en_tabla.size(); i ++)
			{
				Object[] fila = { 	this.personas_en_tabla.get(i).getNombre(),
									this.personas_en_tabla.get(i).getTelefono(),
									this.personas_en_tabla.get(i).getCumpleaños(),
									this.personas_en_tabla.get(i).getEmail(),
									this.personas_en_tabla.get(i).getLocalidad().getNombre(),
									this.personas_en_tabla.get(i).getCalle(),
									this.personas_en_tabla.get(i).getAltura(),
									this.personas_en_tabla.get(i).getPiso(),
									this.personas_en_tabla.get(i).getDepto(),
									this.personas_en_tabla.get(i).getTipoContacto().getNombre()
								};
				this.vista.getModelPersonas().addRow(fila);
			}
			this.vista.show();
		}
		
		public void actionPerformed(ActionEvent e) 
		{
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
			else if(e.getSource() == this.ventanaPersona.getBtnAgregarPersona())
			{
				/*
				PersonaDTO nuevaPersona = new PersonaDTO
						(	0,
							vista.getContactoPanel().getTxtNombre().getText(), 
							vista.getContactoPanel().getTxtTelefono().getText(),
							vista.getContactoPanel().getTxtDireccion().getText(),
							Integer.parseInt(vista.getContactoPanel().getTxtNumero().getText()),
							Integer.parseInt(vista.getContactoPanel().getTxtPiso().getText()),
							Integer.parseInt(vista.getContactoPanel().getTxtDpto().getText()),
							((LocalidadDTO) vista.getContactoPanel().getListaLocalidades().getSelectedItem()),
							vista.getContactoPanel().getTxtEmail().getText(),
							vista.getContactoPanel().getFechaCumpleaños().getDate(),
							((TipoContactoDTO) vista.getContactoPanel().getListaTipoContactos().getSelectedItem())
						);
				
				this.agenda.agregarPersona(nuevaPersona);
				this.llenarTabla();
				this.ventanaPersona.dispose();
				*/
			}
		}

}
