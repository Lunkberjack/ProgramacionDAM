package dam.temaseis.listas;
import java.util.LinkedList;
/**
 * 
 * @author lucia
 * @version 1.0
 */
public class TestSort {
	public static void main(String[] args) {
		LinkedList<Empleado> empleados = new LinkedList<Empleado>();
		Empleado emp1 = new Empleado("Rafa", "12345678A");
		Empleado emp2 = new Empleado("Antonio", "14345678S");
		Empleado emp3 = new Empleado("Almudena", "12343228S");
		empleados.add(emp1);
		empleados.add(emp2);
		empleados.add(emp3);
		
		empleados.sort(emp1);
		for(Empleado x : empleados) {
			System.out.println(x);
		}
	}

}
