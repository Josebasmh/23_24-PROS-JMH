package code;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;

public class Actividad2 {

	public static void main(String[] args) {
		
		 // CLASE FTPCLIENTE \\
		FTPClient cliente = new FTPClient();

		// SERVIDOR FTP \\
		String servFTP = "192.168.1.138";
		
		// NOTIFICA EL INICIO DE LA CONEXIÓN \\
		System.out.println("Nos conectamos a "+servFTP);
				
		// USUSARIO Y CONTRASEÑA \\
		String usuario="dinux";
		String clave="dinux";
		
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
			
			// INTENTOS DE CREACIÓN DE DIRECTORIOS \\ 
			boolean bWeb =cliente.makeDirectory("aplicacionwebmartinez");
			boolean bHtml =cliente.makeDirectory("aplicacionwebmartinez/html");
			boolean bImg =cliente.makeDirectory("aplicacionwebmartinez/imagenes");
			boolean bCss =cliente.makeDirectory("aplicacionwebmartinez/css");
			
			if(bWeb && bHtml && bImg && bCss) {
				
				// CREACIÓN CORRECTA \\
				System.out.println("Directorios creados.....");	
			}else {
				// CREACIÓN SIN ÉXITO \\
				System.out.println("NO SE HAN PODIDO CREAR LOS DIRECTORIOS");
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
