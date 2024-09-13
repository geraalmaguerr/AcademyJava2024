public class Principal {
    public static void main(String[] args) {
        // Obtener la instancia única de DB
        DB db = DB.getInstance();

        // Mostrar la configuración actual
        System.out.println("Configuración inicial: " + db.getConfiguracion());

        // Cambiar la configuración
        db.setConfiguracion("Nueva configuración");

        // Mostrar la configuración actualizada
        System.out.println("Configuración actualizada: " + db.getConfiguracion());
    }
}