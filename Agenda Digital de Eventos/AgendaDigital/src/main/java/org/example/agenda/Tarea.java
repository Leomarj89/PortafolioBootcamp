package org.example.agenda;

import java.time.LocalDate;

public class Tarea {
    private int id;
    private String descripcion;
    private LocalDate fecha;
    private boolean completada;

    // Constructor
    public Tarea(int id, String descripcion, LocalDate fecha) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.completada = false; // por defecto está pendiente
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", estado=" + (completada ? "Completada" : "Pendiente") +
                '}';
    }
}