// Implementación de la notificación por WhatsApp
public class whatsapp implements notificacion {

    private String metodo; // Tipo de notificación

    public whatsapp(String metodo) {
        this.metodo = metodo;
    }

    @Override
    public void recibirNot() {
    	System.out.println("Se recibió una notificación de WHATSAPP: " + metodo);
    }
}
