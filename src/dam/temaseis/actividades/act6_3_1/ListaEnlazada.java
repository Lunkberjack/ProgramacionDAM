package dam.temaseis.actividades.act6_3_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListaEnlazada {
	private ArrayList<Empleado> empleados;
	
	public ListaEnlazada() {
		this.setEmpleados(new ArrayList<Empleado>());
	}
	
	public static void main(String[] args) {
		ListaEnlazada lista = new ListaEnlazada();
		Empleado emp = new Empleado("a", "b", "c", "111111111", "12345678A");
		Empleado emp2 = new Empleado("d", "e", "f", "222222222", "23456789B");
		Empleado emp3 = new Empleado("g", "h", "i", "333333333", "34567891C");

		lista.aniadirEmp(emp);
		lista.aniadirEmp(emp2);
		lista.aniadirEmp(emp3);
		
		// Muestra todos los empleados(cada uno con el formato personalizado)
		// con el formato toString() de las ArrayList en conjunto.
		System.out.println(lista.getEmpleados());
		
		lista.buscarNif("23456789B");
		lista.modificarEmpleado("23456789B");
		lista.ordenarLista();
		System.out.println(lista.getEmpleados());
		
		lista.eliminarEmp("23456789B");
		System.out.println(lista.getEmpleados());
	}
	
	/**
	 * Recorre la lista enlazada y busca si alg?n empleado tiene el nif
	 * del par?metro. Si no lo encuentra, devuelve nulo.
	 * @param nif
	 * @return
	 */
	public String buscarNif(String nif) {
		for(Empleado x : getEmpleados()) {
			if(x.nif == nif) {
				System.out.println(x.toString());
				return nif;
			}
		}
		System.out.println("No hay ning?n empleado con ese nif.");
		return null;
	}
	
	/**
	 * Permite modificar cualquier atributo de un empleado
	 * del que se conozca el NIF.
	 * @param nif
	 */
	public void modificarEmpleado(String nif) {
		if(buscarNif(nif) != null) {
			for(Empleado x : getEmpleados()) {
				if(x.nif == nif) {
					int respuesta;
					Scanner scan = new Scanner(System.in);
					do {
					System.out.println("?Qu? propiedad quieres modificar?\n"
							+ "1: Nombre\n"
							+ "2: Apellido 1\n"
							+ "3: Apellido 2\n"
							+ "4: Tel?fono\n"
							+ "5: NIF");
					respuesta = scan.nextInt();
					} while (respuesta <= 0 || respuesta > 5);
					
					switch(respuesta) {
					// Suponemos que se pasan valores aceptables a los setters
					// (al ser String, los valores err?neos son dif?ciles de controlar).
					case 1:
						System.out.println("Introduce nombre: ");
						String nombreAux = scan.next();
						x.setNombre(nombreAux);
						break;
					case 2:
						System.out.println("Introduce primer apellido: ");
						String apellAux1 = scan.next();
						x.setApellido1(apellAux1);
						break;
					case 3:
						System.out.println("Introduce segundo apellido: ");
						String apellAux2 = scan.next();
						x.setApellido2(apellAux2);
						break;
					case 4:
						System.out.println("Introduce tel?fono: ");
						String telAux = scan.next();
						x.setTelefono(telAux);
						break;
					case 5:
						System.out.println("Introduce NIF: ");
						String nifAux = scan.next();
						x.setNif(nifAux);
						break;
					default:
						System.out.println(x.toString());
						break;
					}
					System.out.println(x.toString());
				}
			}
		}
	}
	
	/**
	 * Elimina un objeto de la ArrayList.
	 * @param nif
	 */
	public void eliminarEmp(String nif) {
		if(buscarNif(nif) != null) {
			for(Empleado x : getEmpleados()) {
				if(x.nif == nif) {
					// Se llama al m?todo ya implementado.
					// Tambi?n se podr?a declarar como nulo, aunque dejar?a un hueco.
					this.getEmpleados().remove(x);
				}
			}
		}
	}
	
	/**
	 * Hace uso de la funci?n ya implementada add para a?adir un empleado nuevo.
	 * No s? si es lo que pide el enunciado, pero he intentado acceder a posiciones 
	 * concretas de la lista como un array y no me lo permite, por lo que no se me 
	 * ocurre otra manera de hacerlo.
	 * @param emp
	 */
	public void aniadirEmp(Empleado emp) {
		this.getEmpleados().add(emp);
	}
	
	public void ordenarLista() {
		Collections.sort(this.getEmpleados());
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
}