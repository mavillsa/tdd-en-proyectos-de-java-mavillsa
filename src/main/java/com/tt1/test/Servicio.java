package com.tt1.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Contiene la lógica principal del negocio para gestionar las tareas.
 * Se encarga de coordinar la creación de tareas, el envío de notificaciones
 * y la verificación de caducidad utilizando un Repositorio y un servicio de correo.
 */
public class Servicio {
    private Repositorio repositorio;
    private MailerStub mailer;

    /**
     * Constructor del servicio.
     * @param repositorio El repositorio para acceder y guardar datos.
     * @param mailer El servicio encargado de enviar correos electrónicos.
     */
    public Servicio(Repositorio repositorio, MailerStub mailer) {
        this.repositorio = repositorio;
        this.mailer = mailer;
    }

    /**
     * Revisa todas las tareas almacenadas y comprueba si alguna ha superado su fecha límite sin ser completada.
     * Si encuentra tareas caducadas, envía una alerta por correo a todos los emails registrados.
     */
    public void verificarYAlertarCaducados() {
        List<ToDo> todas = repositorio.obtenerTodasLasTareas();
        List<String> emails = repositorio.obtenerEmails();

        for (ToDo t : todas) {
            // Si no está completada y la fecha ya pasó
            if (!t.isCompletado() && t.getFechaLimite().isBefore(LocalDate.now())) {
                for (String email : emails) {
                    mailer.enviarCorreo(email, "¡Alerta! Tarea caducada: " + t.getNombre());
                }
            }
        }
    }

    /**
     * Crea una nueva tarea en el sistema y automáticamente verifica si hay tareas caducadas.
     * @param nombre El nombre de la nueva tarea (no puede estar vacío).
     * @param fechaLimite La fecha límite para la tarea.
     * @throws IllegalArgumentException si el nombre proporcionado es nulo o está vacío.
     */
    public void crearToDo(String nombre, LocalDate fechaLimite) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        repositorio.guardarToDo(new ToDo(nombre, "", fechaLimite));
        verificarYAlertarCaducados();
    }

    /**
     * Añade un nuevo correo electrónico a la lista de notificaciones y verifica tareas caducadas.
     * @param email La dirección de correo electrónico a añadir (debe contener un símbolo '@').
     * @throws IllegalArgumentException si el formato del correo es inválido.
     */
    public void agregarEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        repositorio.guardarEmail(email);
        verificarYAlertarCaducados();
    }

    /**
     * Marca una tarea específica como completada y posteriormente verifica si hay otras tareas caducadas.
     * @param nombre El nombre exacto de la tarea que se desea finalizar.
     */
    public void finalizarTarea(String nombre) {
        repositorio.marcarCompletado(nombre);
        verificarYAlertarCaducados();
    }

    /**
     * Devuelve una lista de las tareas que aún no han sido completadas.
     * Antes de consultar, realiza una verificación de tareas caducadas para enviar alertas si es necesario.
     * @return Una lista de objetos ToDo que están pendientes.
     */
    public List<ToDo> consultarPendientes() {
        verificarYAlertarCaducados();
        List<ToDo> pendientes = new ArrayList<>();
        for (ToDo t : repositorio.obtenerTodasLasTareas()) {
            if (!t.isCompletado()) {
                pendientes.add(t);
            }
        }
        return pendientes;
    }
}