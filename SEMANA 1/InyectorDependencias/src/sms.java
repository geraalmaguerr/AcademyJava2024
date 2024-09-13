// Implementación de la notificación por SMS
public class sms implements notificacion {

    private String metodo; // Tipo de notificación

    public sms(String metodo) {
        this.metodo = metodo;
    }

    @Override
    public void recibirNot() {
    	System.out.println("Se recibió una notificación de SMS: " + metodo);
    }
}