package code;

import java.net.MalformedURLException;
import java.net.URL;

public class Actividad4 {

	// Se pasa un parámetro más llamado msg para asi ahorrar líneas de código
	private void Visualizar(URL url,String msg) {
		System.out.println("Constructor "+msg);
		System.out.println("Metodo toString(): " + url.toString());
		System.out.println("Metodo getProtocol(): " +url.getProtocol());
		System.out.println("Metodo getHost(): "+url.getHost());
		System.out.println("Metodo getPort(): "+url.getPort());
		System.out.println("Metodo getFile(): "+url.getFile());
		System.out.println("Metodo getUserInfo(): "+url.getUserInfo());
		System.out.println("Metodo getPath(): "+url.getPath());
		System.out.println("Metodo getAuthority(): "+url.getAuthority());
		System.out.println("Metodo getQuery(): "+url.getQuery());
		System.out.println();
		
	}
	public static void main(String[] args) {
		Actividad4 a4=new Actividad4();
		try {
			URL url1 = new URL("http://docs.oracle.com");
			a4.Visualizar(url1,"simple para una URL");
			URL url2 = new URL("http","docs.oracle.com","javase/7");
			a4.Visualizar(url2,"para protocolo, host y directorio:");
			URL url3 =new URL("http", "docs.oracle.com", 80, "javase/7");
			a4.Visualizar(url3,"para protocolo, host, puerto y directorio:");
			URL url4 = new URL(new URL("http://docs.oracle.com/javase/7/docs/api/java/net/URL.html"), "javase/7");
			a4.Visualizar(url4,"para un objeto URL y su directorio:");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
