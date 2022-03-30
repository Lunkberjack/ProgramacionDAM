package dam.temaseis.actividades.act6_1;

public class PruebaArray {
	private final int MAYOR_RANDOM = 75;
	private final int MENOR_RANDOM = 1;
	private final int MAX_ARRAY = 5;
	private int[] array = new int[MAX_ARRAY];
	private int[][] arrayDuplicado = new int[this.array.length][];

	public static void main(String[] args) {
		PruebaArray pa = new PruebaArray();
		pa.mostrarArray();
		System.out.println(pa.menorArray());
		System.out.println(pa.mayorArray());
	}
	
	public void llenarArray() {
		for(int i=0; i < this.MAX_ARRAY; i++) {
			this.array[i] = i;
			// No entiendo por qué salen ceros.
			// this.array[i] = (int) ((Math.random() * (this.MAYOR_RANDOM - this.MENOR_RANDOM)) + this.MENOR_RANDOM);
		}
	}
	
	public int menorArray() {
		int res = this.array[0];
		for(int i=1; i < this.array.length; i++) {
			if(this.array[i] < res) {
				res = this.array[i];
			}
		}
		return res;
	}
	
	public int mayorArray() {
		int res = this.array[0];
		for(int i=1; i < this.array.length; i++) {
			if(this.array[i] > res) {
				res = this.array[i];
			}
		}
		return res;
	}
	
	public double mediaArray() {
		int suma = 0;
		int longitud = this.array.length;
		for(int i = 0; i < this.array.length; i++) {
			suma += this.array[i];
		}
		return suma/longitud;
	}
	
	public void mostrarArray() {
		for(int i = 0; i < this.array.length; i++) {
			System.out.println(this.array[i]);
		}
	}
}