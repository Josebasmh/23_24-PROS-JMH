package code;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Hilo extends Thread { 
	int numero;
	
	// identificar el hilo mediante el número de la clase
	public Hilo(int n) {
		numero=n;
	}
	
	@Override
	public void run() {
		// dar formato para la hora
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		for(int i=0;i<5;i++) {
			// escribir por pantalla el identificador y la hora actual
			System.out.println("Hilo " + numero + " - " + dtf.format(LocalDateTime.now()));
			try {
				// espera 1 segundo
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	} 
}

