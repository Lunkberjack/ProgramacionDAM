package dam.temaseis.actividades.act6_2;
import java.util.Scanner;
/**
 * Clase para probar el juego de hundir el barco.
 * 
 * El tercer par�metro es el n�mero de casillas que ocupar� el barco.
 * Se deber�an a�adir de forma aleatoria y sin ense�ar las posiciones al usuario.
 * La B de barco es para hacer m�s f�ciles las pruebas.
 * 
 * @author LuciaLM
 * @version 1.0
 */
public class PruebaBarcos {

	public static void main(String[] args) {
		int filaDisparo, columnaDisparo;
		Barco dreadnought = new Barco(1, 2, 4);
		// Dar� error. Por experiencia. He a�adido manejo de excepciones.
		dreadnought.getCoordenadas();
		// El Yamato se superpone y no se coloca en el tablero.
		Barco yamato = new Barco(1, 2, 2);
		Barco bismarck = new Barco(8, 5, 3);
		Tablero oceano = new Tablero(8);
		oceano.aniadirBarco(dreadnought);
		System.out.println("Coordenadas del Dreadnought: ");
		dreadnought.getCoordenadas();
		oceano.aniadirBarco(yamato);
		oceano.aniadirBarco(bismarck);
		// No deja a�adir m�s de tres barcos. (Recordemos que uno no se pudo
		// colocar y por tanto no son cuatro, sino tres).
		Barco akagi = new Barco(3, 2, 2);
		oceano.aniadirBarco(akagi);
		oceano.aniadirBarco(new Barco(5, 6, 3));

		
		Scanner scan = new Scanner(System.in);
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
				System.out.println("�Disparar de nuevo? (si/no): ");
				respuesta = scan.next();
			}
		} while((respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("s�")) && ganado == false);
		scan.close();
	}
}