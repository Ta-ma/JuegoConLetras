package juego;

import java.io.File;
import java.io.IOException;

public class Test
{

	public static void main(String[] args) throws IOException
	{
		File dir = new File(".//IN//");
		File[] archivos = dir.listFiles();
		
		for(File archivo : archivos)
		{
			ProcesadorTexto proc = new ProcesadorTexto(archivo);
			proc.hallarPalabras(".//OUT//" + archivo.getName().replace(".in", ".out"));
		}
	}

}
