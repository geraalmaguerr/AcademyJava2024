public class DB {
    private static DB instanciaUnica;
    private String configuracion;

    // Constructor privado para evitar instanciación
    private DB() {
        configuracion = "Configuración por defecto";
    }

    // Método estático para obtener la instancia única
    public static DB getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new DB();
        }
        return instanciaUnica;
    }

    // Métodos para obtener y establecer la configuración
    public String getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(String configuracion) {
        this.configuracion = configuracion;
    }
}