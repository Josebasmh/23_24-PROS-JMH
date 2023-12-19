package code;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
	public static void main (String[] args) throws Exception {

		int puerto = 12346;

		// Buffer para recibir los datagramas
		byte[] bufer = new byte[1024]; 
		
		// Asociar el socket al puerto 12346 del servidor
		DatagramSocket socket = new DatagramSocket ( puerto);

		// Esperar la llegada del datagrama al servidor
		System.out.println("Esperando datagrama.......");
		DatagramPacket recibo = new DatagramPacket (bufer, bufer.length);
		
		// Recibir el datagrama
		socket.receive (recibo);
				
		// Obtener el número de bytes del datagrama
		int bytesRec = recibo.getLength(); 
		
		// Obtener el datagrama en String
		String paquete = new String (recibo.getData()); 

		// Mostrar el mensaje recibido
		System.out.println("Vamos a calcular el cubo de: "+paquete.trim());
		System.out.println("IP de origen: " + recibo.getAddress().getHostAddress());
		System.out.println("Puerto de origen: " + recibo.getPort());
		
		// Enviar respuesta a cliente
		String numero = "64";
		byte[] mensaje= new byte[1024];
		mensaje = numero.getBytes();
		InetAddress destino = InetAddress.getLocalHost();
		int puertoCliente = 34568;
		
		DatagramPacket envio = new DatagramPacket (mensaje, mensaje.length, destino, puertoCliente);
		socket.send(envio);
		
		// Mostrar el mensaje enviado
		System.out.println("Enviamos el resultado..."+numero);

		//Cerrar el socket de servidor
		System.out.println("Adiósss");
		socket.close();
	}
}
