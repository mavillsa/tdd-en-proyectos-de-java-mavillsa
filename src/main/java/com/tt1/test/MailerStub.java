package com.tt1.test;

/**
 * Clase que actúa como un doble de pruebas (Stub) para el servicio de correos.
 * Simula el envío de correos electrónicos para poder probar la lógica de
 * notificaciones del Servicio sin enviar emails reales.
 */
public class MailerStub {

    /**
     * Simula el envío de un correo electrónico imprimiendo el resultado por consola.
     * * @param direccion La dirección de correo del destinatario.
     * @param mensaje El contenido del correo a enviar.
     * @return true si el correo se ha "enviado" correctamente.
     */
    public boolean enviarCorreo(String direccion, String mensaje) {
        System.out.println("Enviando correo a: " + direccion);
        System.out.println("Mensaje: " + mensaje);
        return true;
    }
}