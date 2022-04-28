package dam.temaseis.listas;

import java.util.Comparator;

/**
 * Cada nodo de una lista enlazada en Java.
 * @author lucia
 * @version 1.0
 * @param <T>
 */
public class NodoLista<T> implements Comparator<T> {
	private T info;
	private NodoLista<T> siguiente;
	public NodoLista(T info, NodoLista<T> siguiente) {
		this.info = info;
		this.siguiente = siguiente;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public NodoLista<T> getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoLista<T> siguiente) {
		this.siguiente = siguiente;
	}
	@Override
	public int compare(T arg0, T arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
}