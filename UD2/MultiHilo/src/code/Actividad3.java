package code;

public class Actividad3 extends Thread{
	
	// Variables
	String nombre;
	int prioridad;
	
	// Constructor
	public Actividad3(String n, int p) {
		nombre=n;
		prioridad=p;
		
	}
	
	// Metodo run
	@Override
	public void run() {
		System.out.println("El nombre del hilo es " + this.getName() + " y tiene la prioridad " + this.getPriority());
		this.setName(nombre);
		this.setPriority(prioridad);
		System.out.println("Ahora el nombre del hilo es " + this.getName() + " y tiene la prioridad " + this.getPriority());
		System.out.println("Final del programa");
	}
	
	// Main
	public static void main(String[] args) {
		Actividad3 act = new Actividad3("SUPER-HILO-DM2", 6);
		act.start();
	}
}
