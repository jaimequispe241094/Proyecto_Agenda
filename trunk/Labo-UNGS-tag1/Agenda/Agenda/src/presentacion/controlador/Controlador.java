package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.Vista;
import util.AgendaUtil;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoContactoDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personas_en_tabla;
		private Agenda agenda;
		private ControladorLocalidad controladorLocalidad;
		private ControladorTipoContacto controladorTipoContacto;
		private ControladorContacto controladorContacto;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.agenda = agenda;
			this.vista.getBtnBorrar().addActionListener(this);
			this.vista.getBtnReporte().addActionListener(this);
			this.vista.getBtnEditar().addActionListener(this);
			this.controladorLocalidad = new ControladorLocalidad(this);
			this.controladorTipoContacto = new ControladorTipoContacto(this);
			this.controladorContacto = new ControladorContacto(this);
			this.personas_en_tabla = null;
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
			if(e.getSource() == this.vista.getBtnBorrar())
			{
				int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
				for (int fila:filas_seleccionadas)
				{
					this.agenda.borrarPersona(this.personas_en_tabla.get(fila));
				}				
				this.llenarTabla();
			}
			
			else if(e.getSource() == this.vista.getBtnEditar())
			{
				int fila = this.vista.getTablaPersonas().getSelectedRow();
				if(fila != -1)
				{
					PersonaDTO persona = this.personas_en_tabla.get(fila);
					this.vista.getContactoPanel().getTxtNombre().setText(persona.getNombre());
					this.vista.getContactoPanel().getTxtTelefono().setText(persona.getTelefono());
					this.vista.getContactoPanel().getTxtEmail().setText(persona.getEmail());
					this.vista.getContactoPanel().getTxtDireccion().setText(persona.getCalle());
					this.vista.getContactoPanel().getTxtNumero().setText(String.valueOf(persona.getAltura()));
					this.vista.getContactoPanel().getTxtPiso().setText(String.valueOf(persona.getPiso()));
					this.vista.getContactoPanel().getTxtDepto().setText(String.valueOf(persona.getDepto()));
					this.setearCalendario_CumpleañosContacto(persona);
					this.vista.getContactoPanel().getListaLocalidades().setSelectedIndex(this.indiceLocalidad(persona.getLocalidad()));
					this.vista.getContactoPanel().getListaTipoContactos().setSelectedIndex(this.indiceTipoContacto(persona.getTipoContacto()));
					
					this.controladorContacto.visualizarBotonesEdicion(true);
					this.seEstaEditandoContacto(true);
					this.vista.getTabbedPane().setSelectedIndex(0); // primer panel ..el de contacto
				}
			}
			
			else if(e.getSource() == this.vista.getBtnReporte())
			{				
				List<PersonaDTO> lista_para_reporte = this.agenda.obtenerPersonas();
				AgendaUtil.ordenarPorTipoDeContacto(lista_para_reporte);
				ReporteAgenda reporte = new ReporteAgenda(lista_para_reporte);
				reporte.mostrar();				
			}			
	}		
		
	public int indiceLocalidad(LocalidadDTO local)
	{
		int valor = -1;
		
		for(int i=0;i<this.vista.getContactoPanel().getListaLocalidades().getItemCount();i++)
		{
			if (local.getIdLocalidad() == this.vista.getContactoPanel().getListaLocalidades().getItemAt(i).getIdLocalidad())
			{
				valor = i;
			}
		}		
		return valor;
	}	
	
	public int indiceTipoContacto(TipoContactoDTO tipo)
	{
		int valor = -1;
		
		for(int i=0;i<this.vista.getContactoPanel().getListaTipoContactos().getItemCount();i++)
		{
			if (tipo.getIdTipoContacto() == this.vista.getContactoPanel().getListaTipoContactos().getItemAt(i).getIdTipoContacto())
			{
				valor = i;
			}
		}		
		return valor;
	}
			
	public PersonaDTO contactoSeleccionado()
	{
		int index = this.vista.getTablaPersonas().getSelectedRow();
		return this.personas_en_tabla.get(index);
	}	
	
	private void setearCalendario_CumpleañosContacto(PersonaDTO persona)
	{
		try 
		{
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
			this.vista.getContactoPanel().getFechaCumpleaños().setDate(simple.parse(persona.getCumpleaños()));
		}
		catch (ParseException e1) 
		{
			e1.printStackTrace();
		}
	}
		
	public void seEstaEditandoContacto(boolean editar) // se des / bloquean los botones y la tabla cuando se hace la edicion de un contacto  
	{													
		this.vista.getBtnEditar().setEnabled(!editar);
		this.vista.getTablaPersonas().setEnabled(!editar);
		this.vista.getBtnBorrar().setEnabled(!editar);
	}
	
	public List<PersonaDTO> getPersonas_en_tabla() {
			return personas_en_tabla;
	}

	public Vista getVista() 
	{
		return vista;
	}

	public Agenda getAgenda() 
	{
		return agenda;
	}
}
