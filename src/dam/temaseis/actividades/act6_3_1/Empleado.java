package dam.temaseis.actividades.act6_3_1;

public class Empleado implements Comparable {
	String nombre, apellido1, apellido2, telefono, nif;
	
	public Empleado(String nombre, String apellido1, String apellido2, String telefono, String nif) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.nif = nif;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String toString() {
		return "Nombre: " + nombre + "\nApellidos: " + apellido1 + " " + apellido2 +
				"\nTeléfono: " + telefono + "\nNif: " + nif + "\n\n";
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Empleado) {
			Empleado e = (Empleado)obj;
			this.nif.compareTo(e.nif);
		}
		return -1;
	}
}