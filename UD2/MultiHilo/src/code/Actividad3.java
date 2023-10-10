package code;

public class Actividad3 extends Thread{
	
	String nombre;
	int prioridad;
	public Actividad3(String n, int p) {
		nombre=n;
		prioridad=p;
		
	}
	@Override
	public void run() {
		System.out.println("El nombre del hilo es " + this.getName() + " y tiene la prioridad " + this.getPriority());
		this.setName(nombre);
		this.setPriority(prioridad);
		System.out.println("Ahora el nombre del hilo es " + this.getName() + " y tiene la prioridad " + this.getPriority());
		System.out.println("Final del programa");
	}
	public static void main(String[] args) {
		Actividad3 act = new Actividad3("SUPER-HILO-DM2", 6);
		act.start();
	}
}
