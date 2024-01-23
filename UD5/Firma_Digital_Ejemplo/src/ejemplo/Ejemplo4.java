package ejemplo;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;

public class Ejemplo4 {
	public static void main (String[] args) {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
			// SE INICIALIZA EL GENERADOR DE CLAVES
			SecureRandom numero = SecureRandom.getInstance("SHA1PRNG");
			keyGen.initialize(1024, numero);
			
			// SE CREA EL PAR DE CLAVES PRIVADA Y PÚBLICA
			KeyPair par = keyGen.generateKeyPair();
			PrivateKey clavepriv = par.getPrivate();
			PublicKey clavepub = par.getPublic();
			
			/// SE FIRMA EL MENSAJE CON LA CLAVE PRIVADA 
			/// AL OBJETO Signature SE LE SUMINISTRAN LOS DATOS A FIRMAR
			Signature dsa = Signature.getInstance("SHA1withDSA");
			dsa.initSign(clavepriv);
			String mensaje = "Este mensaje va a ser firmado";
			dsa.update(mensaje.getBytes());
			byte[] firma = dsa.sign(); // Mensaje firmado
			
			// EL RECEPTOR DEL MENSAJE
			// VERIFICA CON LA CLÁVE PÚBLICA EL MENSAJE FIRMADO
			// AL OBJETO Signature SE LE SUMINISTRAN LOS DATOS A VERIFICAR
			Signature verificadsa = Signature.getInstance("SHA1withDSA");
			verificadsa.initVerify(clavepub);
			verificadsa.update(mensaje.getBytes());
			boolean check = verificadsa.verify(firma);
			if (check)
					System.out.println("FIRMA VERIFICADA CON CLAVE PÚBLICA");
					else
					System.out.println("FIRMA NO VERIFICADA");
		
		} catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
}