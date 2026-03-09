package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que actúa como un doble de pruebas (Stub) para la base de datos.
 * Guarda la información temporalmente en memoria (usando listas) en lugar de
 * en una base de datos real, permitiendo aislar los tests.
 */
public class DBStub {
    private List<ToDo> tareas = new ArrayList<>();
    private List<String> emails = new ArrayList<>();

    /**
     * Añade una nueva tarea a la base de datos simulada.
     * * @param tarea El objeto ToDo que se desea guardar.
     */
    public void crearTarea(ToDo tarea) {
        tareas.add(tarea);
    }

    /**
     * Busca una tarea por su nombre en la base de datos simulada.
     * * @param nombre El nombre exacto de la tarea a buscar.
     * @return El objeto ToDo si se encuentra, o null si no existe.
     */
    public ToDo leerTarea(String nombre) {
        for (ToDo t : tareas) {
            if (t.getNombre().equals(nombre)) return t;
        }
        return null;
    }

    /**
     * Actualiza los datos de una tarea existente.
     * * @param tarea El objeto ToDo con los datos actualizados.
     */
    public void actualizarTarea(ToDo tarea) {
        ToDo t = leerTarea(tarea.getNombre());
        if (t != null) {
            t.setDescripcion(tarea.getDescripcion());
            t.setFechaLimite(tarea.getFechaLimite());
            t.setCompletado(tarea.isCompletado());
        }
    }

    /**
     * Elimina una tarea de la base de datos simulada basándose en su nombre.
     * * @param nombre El nombre de la tarea que se desea borrar.
     */
    public void borrarTarea(String nombre) {
        tareas.removeIf(t -> t.getNombre().equals(nombre));
    }

    /**
     * Guarda una dirección de correo electrónico en la lista simulada.
     * * @param email La dirección de correo a guardar.
     */
    public void guardarEmail(String email) {
        emails.add(email);
    }

    /**
     * Recupera la lista completa de correos electrónicos guardados.
     * * @return Una lista de tipo String con los emails.
     */
    public List<String> obtenerEmails() {
        return emails;
    }

    /**
     * Recupera la lista completa de todas las tareas guardadas.
     * * @return Una lista con todos los objetos ToDo.
     */
    public List<ToDo> obtenerTodasLasTareas() {
        return tareas;
    }
}