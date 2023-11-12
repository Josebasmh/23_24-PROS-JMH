package code;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		int puerto=6010;
		
		try {
			// Instanciar servidor y esperar cliente
			ServerSocket servidor=new ServerSocket(puerto);
			System.out.println("Esperando cliente...");
			Socket cliente1=servidor.accept();
			
			// Recibe, lee y calcula el valor del cliente recibido
			InputStream entrada = cliente1.getInputStream();
			DataInputStream flujoEntrada = new DataInputStream(entrada);
			String linea = flujoEntrada.readUTF();
			int n=Integer.parseInt(linea);
			n=n*n;
			
			// Envía los datos al cliente
			OutputStream salida = cliente1.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(salida);
			flujoSalida.writeUTF(""+n);
			
			// Se cierran streams y sockets
			entrada.close();
			flujoEntrada.close();
			salida.close();
			flujoSalida.close();
			cliente1.close();
			servidor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
