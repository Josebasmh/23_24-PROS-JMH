package code;

class Hilo extends Thread { 
	Recurso a; 
	Recurso b; 

	public Hilo(Recurso a, Recurso b,String nombre) { 
		super(nombre); 
		this.a = a; 
		this.b = b; 
	}
	
	public void run(){ 
		System.out.println("Hilo " + this.getName() + " comienza"); 
		synchronized(a) { 
			try { 
				// se cambia la condicion del sleep a 0.
				// también se puede eliminar todo el try/catch
				Thread.sleep(0); 
			} catch (InterruptedException e) { 
			e.printStackTrace(); 
			} 
		synchronized(b) { 
		} 
		System.out.println("Hilo " + this.getName() + " ha terminado"); 
		} 
	} 
}
class Recurso{ 
}
