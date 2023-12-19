package code;

public class Tenista {

	private String apellido;
	private Integer altura;
	
	/**
	 * Clase pública para guardar datos de tenistas
	 * @param ap apellido
	 * @param al altura
	 */
	public Tenista(String ap,Integer al) {
		apellido=ap;
		altura=al;
	}

	// Métodos getter y setter
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return apellido + altura;
	}
	
	
	
}
