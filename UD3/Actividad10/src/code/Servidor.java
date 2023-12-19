package code;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {

	public static void main(String[] args) throws Exception{
		// Puerto
		int puerto = 12348;
		
		// Asociar el socket al puerto 12346 del servidor
		DatagramSocket socket = new DatagramSocket (puerto);
		
		// Recibir el datagrama
		System.out.println("Esperando datagrama......");
		byte[] recibidos = new byte[1024];
		DatagramPacket paqRec = new DatagramPacket(recibidos, recibidos.length);
		socket.receive(paqRec);
		
		// Conversión de bytes a objeto
		ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
		ObjectInputStream in = new ObjectInputStream(bais);
		Tenista t = (Tenista) in.readObject();
		in.close();
		System.out.println("Recibo el objeto: "+t.toString());
		System.out.println("IP de origen: "+paqRec.getAddress().getHostAddress());
		System.out.println("Puerto de origen: "+paqRec.getPort());
		
		// Cambio de datos
		t.setApellido("Karlovic");
		t.setAltura(208);
		
		// Enviar el tenista modificado al cliente
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeObject(t);
		System.out.println("Envío el objeto"+t.toString());
		out.close();
		System.out.println("Fin del servidor");
	}
}
