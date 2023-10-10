package code;

public class Actividad2 extends Thread{

	// Variables
	int n;
	
	// Constructor
	public Actividad2(int n) {
		this.n=n;
	}
	
	// Metodo run
	@Override
	public void run() {
		for (int i=0;i<20;i++) {
			System.out.println("Hilo " + n);
		}
	}
	
	// Main
	public static void main(String[] args) {
		Actividad2 act21= new Actividad2(1);
		Actividad2 act22= new Actividad2(2);
		act21.start();
		act22.start();
		System.out.println("Fin del programa");
	}
}
