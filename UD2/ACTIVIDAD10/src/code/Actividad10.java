// Actividad10.java

package code;

public class Actividad10 extends Thread{
	
	public void run(){
		this.setName("main");
		System.out.println(this.getName() + " tiene la prioridad " + this.getPriority());
		Hilo h1 = new Hilo("Thread-0",3,"Hilo-prioridad 3");
		Hilo h2 = new Hilo("Thread-1",7,"Hilo-prioridad 7");
		System.out.println(h1.getName() + " tiene la prioridad " + h1.getPriority());
		System.out.println(h2.getName() + " tiene la prioridad " + h2.getPriority());
		h1.start();
		h2.start();
		System.out.println("Final Programa");
	}
	public static void main(String[] args) {
		Actividad10 act = new Actividad10();
		act.start();
	}
}
