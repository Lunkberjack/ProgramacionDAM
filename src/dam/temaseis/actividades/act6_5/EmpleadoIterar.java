package dam.temaseis.actividades.act6_5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import dam.temaseis.actividades.act6_3_1.Empleado;
/**
 *  Añade un nuevo empleado en la lista después de un empleado existente cuya edad sea igual
 *  o inferior.
 *  Elimina de la lista el empleado con mayor antigüedad en la empresa.
 *  Modifica la antigüedad del último empleado en la lista.
 *  
 * @author LuciaLM
 * @version 1.0
 */
public class EmpleadoIterar {
private ArrayList<Empleado> empleados;
private Iterator<Empleado> it;
	
	public EmpleadoIterar() {
		this.empleados = new ArrayList<Empleado>();
	}
	
	public static void main(String[] args) {
		EmpleadoIterar lista = new EmpleadoIterar();
		it = empleados.iterator();
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
		
		// Añadir empleado con edad superior (suponemos que la lista está ordenada)
		while()
	}
	
	private Empleado[] getEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Recorre la lista enlazada y busca si algún empleado tiene el nif
	 * del parámetro. Si no lo encuentra, devuelve nulo.
	 * @param nif
	 * @return
	 */
	public String buscarNif(String nif) {
		for(Empleado x : empleados) {
			if(x.getNif() == nif) {
				System.out.println(x.toString());
				return nif;
			}
		}
		System.out.println("No hay ningún empleado con ese nif.");
		return null;
	}
	
	/**
	 * Permite modificar cualquier atributo de un empleado
	 * del que se conozca el NIF.
	 * @param nif
	 */
	public void modificarEmpleado(String nif) {
		if(buscarNif(nif) != null) {
			for(Empleado x : empleados) {
				if(x.getNif() == nif) {
					int respuesta;
					Scanner scan = new Scanner(System.in);
					do {
					System.out.println("¿Qué propiedad quieres modificar?\n"
							+ "1: Nombre\n"
							+ "2: Apellido 1\n"
							+ "3: Apellido 2\n"
							+ "4: Teléfono\n"
							+ "5: NIF");
					respuesta = scan.nextInt();
					} while (respuesta <= 0 || respuesta > 5);
					
					switch(respuesta) {
					// Suponemos que se pasan valores aceptables a los setters
					// (al ser String, los valores erróneos son difíciles de controlar).
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
						System.out.println("Introduce teléfono: ");
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
					scan.close();
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
			for(Empleado x : empleados) {
				if(x.getNif() == nif) {
					// Se llama al método ya implementado.
					// También se podría declarar como nulo, aunque dejaría un hueco.
					this.empleados.remove(x);
				}
			}
		}
	}
	
	/**
	 * Hace uso de la función ya implementada add para añadir un empleado nuevo.
	 * No sé si es lo que pide el enunciado, pero he intentado acceder a posiciones 
	 * concretas de la lista como un array y no me lo permite, por lo que no se me 
	 * ocurre otra manera de hacerlo.
	 * @param emp
	 */
	public void aniadirEmp(Empleado emp) {
		this.empleados.add(emp);
	}
	
	public void ordenarLista() {
		Collections.sort(this.empleados);
	}
}