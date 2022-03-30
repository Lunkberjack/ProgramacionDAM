package dam.temaseis.actividades.act6_2;

import java.util.Random;

/**
 * Tablero para el juego de hundir los barcos.
 * @author LuciaLM
 * @version 1.0
 */
public class Tablero {
	private final int MAX_BARCOS = 3;
	private final int DIMENSION;
	private Barco[] barcos;
	private char[][] casillas;
	private Coordenada[] coordenadas;
	private int numBarcos = 0;

	public Tablero(int dimension) {
		this.barcos = new Barco[MAX_BARCOS];
		switch (dimension) {
		case 4:
			this.DIMENSION = 4;
			break;
		case 6:
			this.DIMENSION = 6;
			break;
		case 8:
			this.DIMENSION = 8;
			break;
		default:
			this.DIMENSION = 8;
			break;
		}
		this.casillas = new char[this.DIMENSION][this.DIMENSION];
		this.coordenadas = new Coordenada[this.DIMENSION*this.DIMENSION];
		this.rellenarTablero();
	}
	/**
	 * Se crea el tablero desde aquí. Rellena todo de agua.
	 * Private porque solo se debe llamar desde el constructor.
	 */
	private void rellenarTablero() {
		// Para los números de columna.
		System.out.print(" ");
		for(int i = 0; i < this.DIMENSION; i++) {
			System.out.print("  " + (i+1));
		}
		System.out.println("\n  --------------------");

		for(int i = 0; i < this.DIMENSION; i++) {
			// Para los números de fila.
			System.out.print(i + 1 + "| ");
			for(int j = 0; j < this.DIMENSION; j++) {
				// A de agua, por ahora.
				casillas[i][j] = 'A';
				System.out.print(casillas[i][j] + "  ");
			}
			System.out.println();
		}
	}
	/**
	 * Procedimiento que dibuja el tablero actualizado.
	 */
	public void mostrarTablero() {
		System.out.println("ESTADO DEL TABLERO:");
		System.out.print(" ");
		for(int i = 0; i < this.DIMENSION; i++) {
			System.out.print("  " + (i+1));
		}
		System.out.println("\n  -----------------------");
		for(int i = 0; i < this.DIMENSION; i++) {
			// Para los números de fila.
			System.out.print(i + 1 + "| ");
			for(int j = 0; j < this.DIMENSION; j++) {
				System.out.print(casillas[i][j] + "  ");
			}
			System.out.println();
		}
		// Espaciado
		System.out.println();
	}
	
	/**
	 * Función que implementé pero no tiene funcionalidad porque
	 * no pude usarla como tenía pensado.
	 * Tener en cuenta que la coordenada[0] es (1,1).
	 */
	public void inicializarCasillas() {
		Coordenada coordAniadir = new Coordenada(0,0);
		for(int i = 0; i < this.DIMENSION; i++) {
			coordAniadir.setX(i+1);
			for(int j = 0; j < this.DIMENSION; j++) {
				coordAniadir.setY(j+1);
				coordAniadir.setAgua(true);
				this.coordenadas[i] = coordAniadir;
			}
		}
	}
	
	/**
	 * Genera un barco con parámetros aleatorios.
	 * @return barco
	 */
	public Barco generarBarco() {
		Random alea = new Random();
		int linea, posicion, eslora;
		// El mínimo es 1.
		linea = alea.nextInt(this.DIMENSION) + 1;
		posicion = alea.nextInt(this.DIMENSION) + 1;
		// De que la eslora no pueda ser menor a 2 o mayor a 4 se encarga el setEslora. Con el +1
		// nos aseguramos de que se llegue a 4 unidades. 
		eslora = alea.nextInt((Barco.getMaxEslora()+1 - Barco.getMinEslora()) + Barco.getMinEslora());
		Barco barco = new Barco(linea, posicion, eslora);
		System.out.println("Barco aleatorio, linea: " + linea + ", posicion: " + posicion + ", eslora: " + barco.getEslora());
		return barco;
	}
	/**
	 * Comprueba que el barco se pueda añadir y, si es el caso, lo añade.
	 * @param barco
	 */
	public void aniadirBarco(Barco barco) {
		boolean prohibido = false;
		int posicionFinal = barco.getPosicion() + barco.getEslora();
		if (this.numBarcos < this.MAX_BARCOS) {
			if(posicionFinal > this.DIMENSION) {
				System.out.println("El barco es demasiado grande para el tablero.\n\n");
			} else {
				// Solo barcos horizontales.
				for(int i = barco.getFila()-1; i < barco.getFila(); i++) {
					for (int j = barco.getPosicion()-1; j < posicionFinal-1; j++) {
						// Así no se superponen barcos.
						if(this.casillas[i][j] != 'A') {
							prohibido = true;
						}
					}
				}
				// El barco solo se empieza a "pintar" cuando se confirma que ninguna de sus casillas
				// está ocupada. Si no, se podría pintar un trozo de barco delante o detrás de otro.
				if(!prohibido) {
					for(int i = barco.getFila()-1; i < barco.getFila(); i++) {
						for (int j = barco.getPosicion()-1; j < posicionFinal-1; j++) {
							this.casillas[i][j] = 'B';
							barco.addCoordenada(new Coordenada(i+1, j+1));
						}
					}
					// Se añade el barco al array.
					this.barcos[numBarcos] = barco;
					this.numBarcos++;
					this.mostrarTablero();
					System.out.println("Se ha añadido un barco de coordenadas:");
					barco.getCoordenadas();
					// Aquí manejar las coordenadas en las que se coloca el barco
				} else {
					System.out.println("Elige una posición en la que los barcos no se superpongan.\n\n");
				}
			}
		} else {
			System.out.println("Demasiados barcos. Solo se pueden añadir " + this.MAX_BARCOS + ".\n\n");
			this.mostrarTablero();
		}
	}
	/**
	 * Coloca una T si se ha tocado un barco, y avisa al jugador.
	 * @param fila
	 * @param columna
	 */
	public void recorrerDisparo(int fila, int columna) {
		Coordenada coordenada = new Coordenada(fila-1, columna-1);
		if(this.casillas[coordenada.getX()][coordenada.getY()] == 'B') {
			this.casillas[coordenada.getX()][coordenada.getY()] = 'T';
			System.out.println("\nHas TOCADO un barco\n\n");
			for(Barco b : this.barcos) {
				b.addTocada(coordenada);
			}
			// A ver si toca alguno de los barcos.
			for(Barco b : this.barcos) {
				if(b.comprobarHundido()) {
					for(Coordenada c : b.coordenadas) {
						this.casillas[c.getX()-1][c.getY()-1] = 'H';
						// Ya no están tocadas: así no aparece el mensaje
						// de que has hundido un barco aunque sea un turno
						// posterior.
						c.setTocada(false);
					}
					System.out.println("Has HUNDIDO un barco :)\n");
				}
			}
		} else if (this.casillas[coordenada.getX()][coordenada.getY()] == 'A'){
			System.out.println("Agua.\n");
		} else {
			System.out.println("Has disparado a un barco o a una parte ya hundidos.\n");
		}
		this.mostrarTablero();
	}
	
	/**
	 * Se comprueba que todos los barcos se hayan hundido.
	 * @return ganado
	 */
	public boolean comprobarGanado() {
		boolean ganado = true;
		for(Barco b : this.barcos) {
			// Si algún barco no se ha hundido, no se ha ganado.
			if(!b.isHundido()) {
				ganado = false;
			}
		}
		return ganado;
	}

	public Barco[] getBarcos() {
		return barcos;
	}
	public void setBarcos(Barco[] barcos) {
		this.barcos = barcos;
	}
	public char[][] getCasillas() {
		return casillas;
	}
	public void setCasillas(char[][] casillas) {
		this.casillas = casillas;
	}
	public int getNumBarcos() {
		return numBarcos;
	}
	public int getMAX_BARCOS() {
		return MAX_BARCOS;
	}
	public int getDIMENSION() {
		return DIMENSION;
	}
}
