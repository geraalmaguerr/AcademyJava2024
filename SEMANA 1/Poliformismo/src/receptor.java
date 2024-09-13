// Clase que representa un receptor heredando de la clase qb
public class receptor extends qb {

    // Implementación del método abstracto lanzarPase de la clase base qb
    @Override
    void lanzarPase() {
        // Imprime en consola que el pase ha sido completo
        System.out.println("Pase Completo");
    }
}