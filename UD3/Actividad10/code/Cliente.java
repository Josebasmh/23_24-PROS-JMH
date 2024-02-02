package code;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
	
	public static void main(String[] args) {
		// DECLARA EL OBJETO QUE SE ENVÍA Y LOS PUERTOS \\
		Tenista t = new Tenista("del Potro", 198);
		int pServidor = 12391;
		int p = 34567;
		
		try {
            // CONVIERTE TENISTA EN ARRAY DE BYTES \\
            byte[] datos = convertirBytes(t);
            
            // CREA EL SOCKET CON EL PUERTO Y EL DATAGRAMA DE ENVÍO CON EL ARRAY DE BYTES \\
            DatagramSocket dsSocket = new DatagramSocket(p);
            DatagramPacket dpEnvio = new DatagramPacket(datos, datos.length, InetAddress.getByName("localhost"), pServidor);

            // ENVÍA EL ARRAY DE BYTES AL SERVIDOR EN EL DATAGRAMA \\
            dsSocket.send(dpEnvio);

            // NOTIFICA EL ENVÍO \\
            System.out.println("Envío el objeto: " + t);

            // ESPERA RESPUESTA DE SERVIDOR \\
            System.out.println("Esperando datagrama.......");
            
            // CREA EL DATAGRAMA \\
            DatagramPacket dpRecibo = new DatagramPacket(new byte[1024], 1024);
            
            // RECIBE EL ARRAY DE BYTES Y LO CARGA EN EL DATAGRAMA \\
            dsSocket.receive(dpRecibo);

            // CONVIERTE EL ARRAY DE BYTES EN TENISTA \\
            Tenista tModificado = convertirTenista(dpRecibo);

            // NOTIFICA EL RECIBIMIENTO MOSTRANDO EL TENISTA \\
            System.out.println("He recibido el objeto: " + tModificado);

            // CIERRA EL SOCKET Y NOTIFICA EL FINAL \\
            dsSocket.close();
            System.out.println("Fin del cliente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	/**
     * Recibe un objeto y lo devuelve convertido en un array de bytes.
     * @param object
     * @return array de bytes
     * @throws IOException
     */
    private static byte[] convertirBytes(Object t) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(t);
            return bos.toByteArray();
        }
    }

    /**
     * Recibe un datagrama y lo devuelve convertido en tenista.
     * @param dp (DatagramPacket).
     * @return Tenista
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static Tenista convertirTenista(DatagramPacket dp) throws IOException, ClassNotFoundException {
    	ByteArrayInputStream bais = new ByteArrayInputStream(dp.getData());
        ObjectInputStream ois = new ObjectInputStream(bais);
    	return (Tenista) ois.readObject();
    	
    }
}
