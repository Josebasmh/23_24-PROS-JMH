// Hilo.java

package code;

public class Hilo extends Thread{
	
	private String mensaje;
	
	public Hilo(String n, int p, String m) {
		setName(n);
		setPriority(p);
		mensaje = m;
	}
	public void run() {
		System.out.println("Ejecutando " + mensaje);
	}
}
