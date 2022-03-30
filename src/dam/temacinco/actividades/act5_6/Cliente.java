package dam.temacinco.actividades.act5_6;

public class Cliente {
	String nombre, apellido1, apellido2, dni;

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
	/**
	 * Dos clientes son iguales si tienen el mismo dni.
	 */
	@Override
	public boolean equals(Object obj) {
		return ((Cliente)obj).dni.equalsIgnoreCase(this.dni);
	}
}