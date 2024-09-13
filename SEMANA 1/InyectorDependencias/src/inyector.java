// Clase que actúa como un proveedor de notificaciones para los celulares
public class inyector {

    // Método estático para inyectar una notificación específica en un celular
    static celular inyectarNotificacion(String nombre, tipoNot metodo) {
        switch(metodo) {
            case EMAIL: 
                // Crear un celular con notificación por email
                return new celular(nombre, new email("Correo con imágenes"));
            case SMS:
                // Crear un celular con notificación por SMS
                return new celular(nombre, new sms("Mensaje de texto"));
            case WHATSAPP:
                // Crear un celular con notificación por WhatsApp
                return new celular(nombre, new whatsapp("Mensaje de voz"));
            default:
                // Excepción para métodos de mensaje no soportados
                throw new UnsupportedOperationException("Método de mensaje no existe");
        }
    }
}