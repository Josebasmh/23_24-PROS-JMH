package code;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		String host="localhost";
		int puerto=6010;
		System.out.println("PROGRAMA CLIENTE INICIADO");
		int n=7;
		
		try {
			// Instancia de socket cliente
			Socket cliente=new Socket(host, puerto);
			
			// Envía datos al servidor
			DataOutputStream salida=new DataOutputStream(cliente.getOutputStream());
			salida.writeUTF(""+n);
			
			// Recibe los datos y lo muestra
			DataInputStream entrada=new DataInputStream(cliente.getInputStream());
			System.out.println("Recicbiendo mensaje de servidor:");
			System.out.println("El cuadrado de "+n+" es "+entrada.readUTF());
			
			// Cierra streams y socket
			entrada.close();
			salida.close();
			cliente.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
