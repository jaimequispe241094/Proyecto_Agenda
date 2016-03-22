package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import dto.PersonaDTO;

public class AgendaUtil 
{
	public static String limpiarCadena(String cadena)
	{
		String nuevaCadena = cadena.toLowerCase().replaceAll("\\s", "");
		String conAcentos = "αινσϊ";
		String sinAcentos = "aeiou";
		
		for (int i = 0; i < conAcentos.length(); i++)
		{
            nuevaCadena = nuevaCadena.replace(conAcentos.charAt(i), sinAcentos.charAt(i));
        }
		return nuevaCadena;
	}	
	
	public static boolean esNumero(String valor)
	{				 
		return valor.matches("[0-9]*");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void ordenarPorTipoDeContacto(List lista)
	{		 		 
		 Collections.sort((ArrayList)lista, new Comparator() 
		 {
			@Override
			public int compare(Object o1, Object o2) 
			{
				PersonaDTO p = (PersonaDTO) o1;
				PersonaDTO p2 = (PersonaDTO) o2;
				
				return new Integer(p.getTipoContacto().getNombre().compareTo(p2.getTipoContacto().getNombre()));
			}
		});		 		 
	} 
	
}
