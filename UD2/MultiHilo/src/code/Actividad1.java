package code;

public class Actividad1 extends Thread{

	// Metodo run
	public void run() {
		int sw=0;
		for (int i=1;i<21;i++) {
			switch (sw) {
				case 0: {
					System.out.println("Primero: "+i);
					sw =1;
					
				}case 1:{
					System.out.println("Segundo: "+i);
					sw =0;
				}
			}	
		}
	}
	
	// Main
	public static void main(String[] args) {
		Actividad1 eje1 = new Actividad1();
		eje1.start();	
	}
}