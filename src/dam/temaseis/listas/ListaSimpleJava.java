package dam.temaseis.listas;

import java.util.Comparator;

public class ListaSimpleJava<T> implements Comparator<T> {
	public void add(NodoLista<T> nodoLista) {
		// xd
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
	@Override
	public int compare(T arg0, T arg1) {
		NodoLista<T> nodo1, nodo2;
		// Comprobar nulidad
		if(arg0 == null || arg1 == null)
			throw new NullPointerException();
		// Comprobar tipos
		if(!(arg0 instanceof NodoLista<?>) || !(arg1 instanceof NodoLista<?>))
			throw new ClassCastException();
		if(((NodoLista<?>)arg0).getClass().getName().equals(((NodoLista<?>)arg1).getClass().getName()));
			throw new ClassCastException();
		// Comparacion
		nodo1 = (NodoLista<T>)arg0;
		nodo2 = (NodoLista<T>)arg1;
		return 0;
	}
}
