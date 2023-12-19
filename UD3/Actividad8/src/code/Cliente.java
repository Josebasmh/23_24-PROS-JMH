package code;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

	public static void main (String[] args) throws Exception{

		// Puerto
		int puerto = 12346;

		InetAddress destino = InetAddress.getLocalHost();

		// Matriz de bytes
		byte[] mensaje= new byte[1024]; 

		//Mensaje a enviar al servidor
		String numero = "4"; 

		// Codificar el string en bytes
		mensaje = numero.getBytes(); 

		// Construir el datagrama a enviar al servidor
		DatagramPacket envio = new DatagramPacket (mensaje, mensaje.length, destino, puerto);
		System.out.println("Esperando respuesta...");
		DatagramSocket socket = new DatagramSocket(34568); // Puerto local

		// Enviar el datagrama al servidor
		socket.send(envio);
		
		// Recibir el datagrama del servidor
		byte[] bufer = new byte[1024]; 
		DatagramPacket recibo = new DatagramPacket (bufer, bufer.length);
		socket.receive (recibo);
		
		// Obtener el datagrama en String
		String paquete = new String (recibo.getData());
		
		// Mostrar respuesta del servidor
		System.out.print("Esperando respuesta...: ");
		System.out.println("el cubo de "+numero+" es "+paquete.trim());

		// Cerrar el socket de cliente
		System.out.println("Adiós...");
		socket.close();
	}
}
