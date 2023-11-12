package code;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente7 {

	public static void main(String[] args) {
		String host="localhost";
		int puerto=6013;
				
		try {
			for (int i=1;i<5;i++) {
				// Instancia de socket cliente
				System.out.println("PROGRAMA CLIENTE INICIADO");
				Socket cli= new Socket(host, puerto);
				
				// Recibe los datos y lo muestra
				DataInputStream entrada=new DataInputStream(cli.getInputStream());
				System.out.println("Recicbiendo mensaje de servidor:");
				System.out.println(entrada.readUTF());
				
				// Cierra streams y socket
				entrada.close();
				cli.close();
			}
			
			
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}
}
