package code;

import java.security.Provider;
import java.security.Security;

public class Actividad1 {

	public static void main(String[] args) {
		Provider provider = Security.getProvider("SUN");
		System.out.println("** Proveedor "+ provider.getName() + ", version "+ provider.getVersionStr()+"**");
		provider.getServices()
		.stream() // Permite recorrer todos los servicios. \\
		.filter(s -> s.getType().equals("MessageDigest")) // Filtra los servicios con el tipo MessageDigest \\
		.forEach(s -> System.out.println("\tNombre del dispositivo" + s.getAlgorithm())); // Recorre los servicios y saca por consola los nombres de los dispositivos \\
	}
	
}
