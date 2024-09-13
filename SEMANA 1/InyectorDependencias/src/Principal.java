// Clase principal para probar la inyección de dependencias
public class Principal {

    public static void main(String[] args) {

        // Crear un celular con notificación por email
        celular cel1 = inyector.inyectarNotificacion("iPhone", tipoNot.EMAIL);
        cel1.servicioNoti(); // Mostrar el servicio de notificación para el iPhone
        
        // Crear un celular con notificación por SMS
        celular cel2 = inyector.inyectarNotificacion("Android", tipoNot.SMS);
        cel2.servicioNoti(); // Mostrar el servicio de notificación para el Android
        
        // Crear un celular con notificación por WhatsApp
        celular cel3 = inyector.inyectarNotificacion("Huawei", tipoNot.WHATSAPP);
        cel3.servicioNoti(); // Mostrar el servicio de notificación para el Huawei
        
    }

}