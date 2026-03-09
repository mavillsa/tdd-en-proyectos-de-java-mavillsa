package com.tt1.test;

import java.util.List;

/**
 * Gestiona el almacenamiento y recuperación de las tareas (ToDo) y los correos electrónicos.
 * Actúa como intermediario entre la lógica de negocio y la base de datos subyacente.
 */
public class Repositorio {
    private DBStub db;

    /**
     * Constructor del repositorio.
     * @param db La instancia de la base de datos (o stub) que se utilizará para almacenar los datos.
     */
    public Repositorio(DBStub db) {
        this.db = db;
    }

    /**
     * Busca una tarea específica por su nombre.
     * @param nombre El nombre exacto de la tarea a buscar.
     * @return El objeto ToDo si se encuentra, o null si no existe.
     */
    public ToDo encontrarToDo(String nombre) {
        return db.leerTarea(nombre);
    }

    /**
     * Marca una tarea existente como completada.
     * Busca la tarea por su nombre y actualiza su estado en la base de datos.
     * @param nombre El nombre de la tarea que se desea finalizar.
     */
    public void marcarCompletado(String nombre) {
        ToDo t = db.leerTarea(nombre);
        if (t != null) {
            t.setCompletado(true);
            db.actualizarTarea(t);
        }
    }

    /**
     * Guarda una nueva tarea en la base de datos.
     * @param tarea El objeto ToDo que se desea almacenar.
     */
    public void guardarToDo(ToDo tarea) {
        db.crearTarea(tarea);
    }

    /**
     * Almacena una dirección de correo electrónico en el sistema para futuras notificaciones.
     * @param email El correo electrónico a guardar.
     */
    public void guardarEmail(String email) {
        db.guardarEmail(email);
    }

    /**
     * Recupera todos los correos electrónicos almacenados en el sistema.
     * @return Una lista de cadenas con las direcciones de email.
     */
    public List<String> obtenerEmails() {
        return db.obtenerEmails();
    }

    /**
     * Recupera todas las tareas registradas en la base de datos.
     * @return Una lista con todos los objetos ToDo.
     */
    public List<ToDo> obtenerTodasLasTareas() {
        return db.obtenerTodasLasTareas();
    }
}