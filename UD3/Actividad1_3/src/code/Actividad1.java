package code;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad1 {

	public static void main(String[] args) {
		InetAddress address;
		try {
			System.out.println("Direcciones asociadas a Spotify:");
			System.out.println();//Espacio en blaco entre texto fijo y las IP.
			for (int i=0;i<3;i++) {
				address = InetAddress.getByName("www.spotify.com");
				System.out.println(address);
			}
		}catch(UnknownHostException e) {
			System.err.println(e.getMessage());
		}
		
	}
}
