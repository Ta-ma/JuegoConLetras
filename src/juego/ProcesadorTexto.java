package juego;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProcesadorTexto
{
	char[][] tablero;
	String palabras[];
	
	public ProcesadorTexto (File arch) throws IOException
	{
		String cadena;
		Scanner sc = new Scanner(arch);
		int tam = sc.nextInt();
		palabras = new String[sc.nextInt()];
		
		tablero = new char[tam][tam];
		sc.nextLine();
		
		for (int i = 0; i < tam; i++)
		{
			cadena = sc.nextLine();
			
			for (int j = 0; j < tam; j++)
			{
				tablero[i][j] = cadena.charAt(j);
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}	
		
		for (int i = 0; i < palabras.length; i++)
		{
			palabras[i] = sc.nextLine();
			System.out.println(palabras[i]);
		}
		
		sc.close();
	}

	String obtenerColumnaD (int col)
	{
		String cadena = new String();
		for (int i = 0; i < tablero.length; i++)
			cadena += tablero[i][col];
		
		return cadena;
	}
	
	String obtenerColumnaA (int col)
	{
		String cadena = new String();
		for (int i = 0; i < tablero.length; i++)
			cadena += tablero[tablero.length - 1 - i][col];
		
		return cadena;
	}
	
	String obtenerFilaA (int fil)
	{
		String cadena = new String();
		for (int i = 0; i < tablero[0].length; i++)
			cadena += tablero[fil][i];
		
		return cadena;
	}
	
	String obtenerFilaD (int fil)
	{
		String cadena = new String();
		for (int i = 0; i < tablero[0].length; i++)
			cadena += tablero[fil][tablero.length - 1 - i];
		
		return cadena;
	}
	
	public void hallarPalabras (String path) throws IOException
	{
		PrintWriter salida = new PrintWriter(path);
		
		for (int i = 0; i < tablero.length; i++)
		{
			String cadena = obtenerColumnaD(i);
			for (int j = 0; j < palabras.length; j++)
			{
				if (cadena.contains(palabras[j]))
					salida.println(j + 1 + " N" );
			}
			
			cadena = obtenerColumnaA(i);
			for (int j = 0; j < palabras.length; j++)
			{
				if (cadena.contains(palabras[j]))
					salida.println(j + 1 + " S" );
			}
			
			cadena = obtenerFilaD(i);
			for (int j = 0; j < palabras.length; j++)
			{
				if (cadena.contains(palabras[j]))
					salida.println(j + 1 + " E" );
			}
			
			cadena = obtenerFilaA(i);
			for (int j = 0; j < palabras.length; j++)
			{
				if (cadena.contains(palabras[j]))
					salida.println(j + 1 + " O" );
			}
		}
		
		salida.close();
	}
}
