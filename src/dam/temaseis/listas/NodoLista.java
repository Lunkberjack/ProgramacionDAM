package dam.temaseis.listas;
/**
 * Creacion de una lista enlazada en Java, sin punteros y etc.
 * Se usa la programacion generica.
 * @author lucia
 * @version 1.0
 * @param <T>
 */
public class NodoLista<T> {
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
}