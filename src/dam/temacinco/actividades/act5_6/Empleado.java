package dam.temacinco.actividades.act5_6;
/**
 * Clase abstracta que define un constructor para todos los empleados
 * y declara un método abstracto que todas las subclases deberán definir
 * de maneras "personalizadas" usando polimorfismo.
 * @author LucíaLM
 * @version 1.0
 */
public abstract class Empleado {
	private String nombre, apellido1, apellido2, dni, direccion, telefono;
	private int antiguedad;
	// Si se quiere modificar con el método incrementarSalario, debe ser protected.
	protected double salario;
	private Empleado supervisor;

	public Empleado(String nombre, String apellido1, String apellido2, String dni,
			String direccion, String telefono, double salario, int antiguedad) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.salario = salario;
		this.antiguedad = antiguedad;
	}

	public String getNombre() {
		return nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public String getDni() {
		return dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public double getSalario() {
		return salario;
	}
	// Solo las clases derivadas pueden cambiar el supervisor.
	protected void setSupervisor(Empleado supervisor) {
		this.supervisor = supervisor;
	}
	// Solo se declaran los métodos para que las subclases los puedan implementar.
	protected abstract void incrementarSalario();

	/**
	 * Dos empleados son iguales si tienen el mismo dni.
	 */
	@Override
	public boolean equals(Object obj) {
		return ((Empleado)obj).dni.equalsIgnoreCase(this.dni);
	}
	
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", dni=" + dni
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", antiguedad=" + antiguedad + ", salario="
				+ salario + ", supervisor=" + supervisor + "]";
	}
}
