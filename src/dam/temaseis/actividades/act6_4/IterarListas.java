package dam.temaseis.actividades.act6_4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;
/**
 * Se refiere a usar conjuntos (LinkedHashSet, TreeSet) y listas (LinkedList, ArrayList) para
 * solucionar el mismo problema que el de la actividad 6.3. Se trata de utilizar operaciones
 * pertenecientes a conjuntos para optimizar la solución dada en la actividad 6.3.
 * 
 * 1) Una lista con todos los pares de números que podemos formar con uno de la primera lista y
 * 	otro de la segunda.
 * 2) Una lista con todos los pares de números que podemos formar con uno de la segunda lista
 * 	otro de la primera.
 * 3) Una lista con todos los elementos de la lista del punto 1 que existen en la lista del
 * 	punto 2.
 * 4) Mostrar los elementos de la lista 1 sin repetición, es decir sin elementos repetidos.
 * 5) Mostrar los elementos de la lista 2 que no están en la lista 1.
 * 
 * @author LuciaLM
 * @version 1.0
 */
public class IterarListas {
	public static void main(String[] args) {
		// AP. 1
		// LinkedHashSet ----------------------------------------------------
		// TreeSet ----------------------------------------------------------
		// LinkedList -------------------------------------------------------
		// ArrayList --------------------------------------------------------
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
		
		
		// AP.2
		// LinkedHashSet ----------------------------------------------------
		// TreeSet ----------------------------------------------------------
		// LinkedList -------------------------------------------------------
		// ArrayList --------------------------------------------------------
		
		// AP. 3
		// LinkedHashSet ----------------------------------------------------
		/*
		LinkedHashSet<Integer> hashSet1 = new LinkedHashSet<Integer>();
		LinkedHashSet<Integer> hashSet2 = new LinkedHashSet<Integer>();
		Iterator<Integer> itConjunto = hashSet1.iterator();
		// Rellenamos los conjuntos:
		for(int i=1; i<=5; i++) {
			hashSet1.add(i);
		}
		for(int i=4; i<=8; i++) {
			hashSet2.add(i);
		}
		while(itConjunto.hasNext()) {
			int num = itConjunto.next();
			System.out.print(num + " ");
		}
		// Intersección de conjuntos:
		hashSet1.retainAll(hashSet2);
		System.out.print("LinkedHashSet: ");
		while(itConjunto.hasNext()) {
			Integer num = (Integer) itConjunto.next();
			System.out.print(num + " ");
		}
		*/
		// Treeset ----------------------------------------------------------
		TreeSet<Integer> arbol1 = new TreeSet<Integer>();
		TreeSet<Integer> arbol2 = new TreeSet<Integer>();
		Iterator<Integer> it = arbol1.iterator();
		// Rellenamos los árboles:
		for(int i=1; i<=5; i++) {
			arbol1.add(i);
		}
		for(int i=4; i<=8; i++) {
			arbol2.add(i);
		}
		// Intersección de conjuntos:
		System.out.println();
		arbol1.retainAll(arbol2);
		while(it.hasNext()) {
			Integer c=(Integer) it.next();
			System.out.print(c + " ");
		}

		// AP.4
		// LinkedHashSet ----------------------------------------------------
		// TreeSet ----------------------------------------------------------
		// LinkedList -------------------------------------------------------
		// ArrayList --------------------------------------------------------
		
		// AP. 5
		// Treeset ----------------------------------------------------------
		TreeSet<Integer> arbol3 = new TreeSet<Integer>();
		TreeSet<Integer> arbol4 = new TreeSet<Integer>();
		for(int i=1;i<=10;i++) {
			arbol3.add(i);
		}
		for(int i=0;i<=9;i++) {
			arbol4.add(i);
		}
		
		TreeSet<Integer> arbol5 = new TreeSet<Integer>();
		arbol5 = (TreeSet<Integer>) arbol5.clone();  // Lista de clones1
		arbol5.removeAll(arbol4);// A-B se coloca en la lista1
		arbol4.removeAll(arbol5);// B-A se coloca en la lista2
		arbol5.addAll(arbol4);// Encuentra la unión de A y B

		Iterator<Integer> iter=arbol5.iterator();
		System.out.println();
		while(iter.hasNext()) {
			Integer c=(Integer) iter.next();
			System.out.print(c+" ");    
		}
		
		// LinkedList -------------------------------------------------------
		LinkedList<Integer> lista3 = new LinkedList<Integer>();
		LinkedList<Integer> lista4 = new LinkedList<Integer>();
		for(int i=1;i<=10;i++) {
			lista3.add(i);
		}
		for(int i=0;i<=9;i++) {
			lista4.add(i);
		}
		
		LinkedList<Integer> lista5 = new LinkedList<Integer>();
		lista5 = (LinkedList<Integer>) lista5.clone();  // Lista de clones1
		lista5.removeAll(lista4);// A-B se coloca en la lista1
		lista4.removeAll(lista5);// B-A se coloca en la lista2
		lista5.addAll(lista4);// Encuentra la unión de A y B

		Iterator<Integer> itLinked = lista5.iterator();
		System.out.println();
		while(itLinked.hasNext()) {
			Integer c=(Integer) itLinked.next();
			System.out.print(c+" ");    
		}
	}
}