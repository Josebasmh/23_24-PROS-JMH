package code;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Actividad3 {

	public static void main(String[] args) {
	
		try {
			// creación de variables locales
			String host="";
			InetAddress ip;
			List<InetAddress> listaIp;
			
			// configuración de datos
			//host  = "www.ciudadjardin.com"; //Comentar esta linea para que devuelva IP locales
			if (host.equals("")) {
				ip = InetAddress.getLocalHost();
				host = ip.getHostName();	
			}else {
				ip = InetAddress.getByName(host);
			}
			listaIp = Arrays.asList(InetAddress.getAllByName(host));
			Iterator<InetAddress> it = listaIp.iterator();
			
			// Sacar datos por pantalla
			System.out.println("Dirección IP: " + ip);
			System.out.println("Nombre: " + host);
			while (it.hasNext()) {
				ip = it.next();
				System.out.println(ip);
			}
		}catch(UnknownHostException e){
			System.err.println(e.getMessage());
		}
	}
}
