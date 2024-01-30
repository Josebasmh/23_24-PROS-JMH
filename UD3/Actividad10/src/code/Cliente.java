package code;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

	public static void main(String[] args) throws Exception{
		
		// Creación de tenista \\
		Tenista t1 = new Tenista("del Potro", 198);
		
		// Puerto y destino \\
		int puerto = 34567;
		InetAddress destino = InetAddress.getLocalHost();
		
		// Convertir el objeto en bytes \\
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeObject(t1);
		out.close();
		byte[] bytes = baos.toByteArray();
		System.out.println("Envío el objeto: "+t1.getApellido()+" "+t1.getAltura());
		
		// Recibir objetos \\ 
		System.out.println("Esperando datagrama......");
		byte[] recibido = new byte[1024];
		DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
		DatagramSocket socket = new DatagramSocket (puerto);
		socket.receive(paqRecibido);
		
		// Convertir bytes a tenista \\
		ByteArrayInputStream bais = new ByteArrayInputStream(recibido);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Tenista t2 = (Tenista) ois.readObject();
		System.out.println("He recibido el objeto: "+t2.getApellido()+" "+t2.getAltura());
		System.out.println("Fin del cliente");
		ois.close();
		}
}
