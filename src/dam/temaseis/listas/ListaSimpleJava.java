package dam.temaseis.listas;
import java.util.Comparator;
/**
 * Implementación de una lista enlazada simple en Java, sin punteros y etc.
 * Se usa la programacion generica.
 * @author LuciaLM
 * @version 1.0
 * @param <T>
 */
public class ListaSimpleJava<T> implements Comparator<T> {
	// Mantiene la referencia al nodo inicial
	private NodoLista<T> inicio = null;
	private int size = 0;
	/**
	 * Anyade al final de la lista.
	 * Si la lista esta vacia el nuevo nodo es el primero y el ultimo.
	 * Si no esta vacia hay que recorrerla desde el inicio hasta el final. 
	 * @param nodoLista
	 */
	public void add(NodoLista<T> nodoLista) {
		// Es mas correcto llamar al metodo que poner una logica porque
		// asi, si esta cambia, solo se cambia en el propio metodo.
		if(this.isEmpty()) {
			this.inicio = nodoLista;
			this.inicio.setSiguiente(null);
		} else {
			NodoLista<T> actual = inicio;
			while(actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
			}
			// Final de la lista tras el bucle.
			actual.setSiguiente(nodoLista);
			this.size++;
		}
	}
	public boolean insert(NodoLista<T> nodoLista, int pos) {
		boolean inserted = true;
		int index = 0;
		NodoLista<T> actual = null;
		// La lista esta vacia.
		if(this.isEmpty())
			return false;
		// La posicion de insercion no es correcta.
		if(pos<1 || pos>this.getSize()+1)
			return false;
		// Se intenta insertar al principio de la lista.
		if(pos == 1) {
			nodoLista.setSiguiente(this.inicio);
			this.inicio = nodoLista;
			this.size++;
			return true;
		} else if(pos == (this.size)+1) {
			// Se intenta insertar al final.
			actual = this.inicio;
			while(actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
			}
			actual.setSiguiente(nodoLista);
			this.size++;
			return true;
		} else {
			// Se intenta insertar en medio.
			actual = this.inicio;
			while(index<pos) {
				actual = actual.getSiguiente();
				index++;
			}
			nodoLista.setSiguiente(actual.getSiguiente());
			actual.setSiguiente(nodoLista);
			this.size++;
			return true;
	}
}
	/**
	 * Si devuelve nulo, no lo ha encontrado. Si devuelve un objeto,
	 * lo ha encontrado y eliminado.
	 * @param nodoLista
	 * @return
	 */
	public NodoLista<T> delete(NodoLista<T> nodoLista) {
		NodoLista<T> toDelete = null;
		return toDelete;
	}
	public NodoLista<T> get(NodoLista<T> nodoLista) {
		NodoLista<T> found = null;
		return found;
	}
	public void sort(Comparator<T> cmp) {
		// xd
	}
	public boolean isEmpty() {
		boolean empty = false;
		return empty;
	}
	@Override
	public int compare(T arg0, T arg1) {
		NodoLista<T> nodo1, nodo2;
		// Comprobar nulidad
		if(arg0 == null || arg1 == null)
			throw new NullPointerException();
		// Comprobar tipos
		if(!(arg0 instanceof NodoLista<?>) || !(arg1 instanceof NodoLista<?>))
			throw new ClassCastException();
		if(((NodoLista<?>)arg0).getClass().getName().equals(((NodoLista<?>)arg1).getClass().getName())) {
			throw new ClassCastException();
		}
		// Comparacion
		nodo1 = (NodoLista<T>)arg0;
		nodo2 = (NodoLista<T>)arg1;
		return 0;
	}
	public int getSize() {
		return size;
	}
}
