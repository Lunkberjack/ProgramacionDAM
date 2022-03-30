package dam.temacinco.actividades.act5_6;

public class Vendedor extends Empleado {
	private Coche cocheEmpresa;
	private String areaVenta, movil;
	private Cliente[] clientes;
	private int numClientes;
	private final int COMISION = 15;
	private final int INCREMENTO_VENDEDOR = 10;
	private final int MAX_VENDEDORES = 10;
	
	public Vendedor(String nombre, String apellido1, String apellido2, String dni, String direccion, String telefono,
			double salario, int antiguedad) {
		super(nombre, apellido1, apellido2, dni, direccion, telefono, salario, antiguedad);
		this.clientes = new Cliente[MAX_VENDEDORES];
	}
	
	@Override
	protected void incrementarSalario() {
		this.salario += this.salario*INCREMENTO_VENDEDOR/100*this.getAntiguedad();
	}
	
	public void altaCliente(Cliente cliente) {
		if(numClientes < clientes.length) {
			clientes[numClientes] = cliente;
			numClientes++;
		} else {
			System.out.println("No se pueden añadir más clientes");
		}
	}
	
	public void bajaCliente(Cliente cliente) {
		for(int i=0; i < numClientes; i++) {
			if(clientes[i].equals(cliente)) {
				// Dejaría un hueco vacío aprovechable.
				clientes[i] = null;
				this.numClientes--;
			} else {
				System.out.println("El cliente no se ha encontrado");
			}
		}
	}
	
	public void setCoche(Coche coche) {
		if(coche != null) {
			this.cocheEmpresa = coche;
		} else {
			System.out.println("Ha pasado un objeto Coche nulo");
		}
	}
	
	public Coche getCocheEmpresa() {
		return cocheEmpresa;
	}

	public String getAreaVenta() {
		return areaVenta;
	}

	public String getMovil() {
		return movil;
	}

	public Cliente[] getClientes() {
		return clientes;
	}

	public int getNumClientes() {
		return numClientes;
	}

	public int getCOMISION() {
		return COMISION;
	}

	public int getINCREMENTO_VENDEDOR() {
		return INCREMENTO_VENDEDOR;
	}

	public int getMAX_VENDEDORES() {
		return MAX_VENDEDORES;
	}

	@Override
	public String toString() {
		return "Vendedor [movil=" + movil + ", getNombre()=" + getNombre() + ", getApellido1()=" + getApellido1()
				+ ", getApellido2()=" + getApellido2() + ", getDni()=" + getDni() + ", getDireccion()=" + getDireccion()
				+ ", getTelefono()=" + getTelefono() + ", getClass()=" + getClass().getName() + "]";
	}
	
}
