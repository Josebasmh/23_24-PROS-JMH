package code;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;

public class Cliente {

	public static void main(String[] args) throws Exception{
		
		// Creación de tenista
		Tenista t1 = new Tenista("del Potro", 198);
		
		// Puerto y destino
		int puerto = 34567;
		InetAddress destino = InetAddress.getLocalHost();
		
		// Convertir el objeto en bytes
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeObject(t1);
		out.close();
		byte[] bytes = baos.toByteArray();
		
		// Recibir objetos
		
		}
}
