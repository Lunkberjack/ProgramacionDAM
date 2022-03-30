package dam.temaseis.actividades.act6_2;
import java.util.Scanner;
/**
 * Clase para probar el juego de hundir el barco.
 * 
 * El tercer parámetro es el número de casillas que ocupará el barco.
 * Se deberían añadir de forma aleatoria y sin enseñar las posiciones al usuario.
 * La B de barco es para hacer más fáciles las pruebas.
 * 
 * @author LuciaLM
 * @version 1.0
 */
public class PruebaBarcos {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int dimTablero, filaDisparo, columnaDisparo;
		Tablero oceano = new Tablero(8);
		System.out.println("Introduce un tamaño de tablero (4, 6 u 8): ");
		dimTablero = scan.nextInt();
		if((dimTablero == 4) || (dimTablero == 6) || (dimTablero == 8)) {
			oceano = new Tablero(dimTablero);
		} else {
			System.out.println("El tablero se iniciará con el valor por defecto, 8.");
		}
		oceano.inicializarCasillas();

		while(oceano.getNumBarcos() < oceano.getMAX_BARCOS()) {
			// Generará tres barcos aleatorios que no se superpongan.
			oceano.aniadirBarco(oceano.generarBarco());
		}
		
		boolean ganado = false;
		String respuesta = "";
		do {
			// Fila correcta.
			do {
				System.out.println("Introduce una fila:");
				filaDisparo = scan.nextInt();
			} while(filaDisparo < 0 || filaDisparo > oceano.getDIMENSION());
			// Columna correcta.
			do {
				System.out.println("Introduce una columna:");
				columnaDisparo = scan.nextInt();
			} while(columnaDisparo < 0 || columnaDisparo > oceano.getDIMENSION());
			oceano.recorrerDisparo(filaDisparo, columnaDisparo);
			ganado = oceano.comprobarGanado();
			if(ganado) {
				System.out.println("Felicidades, has hundido TODOS los barcos :)");
			} else {
				System.out.println("¿Disparar de nuevo? (si/no): ");
				respuesta = scan.next();
			}
		} while((respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("sí")) && ganado == false);
		scan.close();		
	}		
}