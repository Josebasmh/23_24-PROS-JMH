package code;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Actividad5 {

	private void VisualizarConexion(URLConnection uc) {
		// Metodos simples
		System.out.println("Conexion con www.vitoria-gasteiz.org");
		System.out.println("====================================");
		System.out.println("\tMetodo toString(): " + uc.toString());
		System.out.println("\tMetodo Fecha(): " + uc.getDate());
		System.out.println("\tMetodo getContentType(): " + uc.getContentType());
		System.out.println();
		
		// Se crea un bucle para usar el getHeaderField en una soloa línea
		System.out.println("Campos cabecera con getHeaderField: ");
		System.out.println("====================================");
		for (int i=1;i<6;i++) {
			System.out.println("\tLinea "+i+": "+uc.getHeaderField(i));
		}
		System.out.println();
		
		/*
		 * m: mapa que obtiene los valores de la cabecera.
		 * c: coleccion que solo tiene las claves.
		 * it: iterador de c para recorrerlo.
		 * clave: string obtenido de cada vuelta del iterador.
		 */
		System.out.println("Campos cabecera con getHeaderFields: ");
		System.out.println("====================================");
		Map m=uc.getHeaderFields();
		Collection c=m.keySet();
		Iterator<String>it = c.iterator();
		while(it.hasNext()) {
			String clave = it.next();
			System.out.print(clave+": ");
			System.out.println(m.get(clave));
		}
		
	}
	
	public static void main(String[] args) {
		Actividad5 a5 = new Actividad5();
		URL url1;
		try {
			url1 = new URL("http://www.vitoria-gasteiz.org");
			URLConnection uc= url1.openConnection();
			a5.VisualizarConexion(uc);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
