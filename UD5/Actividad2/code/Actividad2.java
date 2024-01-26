package code;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class Actividad2 {
	public static void main(String[] args) {
		
		// GENERAR OBJETOS DE LECTURA PARA ARCHIVOS \\
		try (InputStream fiPub = Actividad2.class.getResourceAsStream("Clave.publica");
				InputStream fiFich = Actividad2.class.getResourceAsStream("FICHERO.DAT");
						InputStream fiFir = Actividad2.class.getResourceAsStream("FICHERO.FIRMA")){
			
			// LEER LA CLAVE PUBLICA Y DESCIFRARLA \\
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(fiPub.readAllBytes());
			KeyFactory keyFactory = KeyFactory.getInstance("DSA");
			PublicKey clPub = keyFactory.generatePublic(keySpec);
			
			// LEER LOS DATOS Y DESCIFRARLOS CON LA CLAVE PUBLICA \\
			Signature firma = Signature.getInstance("SHAwithDSA");
			firma.initVerify(clPub);
			firma.update(fiFich.readAllBytes());
			
			// LEER LA FIRMA Y VERIFICAR LOS DATOS \\
			if (firma.verify(fiFir.readAllBytes())) {
				System.out.println("DATOS CORRESPONDIENTES A FIRMA.");
			}else {
				System.out.println("DATOS NO CORRESPONDIENTES A FIRMA.");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
