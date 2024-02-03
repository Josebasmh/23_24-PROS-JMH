package code;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;

public class Actividad1 {
	public static void main (String [] args) {

		 // CLASE FTPCLIENTE \\
		FTPClient cliente = new FTPClient();

		// SERVIDOR FTP \\
		String servFTP = "ftp.rediris.es";

		// NOTIFICA EL INICIO DE LA CONEXIÓN \\
		System.out.println("Nos conectamos a "+servFTP);
		
		// USUSARIO Y CONTRASEÑA \\
		String usuario="anonymous";
		String clave="dm2";
		
		try {
			// INTENTO DE CONEXIÓN \\
			cliente.connect(servFTP);
			boolean login = cliente.login(usuario, clave);
			if (login)
				
				// NOTIFICA CONEXIÓN EXITOSA \\
				System.out.println("Login correcto");
			else {
				
				// NOTIFICA CONEXIÓN SIN ÉXITO, DESCONECTA Y SALE \\
				System.out.println("Login incorrecto...");
				cliente.disconnect();
				System.exit(1);
			}
			
			// NOTIFICA EL DIRECTORIO EN EL QUE ESTAMOS SITUADOS \\
			System.out.println("Directorio actual:" + cliente.printWorkingDirectory());
			
			// INTENTO DE CREACIÓN EL DIRECTORIO \\ 
			boolean bResp =cliente.makeDirectory("DM2PROS");
			if(bResp) {
				
				// CREACIÓN CORRECTA \\
				System.out.println("Directorio creado.....");	
			}else {
				// CREACIÓN SIN ÉXITO \\
				System.out.println("NO SE HA PODIDO CREAR EL DIRECTORIO");
			}
			
			// DESCONECTA DEL SERVIDOR FTP \\
			boolean logout = cliente.logout();
			if (logout) 
				System.out.println("Logout del servidor FTP.....");
			else
				System.out.println("Error al hacer un Logout...."); 
			
			// FINALIZA EL PROGRAMA \\
			cliente.disconnect();
			System.out.println("Desconectado......");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
