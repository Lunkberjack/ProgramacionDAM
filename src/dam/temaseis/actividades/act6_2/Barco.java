package dam.temaseis.actividades.act6_2;
/**
 * Clase que representa un barco en el juego de 
 * tocado y hundido. Suponemos que todos los barcos
 * son horizontales para simplificar.
 * @author LuciaLM
 * @version 1.0
 */
public class Barco {
	private int fila, eslora, contadorTocado, posicion, numCoordenadas = 0;
	private final int MAX_ESLORA = 4;
	private final int MIN_ESLORA = 2;
	private boolean tocado, hundido;
	protected Coordenada[] coordenadas;

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
		this.setEslora(esl);
		this.posicion = pos;
		// Se crea un array con un cierto número de coordenadas
		// según la eslora del barco.
		this.coordenadas = new Coordenada[this.eslora];
	}

	public void addCoordenada(Coordenada coord) {
		if(this.numCoordenadas < this.eslora) {
			this.coordenadas[numCoordenadas] = coord;
			this.numCoordenadas++;
		}
	}

	public void addTocada(Coordenada coord) {
		for(Coordenada c : this.coordenadas) {
			System.out.println("Ha entrao al método " + c.getX() + " " + coord.getX());
			if(c.getX() == coord.getX() && c.getY() == coord.getY()) {
				coord.tocada = true;
				System.out.println("Has tocado la coordenada " + coord.toString());
			}
		}
	}
	
	public boolean comprobarHundido() {
		boolean hundido = true;
		for(Coordenada c : this.coordenadas) {
			if(!c.tocada) {
				hundido = false;
			}
		}
		return hundido;
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
	public void setEslora(int eslora) {
		if(eslora >= MIN_ESLORA && eslora <= MAX_ESLORA) {
			this.eslora = eslora;	
		} else {
			// Por defecto, 2 unidades de eslora.
			this.eslora = MIN_ESLORA;
			System.out.println("Eslora máxima: " + this.MAX_ESLORA + ". Se inicializará con el "
					+ "valor por defecto: " + this.MIN_ESLORA);
		}
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

	public void getCoordenadas() {
		try {
			for(Coordenada coord : this.coordenadas) {
				System.out.println(coord.toString());
			}
		} catch (NullPointerException e) {
			System.out.println("El barco todavía no ha sido añadido al tablero.");
		}
	}
}