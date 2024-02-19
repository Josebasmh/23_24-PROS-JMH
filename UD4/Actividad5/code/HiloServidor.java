package code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloServidor extends Thread{

	Socket socket;
	ObjectOutputStream outObjeto;
	ObjectInputStream inObjeto;
	EstructuraFicheros NF;
	
	public HiloServidor(Socket s, EstructuraFicheros nF) throws IOException{
		socket = s;
		NF=nF;
		inObjeto = new ObjectInputStream(socket.getInputStream());
		outObjeto = new ObjectOutputStream (socket.getOutputStream());
	}
	
	public void run() {
		
		try {
			outObjeto.writeObject(NF);
			while (true) {
				System.out.println("EEEEEEnviado");
				Object peticion;
				
				try {
					peticion = inObjeto.readObject();
					if (peticion instanceof PideFichero) {
						PideFichero fichero = (PideFichero) peticion;
						EnviaFichero(fichero);
					}
					if (peticion instanceof EnviaFichero) {
						EnviaFichero fic = (EnviaFichero) peticion;
						File d = new File(fic.getDirectorio());
						File f1 = new File(d, fic.getNombre());
						FileOutputStream fos = new FileOutputStream(f1);
						
						fos.write(fic.getContenidoFichero());;
						fos.close();
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					inObjeto.close();
					outObjeto.close();
					socket.close();
					System.out.println("Cerrado cliente");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void EnviaFichero(PideFichero fich) {
		
		try {
			File fichero = new File(fich.getNombreFichero());
			FileInputStream filein = null;
			filein = new FileInputStream(fichero);
			long bytes = fichero.length();
			byte[] buff = new byte[(int) bytes];
			int i,j = 0;
			
			try {
				while ((i=filein.read()) != 1) {
					buff[j] = (byte) i;
					j++;
				}
			}catch(IOException e1) {
				e1.printStackTrace();;
			}
			
			try {
				filein.close();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
			
			Object ff = new ObtieneFichero(buff);
			try {
				outObjeto.writeObject(ff);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
