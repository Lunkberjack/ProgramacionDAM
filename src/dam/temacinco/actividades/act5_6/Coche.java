package dam.temacinco.actividades.act5_6;

public class Coche {
	private String matricula, marca, modelo;

	public Coche(String matricula, String marca, String modelo) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
}
