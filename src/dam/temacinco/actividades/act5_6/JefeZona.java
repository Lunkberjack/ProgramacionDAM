package dam.temacinco.actividades.act5_6;

import java.util.Arrays;

public class JefeZona extends Empleado {
	private String despacho;
	private Secretario secretario;
	private Vendedor[] vendedores;
	private int numVendedores;
	private Coche coche;
	private final int INCREMENTO_JEFE_ZONA = 20;
	private final int MAX_VENDEDORES = 10;
	
	public JefeZona(String nombre, String apellido1, String apellido2, String dni, String direccion, String telefono,
			double salario, int antiguedad) {
		super(nombre, apellido1, apellido2, dni, direccion, telefono, salario, antiguedad);
		
		this.vendedores = new Vendedor[MAX_VENDEDORES];
	}

	@Override
	protected void incrementarSalario() {
		this.salario += this.salario*INCREMENTO_JEFE_ZONA/100*this.getAntiguedad();
	}
	
	public void cambiarSecretario (Secretario secretario) {
		if(secretario != null) {
			this.secretario = secretario;
		} else {
			System.out.println("Ha pasado un objeto Secretario nulo");
		}
	}
	
	public void cambiarCoche (Coche coche) {
		if(coche != null) {
			this.coche = coche;
		} else {
			System.out.println("Ha pasado un objeto Coche nulo");
		}
	}
	
	public void altaVendedor(Vendedor vendedor) {
		// Permite añadir al mismo vendedor muchas veces (para PruebaEmpleado).
		if(numVendedores < vendedores.length) {
			vendedores[numVendedores] = vendedor;
			this.numVendedores++;
		} else {
			// Nos evitamos una excepción por ArrayIndexOutOfBounds, pero 
			// debemos informar si la operación no se realiza.
			System.out.println("No se pueden añadir más vendedores");
		}
	}
	
	public void bajaVendedor(Vendedor vendedor) {
		for(int i=0; i < numVendedores; i++) {
			if(vendedores[i].equals(vendedor)) {
				// Dejaría un hueco vacío
				vendedores[i] = null;
			} else {
				System.out.println("El vendedor no se ha encontrado");
			}
		}
	}
	
	public void getVendedores() {
		for(int i=0; i < this.numVendedores; i++) {
			System.out.println(this.vendedores[i].toString());
		}
	}
	
	public String getDespacho() {
		return despacho;
	}

	public Secretario getSecretario() {
		return secretario;
	}

	public int getNumVendedores() {
		return numVendedores;
	}

	public Coche getCoche() {
		return coche;
	}

	public int getINCREMENTO_JEFE_ZONA() {
		return INCREMENTO_JEFE_ZONA;
	}

	public int getMAX_VENDEDORES() {
		return MAX_VENDEDORES;
	}

	@Override
	public String toString() {
		return "JefeZona [despacho=" + despacho + ", secretario=" + secretario + ", vendedores="
				+ Arrays.toString(vendedores) + ", coche=" + coche + ", INCREMENTO_JEFE_ZONA=" + INCREMENTO_JEFE_ZONA
				+ ", getNombre()=" + getNombre() + ", getApellido1()=" + getApellido1() + ", getApellido2()="
				+ getApellido2() + ", getDni()=" + getDni() + ", getDireccion()=" + getDireccion() + ", getTelefono()="
				+ getTelefono() + "]";
	}
}