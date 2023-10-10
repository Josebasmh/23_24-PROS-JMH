package code;

public class Actividad5 extends Thread{

	int id;
	String texto;
	public Actividad5(int i) {
		id=i;
	}
	@Override
	public void run() {
		if (id==1){
			texto="PRIMERO ";
		}else {
			texto="SEGUNDO ";
		}
		for (int i=0;i<100;i++) {
			System.out.println(texto + i);
			try {
				if (id==1) {this.sleep(100);}else {this.sleep(200);}	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Fin de Programa");
	}
	public static void main(String[] args) {
		Actividad5 act1= new Actividad5(1);
		Actividad5 act2= new Actividad5(2);
		act1.start();
		act2.start();
	}
}
