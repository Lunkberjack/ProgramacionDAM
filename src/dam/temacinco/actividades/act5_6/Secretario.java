package dam.temacinco.actividades.act5_6;
/**
 * Clase derivada de Empleado (clase abstracta).
 * @author LucíaLM
 * @version 1.0
 */
public class Secretario extends Empleado {
	// Despacho podría ser una clase aparte, pero queda fuera del enunciado.
	private String despacho;
	private String numFax;
	private final int INCREMENTO_SECRETARIO = 5;
	public Secretario(String nombre, String apellido1, String apellido2, String dni, String direccion, String telefono,
			double salario, int antiguedad) {
		super(nombre, apellido1, apellido2, dni, direccion, telefono, salario, antiguedad);
	}

	/**
	 * El salario era una determinada cantidad el primer año que ha ido creciendo
	 * un determinado porcentaje cada año que ha pasado. Supongo que ese porcentaje
	 * se ha aplicado a la cantidad inicial y no a la incrementada (para simplificar).
	 */
	@Override
	public void incrementarSalario() {
		this.salario += this.salario*INCREMENTO_SECRETARIO/100*this.getAntiguedad();
	}

	@Override
	public String toString() {
		// He supuesto que el puesto en la empresa es el nombre de clase.
		return "Secretario [despacho=" + despacho + ", numFax=" + numFax + ", INCREMENTO_SECRETARIO="
		+ INCREMENTO_SECRETARIO + ", getNombre()=" + getNombre() + ", getApellido1()=" + getApellido1()
		+ ", getApellido2()=" + getApellido2() + ", getDni()=" + getDni() + ", getDireccion()=" + getDireccion()
		+ ", getTelefono()=" + getTelefono() + ", getClass()=" + getClass().getName() + "]";
	}
}