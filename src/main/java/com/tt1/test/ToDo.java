package com.tt1.test;
import java.time.LocalDate;

/**
 * Representa una tarea o "ToDo" dentro del sistema.
 * Contiene la información básica de una tarea, como su nombre, descripción, fecha límite y estado de completitud.
 */
public class ToDo {
    private String nombre;
    private String descripcion;
    private LocalDate fechaLimite;
    private boolean completado;

    /**
     * Constructor para crear una nueva tarea.
     * Al crearse, la tarea se inicializa siempre como no completada.
     *
     * @param nombre El nombre o título corto de la tarea.
     * @param descripcion Los detalles extendidos de la tarea.
     * @param fechaLimite La fecha tope para finalizar la tarea.
     */
    public ToDo(String nombre, String descripcion, LocalDate fechaLimite) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.completado = false;
    }

    /**
     * Obtiene el nombre de la tarea.
     * @return El nombre de la tarea.
     */
    public String getNombre() { return nombre; }

    /**
     * Verifica si la tarea está completada.
     * @return true si la tarea está finalizada, false en caso contrario.
     */
    public boolean isCompletado() { return completado; }

    /**
     * Cambia el estado de completitud de la tarea.
     * @param completado true para marcarla como finalizada, false para pendiente.
     */
    public void setCompletado(boolean completado) { this.completado = completado;}

    /**
     * Obtiene la fecha límite de la tarea.
     * @return La fecha tope asignada.
     */
    public LocalDate getFechaLimite() { return fechaLimite; }

    /**
     * Modifica la fecha límite de la tarea.
     * @param fechaLimite La nueva fecha tope.
     */
    public void setFechaLimite(LocalDate fechaLimite) { this.fechaLimite = fechaLimite; }

    /**
     * Obtiene la descripción detallada de la tarea.
     * @return La descripción de la tarea.
     */
    public String getDescripcion() { return descripcion; }

    /**
     * Modifica la descripción de la tarea.
     * @param descripcion El nuevo texto descriptivo.
     */
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}