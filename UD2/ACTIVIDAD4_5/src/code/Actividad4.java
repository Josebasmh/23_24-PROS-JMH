package code;

public class Actividad4 extends Thread{

	int id;
	String texto;
	public Actividad4(int i) {
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
		}
		System.out.println("Fin de Programa");
	}
	public static void main(String[] args) {
		Actividad4 act1= new Actividad4(1);
		Actividad4 act2= new Actividad4(2);
		act1.start();
		act2.start();
	}
}
