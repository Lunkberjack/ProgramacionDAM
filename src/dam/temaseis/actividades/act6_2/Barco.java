package dam.temaseis.actividades.act6_2;
/**
 * Clase que representa un barco en el juego de 
 * tocado y hundido. Suponemos que todos los barcos
 * son horizontales para simplificar.
 * @author LuciaLM
 * @version 1.0
 */
public class Barco {
	private int fila, eslora, contadorTocado, posicion;;
	private boolean tocado, hundido;

	/**
	 * Crea un barco (solo horizontal por ahora)
	 * especificando la fila en la que está, la posición
	 * en que comienza y la eslora (longitud).
	 * @param fila
	 * @param pos
	 * @param esl
	 */
	public Barco(int fila, int pos, int esl) {
		this.fila = fila;
		this.contadorTocado = 0;
		this.tocado = false;
		this.hundido = false;
		if(esl >= 2) {
			this.eslora = esl;	
		} else {
			// Por defecto, 2 unidades de eslora.
			this.eslora = 2;
		}
		this.posicion = pos;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	/**
	 * Tamaño del barco (2, 3 o 4 unidades).
	 * @return eslora
	 */
	public int getEslora() {
		return eslora;
	}

	public int getContadorTocado() {
		return contadorTocado;
	}

	public boolean isTocado() {
		return tocado;
	}

	public boolean isHundido() {
		return hundido;
	}

}