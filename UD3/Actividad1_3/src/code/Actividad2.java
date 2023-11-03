package code;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Actividad2 {

	public static void main(String[] args) {
		String host = "web.gencat.cat";
		try {
			System.out.println("Las direcciones asociadas a " + host + " son:");
			System.out.println();
			List<InetAddress> listaIp = Arrays.asList(InetAddress.getAllByName(host));
			Iterator<InetAddress> it = listaIp.iterator();
			while(it.hasNext()) {
				InetAddress ip = it.next();
				System.out.println(ip);
			}
		} catch (UnknownHostException e) {
			System.err.println("Se necesita una URL para obtener su dirección");
		}
	}
}