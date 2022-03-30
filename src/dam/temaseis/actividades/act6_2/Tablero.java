package dam.temaseis.actividades.act6_2;
/**
 * Tablero para el juego de hundir el barco.
 * @author LuciaLM
 * @version 1.0
 */
public class Tablero {
	private final int MAX_BARCOS = 3;
	private final int DIMENSION;
	private Barco[] barcos;
	private char[][] casillas;
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
					System.out.println("Se ha añadido un barco de coordenadas: \n\n");
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
			this.casillas[fila-1][columna-1] = 'T';
			System.out.println("\nHas TOCADO un barco\n\n");
			for(Barco b : this.barcos) {
				b.addTocada(coordenada);
			}
			// A ver si toca alguno de los barcos.
			for(Barco b : this.barcos) {
				if(b.comprobarHundido()) {
					System.out.println("Has HUNDIDO un barco :)");
				}
			}
		} else {
			System.out.println("Agua\n\n");
		}
		this.mostrarTablero();
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
	public int getMAX_BARCOS() {
		return MAX_BARCOS;
	}
	public int getDIMENSION() {
		return DIMENSION;
	}
}
