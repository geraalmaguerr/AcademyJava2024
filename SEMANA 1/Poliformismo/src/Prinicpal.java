// Clase principal que contiene el método main para ejecutar el programa
public class Prinicpal {

	public static void main(String[] args) {
		
		// Crear una instancia de receptor usando la clase base qb
		qb pase1 = new receptor();
		System.out.println("El Quaterback lanza pase a receptor");
		// Llamar al método lanzarPase en el objeto receptor
		pase1.lanzarPase();
		
		// Crear una instancia de corredor usando la clase base qb
		qb pase2 = new corredor();
		System.out.println("El Quaterback lanza pase a corredor");
		// Llamar al método lanzarPase en el objeto corredor
		pase2.lanzarPase();
		
	}
	
}
