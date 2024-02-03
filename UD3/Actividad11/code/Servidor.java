package code;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    public static void main(String[] args) {
    	
    	// SE DECLARA EL PUERTO Y ESPERA LA SOLICITUD DEL CLIENTE \\
        int p = 12391;
        try {
            DatagramSocket socket = new DatagramSocket(p);
            
            System.out.println("Esperando datagrama.......");

            while (true) {
            	// CREA EL DATAGRAMA \\
                DatagramPacket dtRecibo = new DatagramPacket(new byte[1024], 1024);

                // RECIBE EL ARRAY DE BYTES \\
                socket.receive(dtRecibo);

                // CONVERTIR DE ARRAY (BYTES) A OBJETO TENISTA \\ 
                Tenista t = convertirTenista(dtRecibo);

                // MOSTRAR LA INFORMACIÓN DEL TENISTA \\
                System.out.println("Recibo el objeto: " + t);
                System.out.println("IP de origen: " + dtRecibo.getAddress());
                System.out.println("Puerto de origen: " + dtRecibo.getPort());

                // SE MODIFICA EL OBJETO RECIBIDO \\
                t.setApellido("Karlovic");
                t.setAltura(208);

                // CONVIERTE EL OBJETO MODIFICADO EN DATAGRAMA \\
                InetAddress iaCliente = dtRecibo.getAddress();
                int pCliente = dtRecibo.getPort();
                byte[] byEnvio = convertirBytes(t);
                DatagramPacket dpEnvio = new DatagramPacket(byEnvio, byEnvio.length, iaCliente, pCliente);
                
                // ENVÍA EL DATAGRAMA AL CLIENTE \\
                socket.send(dpEnvio);

                // NOTIFICA EL ENVÍO \\
                System.out.println("Envío el objeto: " + t);
                
                // CIERRA EL SOCKET Y NOTIFICA EL FINAL \\
                socket.close();
                System.out.println("Fin del servidor");
            }
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