package code;

class HiloB extends Thread {
	private Contador contador;
	public HiloB (String n, Contador c) {
		setName(n);
		contador=c;
	}
	public void run () {
		
		try {
			while (contador.getValor()<400) {
			this.wait();
			}
		} catch (InterruptedException e) {}
		for (int j=0; j < 300; j++) {
			contador.decrementa();
		}
		System.out.println(getName() + " contador vale " + contador.getValor());	
	}
}
