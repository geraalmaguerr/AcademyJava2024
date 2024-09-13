// Clase que representa corredor heredando de la clase qb
public class corredor extends qb {

    // Implementación del método abstracto lanzarPase de la clase base qb
    @Override
    void lanzarPase() {
        // Imprime en consola que el pase ha sido incompleto
        System.out.println("Pase Incompleto");
    }
}