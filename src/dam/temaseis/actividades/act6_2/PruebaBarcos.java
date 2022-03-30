package dam.temaseis.actividades.act6_2;
import java.util.Scanner;
/**
 * Clase para probar el juego de hundir el barco.
 * Hay muchas cosas que no tengo claras y otras que no s� por d�nde
 * empezar a implementar. Sin embargo, algo necesario para jugar,
 * (no para las pruebas) es hacer invisibles las letras B de barco
 * e ir descubri�ndolas a medida que el jugador dispare.
 * @author LuciaLM
 * @version 1.0
 */
public class PruebaBarcos {

	public static void main(String[] args) {
		int filaDisparo, columnaDisparo;
		// El tercer par�metro es el n�mero de casillas que ocupar� el barco.
		// Se deber�an a�adir de forma aleatoria y sin ense�ar las posiciones al usuario.
		// La B de barco es para hacer m�s f�ciles las pruebas.
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
		String respuesta;
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
			// Confirmaci�n.
			System.out.println("�Disparar de nuevo? (si/no): ");
			respuesta = scan.next();
		} while(respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("s�"));
		scan.close();
	}
}