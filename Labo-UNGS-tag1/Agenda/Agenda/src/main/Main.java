package main;
//Saludos a Jaime :P commit desde Eclipse

import modelo.Agenda;
import presentacion.controlador.Controlador;
import presentacion.vista.Vista;


public class Main 
{

	public static void main(String[] args) 
	{
		Vista vista = new Vista();
		Agenda modelo = new Agenda();
		Controlador controlador = new Controlador(vista, modelo);
		controlador.inicializar();
	}
}
