package code;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor7 {

	public static void main(String[] args) {
		int puerto=6013;

		try {
			// Instanciar servidor y esperar cliente
			ServerSocket servidor = new ServerSocket(puerto);
			System.out.println("Esperando cliente...");
			
			OutputStream salida = null;
			DataOutputStream flujoSalida = null;
			Socket cli = null;
			for(int i=1;i<4;i++) {
				cli=servidor.accept();
				
				// Envía los datos al cliente
				salida = cli.getOutputStream();
				flujoSalida = new DataOutputStream(salida);
				flujoSalida.writeUTF("Hola cliente "+i);
			}
			// Se cierran streams y sockets
			salida.close();
			flujoSalida.close();
			cli.close();
			servidor.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
