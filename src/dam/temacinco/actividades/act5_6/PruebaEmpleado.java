package dam.temacinco.actividades.act5_6;
/**
 * Prueba del ejercicio 5.6
 * @author LuciaLM
 * @version 1.0
 */
public class PruebaEmpleado {
	public static void main(String[] args) {
		// Esto comprueba que la clase abstracta empleado no se puede instanciar:
		// todos los Empleados deben ser vendedores, jefes de zona o secretarios, 
		// como pide el enunciado:
		// Empleado empleado = new Empleado();
		Coche coche = new Coche("1234ABC", "Toyota", "CH-R");
		Secretario secretario = new Secretario("Nombre", "Apellido", "González", "12345678A", "España", "666666666", 1000, 2);
		secretario.incrementarSalario();
		System.out.println(secretario.salario);
		System.out.println(secretario.toString());
		Vendedor vendedor = new Vendedor("Nombre", "Apellido", "González", "12345678B", "España", "666666666", 1500, 5);
		vendedor.incrementarSalario();
		System.out.println(vendedor.salario);
		JefeZona jefe = new JefeZona("Nombre", "Apellido", "González", "12345678C", "España", "666666666", 2000, 10);
		jefe.incrementarSalario();
		System.out.println(jefe.salario);
		// No tiene mucho sentido pero demuestra que el recorrido del array funciona.
		// Muestra un mensaje en lugar de la excepción (robusto).
		jefe.altaVendedor(vendedor);
		jefe.altaVendedor(vendedor);
		jefe.altaVendedor(vendedor);
		jefe.altaVendedor(vendedor);
		jefe.altaVendedor(vendedor);
		jefe.altaVendedor(vendedor);
		jefe.altaVendedor(vendedor);
		jefe.altaVendedor(vendedor);
		jefe.altaVendedor(vendedor);
		jefe.altaVendedor(vendedor);
		jefe.altaVendedor(vendedor);
		jefe.getVendedores();
		
		jefe.cambiarCoche(coche);
		jefe.cambiarSecretario(secretario);
		System.out.println(jefe.getCoche());
		System.out.println(jefe.getSecretario());
	}

}
