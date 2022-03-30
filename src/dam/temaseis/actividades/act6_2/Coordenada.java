package dam.temaseis.actividades.act6_2;

public class Coordenada {
	private int x, y;
	boolean tocada;
	
	public Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}
