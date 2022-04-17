package dam.temaseis.actividades.act6_3_2;
import java.util.ArrayList;
/**
 * Clase que realiza algunas operaciones con ArrayList para estudiar 
 * sus métodos más importantes o usados.
 * @author LuciaLM
 * @version 1.0
 */
public class ArrayLists {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for(int i=1; i<=10; i++) {
			arr.add(i);
		}
		for(int i=0; i<=9; i++) {
			arr2.add(i);
		}
		
		// 1
		ArrayList<String> pares = new ArrayList<String>();
		for(int i=0; i<arr.size(); i++) {
			for(int j=0; j<arr2.size(); j++) {
				pares.add(arr.get(i) + " " + arr2.get(j));
			}
		}
		System.out.println("Todos los pares de arr + arr2:\n" + pares);
		
		// 2
		ArrayList<String> pares2 = new ArrayList<String>();
		for(int i=0; i<arr2.size(); i++) {
			for(int j=0; j<arr.size(); j++) {
				pares2.add(arr2.get(i) + " " + arr.get(j));
			}
		}
		System.out.println("Todos los pares de arr2 + arr:\n" + pares2);
		
		// 3
		ArrayList<Integer> comunesConArr2 = new ArrayList<Integer>();
		// "Clonación" entre comillas.
		for(int x : arr) {
			comunesConArr2.add(x);
		}
        // Ni el 0 ni el 10 aparecen en la nueva lista.
        comunesConArr2.retainAll(arr2);
        System.out.println("Comunes con arr2:\n" + comunesConArr2);
        
        // 4
		ArrayList<Integer> copiaArr = new ArrayList<Integer>();
		for(int x : arr) {
			copiaArr.add(x);
		}
		// Para que haya duplicados.
		copiaArr.add(2);
		copiaArr.add(5);
		System.out.println("Con duplicados:\n" + copiaArr);
        ArrayList<Integer> sinDuplicados = new ArrayList<Integer>();
        for(int x : copiaArr) {
        	if(!sinDuplicados.contains(x)) {
        		sinDuplicados.add(x);
        	}
        }
        System.out.println("Sin duplicados:\n" + sinDuplicados);
        
        // 5
        ArrayList<Integer> noEstanEnArrPeroSiEnArr2 = new ArrayList<Integer>();
		for(int x : arr2) {
			noEstanEnArrPeroSiEnArr2.add(x);
		}
        noEstanEnArrPeroSiEnArr2.removeAll(arr);
        System.out.println("No están en arr pero sí en arr2:\n" + noEstanEnArrPeroSiEnArr2);
	}
}