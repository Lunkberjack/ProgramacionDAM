package dam.temaseis.actividades.act6_2;
/**
 * Coordenadas de un barco. Puede estar tocada o no, y tiene dos dimensiones.
 * @author LuciaLM
 * @version 1.0
 */
public class Coordenada {
	private int x, y;
	private boolean agua, barco, tocada;
	
	public Coordenada(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public boolean isAgua() {
		return agua;
	}
	public void setAgua(boolean agua) {
		this.agua = agua;
	}
	public boolean isBarco() {
		return barco;
	}
	public void setBarco(boolean barco) {
		this.barco = barco;
	}
	public boolean isTocada() {
		return tocada;
	}
	public void setTocada(boolean tocada) {
		this.tocada = tocada;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}